package es;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import es.backend.Comparador;
import es.backend.GestorCartera;
import es.backend.GestorCarteraImpl;
import es.backend.Importador;
import es.backend.InformacionMercado;
import es.backend.productosfinancieros.FondoInversionMixto;
import es.backend.productosfinancieros.FondoInversionRentaFija;
import es.backend.productosfinancieros.FondoInversionRentaVariable;
import es.backend.productosfinancieros.ProductoFinanciero;
import es.backend.productosfinancieros.ProductoFinancieroFactory;
import es.backend.productosfinancieros.Sector;
import es.backend.repositorios.FondoInversionMixtoDAO;
import es.backend.repositorios.FondoInversionRentaFijaDAO;
import es.backend.repositorios.FondoInversionRentaVariableDAO;
import es.backend.repositorios.ImportadorDAO;
import es.backend.repositorios.UsuarioDAO;
import es.backend.usuarios.Usuario;

@SpringBootApplication
@PropertySource({ "logging.properties" })
@ImportResource({ "classpath:config/jpa-config.xml" })
public class MisInversionesApplication {

	private static final Logger log = LoggerFactory.getLogger(MisInversionesApplication.class);

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);
		// Este es el constructor que deseo utilizar para crear los Productos
		// financieros, solo he declarado uno, pero podría haber declarado más
		Class<?> argumentos[] = new Class[] { String.class, String.class, Sector.class, int.class };

		// Asigno los valores a los parámetros anteriores para los productos que crearé
		Object[] valorArgumentos1 = { "SP500", "Amundi", Sector.CONSUMO_CICLICO, 555555 };
		Object[] valorArgumentos2 = { "Mid Tem", "Pictet", Sector.INDUSTRIA, 478120 };
		Object[] valorArgumentos3 = { "Edeficandi", "Axa", Sector.CONSUMO_DEFENSIVO, 742069 };

		// Llamo al factory y creo los productos
		ProductoFinanciero producto1 = ProductoFinancieroFactory
				.crearProductoFinanciero(FondoInversionRentaVariable.class, argumentos, valorArgumentos1);
		ProductoFinanciero producto2 = ProductoFinancieroFactory.crearProductoFinanciero(FondoInversionRentaFija.class,
				argumentos, valorArgumentos2);
		ProductoFinanciero producto3 = ProductoFinancieroFactory.crearProductoFinanciero(FondoInversionMixto.class,
				argumentos, valorArgumentos3);

		// Me creo un par de usuarios
		Usuario usuario1 = new Usuario("Juan");
		Usuario usuario2 = new Usuario("Victoria");

		// creo el gestor de cartera que implica una cartera y un importador, además de
		// setearle la fecha actual
		// todas las operaciones se harán siempre a traves del GESTORCARTERA
		GestorCartera<ProductoFinanciero> miGestorCartera = new GestorCarteraImpl();

		// le doy nombre a mi cartera
		miGestorCartera.asignarNombre("CarteraAgresiva");

		// asocio los dos usuarios con esta cartera, los listo, elimino 1 y los vuelvo a
		// listar
		miGestorCartera.altaUsuario(usuario1);
		miGestorCartera.altaUsuario(usuario2);
		miGestorCartera.listarUsuarios();
		miGestorCartera.bajaUsuario(usuario1);
		miGestorCartera.listarUsuarios();

		// compro para mi cartera los productos que habia creado con el factory,
		// asociandole el importe que invierto
		// los listo
		miGestorCartera.compraProductoFinanciero(producto1, 1000);
		miGestorCartera.compraProductoFinanciero(producto2, 2000);
		miGestorCartera.compraProductoFinanciero(producto3, 3000);
		miGestorCartera.listarProductos();

		// vendo el total de un producto, y parte del otro
		miGestorCartera.vendeProductoFinanciero(producto1, 1000);
		miGestorCartera.vendeProductoFinanciero(producto2, 1000);
		// los listo para ver que funcionan bien los metodos
		miGestorCartera.listarProductos();
		// compruebo el capital total
		log.warn(String.valueOf(miGestorCartera.getCapitalTotal()));

		// Importo los datos de los valores actuales del mercado a traves del Importador
		// y un csv que he creado yo mismo
		miGestorCartera.importarDatos();

		// Aquí voy a probar el comparador que no aporta nada a este negocio, mas que
		// probar que se sabe hacer
		// Como tengo limitado, a posta, el acceso a getUsuarios() de la cartera, voy a
		// meter los usuarios que tengo y otro que creo nuevo y se llama igual Juan
		// en una nueva lista para que el comparador los ordene
		// El Comparador no está en el UML, porque no aporta nada al negocio
		List<Usuario> miListaAordenar = new ArrayList<>();
		Usuario usuario3 = new Usuario("Juan");
		miListaAordenar.add(usuario1);
		miListaAordenar.add(usuario2);
		miListaAordenar.add(usuario3);
		Comparador.ordenarUsuarios(miListaAordenar);
		System.out.println(miListaAordenar);
		System.out.println("\n");

		// con la info del mercado importada y la info de la inversion hecha que está
		// en el Map, calculo la rentabilidad de la cartera
		// Funciona correctamente, con los datos que hay da un 100% de rentabilidad que
		// es lo que tiene que dar, puesto que el valor de mercado es justo el doble de
		// lo que invertí
		miGestorCartera.caculaRentabilidad();

		/*
		 * Aqui voy a probar mi BBDD h2 guardando los 2 usuarios Lo hago usando
		 */
		UsuarioDAO usuarioDAO = context.getBean(UsuarioDAO.class);
		usuarioDAO.save(usuario1);
		usuarioDAO.save(usuario2);
		List<Usuario> usuarios = usuarioDAO.findAll();
		usuarios.stream().map(Usuario::toString).forEach(log::info);

		/*
		 * Aqui voy a guardar en la BBDD los productos financieros, lo hago con con
		 * configuracion del ORM con XML la variable debe ser de la clase, no de la
		 * interfaz, por eso el casteo uso configuracion de ORM con XML con herencia El
		 * sector del fondo viene de un Enum y no se como persistirlo Los campos
		 * estaticos, en este caso es el riesgo, tampoco se persiste
		 */
		FondoInversionRentaVariableDAO fondoInversionRentaVariableDAO = context
				.getBean(FondoInversionRentaVariableDAO.class);
		FondoInversionRentaFijaDAO fondoInversionRentaFijaDAO = context.getBean(FondoInversionRentaFijaDAO.class);
		FondoInversionMixtoDAO fondoInversionMixtoDAO = context.getBean(FondoInversionMixtoDAO.class);

		// voy a crear otro producto mas
		Object[] valorArgumentos4 = { "NN (L) Smart Connectivity - P Cap EUR", "NN Investment Partners BV",
				Sector.TECNOLOGIA, 192961 };
		ProductoFinanciero producto4 = ProductoFinancieroFactory
				.crearProductoFinanciero(FondoInversionRentaVariable.class, argumentos, valorArgumentos4);

		fondoInversionRentaVariableDAO.save((FondoInversionRentaVariable) producto1);
		fondoInversionRentaVariableDAO.save((FondoInversionRentaVariable) producto4);
		fondoInversionRentaFijaDAO.save((FondoInversionRentaFija) producto2);
		fondoInversionMixtoDAO.save((FondoInversionMixto) producto3);

		// Aquí voy a guardar en la BBDD la info importada vía csv, usando anotaciones,
		// NO por xml
		//https://www.oscarblancarteblog.com/2018/12/20/relaciones-onetomany/
		ImportadorDAO infoMercadoImportada = context.getBean(ImportadorDAO.class);
	
		infoMercadoImportada.save(((GestorCarteraImpl) miGestorCartera).getImportador());

		context.close();
	}

}
