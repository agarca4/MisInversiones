package es;

import java.io.IOException;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import es.backend.GestorCartera;
import es.backend.GestorCarteraImpl;
import es.backend.productosfinancieros.ProductoFinancieroImpl;
import es.backend.productosfinancieros.Sector;
import es.backend.productosfinancieros.Tipo;
import es.backend.repositorios.CarteraInversionDAO;
import es.backend.repositorios.ImportadorDAO;
import es.backend.usuarios.Usuario;

@SpringBootApplication
@PropertySource({ "logging.properties" })
@ImportResource({ "classpath:config/jpa-config.xml" })
public class MisInversionesApplication {

	private static final Logger log = LoggerFactory.getLogger(MisInversionesApplication.class);
	private static GestorCartera<ProductoFinancieroImpl> miGestorCartera = new GestorCarteraImpl();

	protected static GestorCartera<ProductoFinancieroImpl> getMiGestorCartera() {
		return miGestorCartera;
	}

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

		// creo los productos
		ProductoFinancieroImpl producto1 = new ProductoFinancieroImpl("SP500", "Amundi", Sector.CONSUMO_CICLICO, 555555,
				Tipo.RENTA_VARIABLE);
		ProductoFinancieroImpl producto2 = new ProductoFinancieroImpl("Mid Tem", "Pictetd", Sector.INDUSTRIA, 478120,
				Tipo.RENTA_FIJA);
		ProductoFinancieroImpl producto3 = new ProductoFinancieroImpl("Edeficandi", "Axa", Sector.CONSUMO_DEFENSIVO,
				742069, Tipo.MIXTO);

		// Me creo un par de usuarios
		Usuario usuario1 = new Usuario("Juan");
		Usuario usuario2 = new Usuario("Victoria");

		// creo el gestor de cartera que implica una cartera y un importador, además de
		// setearle la fecha actual
		// todas las operaciones se harán siempre a traves del GESTORCARTERA
		// GestorCartera<ProductoFinancieroImpl> miGestorCartera = new
		// GestorCarteraImpl();

		// le doy nombre a mi cartera
		getMiGestorCartera().asignarNombre("CarteraAgresiva");

		// asocio los dos usuarios con esta cartera, los listo, elimino 1 y los vuelvo a
		// listar
		getMiGestorCartera().altaUsuario(usuario1);
		getMiGestorCartera().altaUsuario(usuario2);
//		miGestorCartera.listarUsuarios();
//		miGestorCartera.bajaUsuario(usuario1);
//		miGestorCartera.listarUsuarios();

		// compro para mi cartera los productos que habia creado con el factory,
		// asociandole el importe que invierto
		// los listo
		getMiGestorCartera().compraProductoFinanciero(producto1, 1000);
		getMiGestorCartera().compraProductoFinanciero(producto2, 2000);
		getMiGestorCartera().compraProductoFinanciero(producto3, 3000);
		// miGestorCartera.listarProductos();

		// vendo el total de un producto, y parte del otro
//		miGestorCartera.vendeProductoFinanciero(producto1, 1000);
//		miGestorCartera.vendeProductoFinanciero(producto2, 1000);
//		// los listo para ver que funcionan bien los metodos
//		miGestorCartera.listarProductos();
		// compruebo el capital total
		// log.warn(String.valueOf(miGestorCartera.getCapitalTotal()));

		// Importo los datos de los valores actuales del mercado a traves del Importador
		// y un csv que he creado yo mismo
		// miGestorCartera.importarDatos();

		// con la info del mercado importada y la info de la inversion hecha que está
		// en el Map, calculo la rentabilidad de la cartera
		// Funciona correctamente, con los datos que hay da un 100% de rentabilidad que
		// es lo que tiene que dar, puesto que el valor de mercado es justo el doble de
		// lo que invertí
		// miGestorCartera.caculaRentabilidad();

		// Aquí voy a probar el nuevo metodo consultarCartera();
		getMiGestorCartera().consultarCartera();

		/*
		 * Aqui voy a probar mi BBDD h2 guardando los 2 usuarios Lo hago usando
		 */
//		UsuarioDAO usuarioDAO = context.getBean(UsuarioDAO.class);
//		usuarioDAO.save(usuario1);
//		usuarioDAO.save(usuario2);

		/*
		 * Aqui voy a guardar en la BBDD los productos financieros, lo hago con con
		 * configuracion del ORM con XML la variable debe ser de la clase, no de la
		 * interfaz, por eso el casteo uso configuracion de ORM con XML con herencia El
		 * sector del fondo viene de un Enum y no se como persistirlo Los campos
		 * estaticos, en este caso es el riesgo, tampoco se persiste
		 */
//		FondoInversionRentaVariableDAO fondoInversionRentaVariableDAO = context
//				.getBean(FondoInversionRentaVariableDAO.class);
//		FondoInversionRentaFijaDAO fondoInversionRentaFijaDAO = context.getBean(FondoInversionRentaFijaDAO.class);
//		FondoInversionMixtoDAO fondoInversionMixtoDAO = context.getBean(FondoInversionMixtoDAO.class);

		// voy a crear otro producto mas
//		Object[] valorArgumentos4 = { "NN (L) Smart Connectivity - P Cap EUR", "NN Investment Partners BV",
//				Sector.TECNOLOGIA, 192961 };
//		ProductoFinanciero producto4 = ProductoFinancieroFactory
//				.crearProductoFinanciero(FondoInversionRentaVariable.class, argumentos, valorArgumentos4);
//
//		fondoInversionRentaVariableDAO.save((FondoInversionRentaVariable) producto1);
//		fondoInversionRentaVariableDAO.save((FondoInversionRentaVariable) producto4);
//		fondoInversionRentaFijaDAO.save((FondoInversionRentaFija) producto2);
//		fondoInversionMixtoDAO.save((FondoInversionMixto) producto3);

		// Aquí voy a guardar en la BBDD la info importada vía csv, usando anotaciones,
		// NO por xml
		ImportadorDAO infoMercadoImportada = context.getBean(ImportadorDAO.class);
		infoMercadoImportada.save(((GestorCarteraImpl) miGestorCartera).getImportador());

		CarteraInversionDAO CarteraAPersistir = context.getBean(CarteraInversionDAO.class);
		CarteraAPersistir.save(((GestorCarteraImpl) miGestorCartera).getCartera());

		context.close();
	}

}
