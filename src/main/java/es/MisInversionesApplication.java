package es;

import java.io.IOException;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import es.mdef.CarteraInversion;
import es.mdef.GestorCartera;
import es.mdef.GestorCarteraImpl;
import es.mdef.Importador;
import es.mdef.productosfinancieros.ProductoFinanciero;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.productosfinancieros.fondosinversion.SectorFondo;
import es.mdef.productosfinancieros.fondosinversion.TipoFondo;
import es.mdef.repositorios.CarteraInversionDAO;
import es.mdef.repositorios.ImportadorDAO;
import es.mdef.usuarios.Usuario;

@SpringBootApplication
/*
 * SpringBoot lee automaticamente lo que tenga en application.properties, que es
 * un archivo que crea el en automatico, y puedo meter todas las propiedades ahí
 * si quiero, pero tb puedo hacer otros properties y le digo a SpringBoot que
 * busque en ellos con la anotacion @PropertySource
 * 
 * @PropertySource({ "xxxxxx.properties" })
 */
/*
 * Con esta anotacion le digo que ademas de la configuracion por defecto de
 * SpringBoot, tenga tb en cuenta esa configuracion por XML que hay en ese
 * archivo. Recordar que al usar SpringBoot ya no hace falta archivos xml de
 * scaneo, puesto que SpringBoot escaneará a partir del paquete donde esté la
 * anotacion que lo arranca
 */
@ImportResource({ "classpath:config/jpa-config.xml" })
public class MisInversionesApplication {

	private static final Logger log = LoggerFactory.getLogger(MisInversionesApplication.class);
	private static GestorCartera<ProductoFinanciero, CarteraInversion, Importador> miGestorCartera = new GestorCarteraImpl(
			"Cartera agresiva");

	protected static GestorCartera<ProductoFinanciero, CarteraInversion, Importador> getMiGestorCartera() {
		return miGestorCartera;
	}

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

		// creo los productos
		ProductoFinanciero fondo1 = new FondoInversion("SP500", "Amundi", 555555, SectorFondo.CONSUMO_CICLICO,
				TipoFondo.RENTA_VARIABLE);
		ProductoFinanciero fondo2 = new FondoInversion("Edeficandi", "Pictetd", 478120, SectorFondo.INDUSTRIA,
				TipoFondo.RENTA_FIJA);
		ProductoFinanciero fondo3 = new FondoInversion("MidTem", "Axa", 742069, SectorFondo.CONSUMO_DEFENSIVO,
				TipoFondo.MIXTO);

		// Me creo un par de usuarios
		Usuario usuario1 = new Usuario("Juan");
		Usuario usuario2 = new Usuario("Victoria");
		Usuario usuario3 = new Usuario("Belen");

		getMiGestorCartera().altaUsuario(usuario1);
		getMiGestorCartera().altaUsuario(usuario2);
//		miGestorCartera.listarUsuarios();
//		miGestorCartera.bajaUsuario(usuario1);
//		miGestorCartera.listarUsuarios();

		// compro para mi cartera los productos que habia creado con el factory,
		// asociandole el importe que invierto
		// los listo
		getMiGestorCartera().compraProductoFinanciero(fondo1, 500);
		getMiGestorCartera().compraProductoFinanciero(fondo2, 7500);
		getMiGestorCartera().compraProductoFinanciero(fondo3, 900);
		// System.err.println(miGestorCartera.listarProductos());
		// System.err.println(miGestorCartera.listarUsuarios());

		// Compruebo que funciona correctamente el metodo, me salta el log.error cuando
		// trato de vender un producto q ya no tengo
		getMiGestorCartera().vendeProductoFinanciero(fondo2, 2000);
		getMiGestorCartera().vendeProductoFinanciero(fondo2, 1000);
		getMiGestorCartera().vendeProductoFinanciero(fondo3, 900);
		getMiGestorCartera().compraProductoFinanciero(fondo2, 4000);
		getMiGestorCartera().vendeProductoFinanciero(fondo3, 500);
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
		getMiGestorCartera().consultarCartera("infoMercado.csv");

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
		infoMercadoImportada.save(miGestorCartera.getImportador());
//
		CarteraInversionDAO miCartera = context.getBean(CarteraInversionDAO.class);
		miGestorCartera.altaUsuario(usuario3);
		log.info(miGestorCartera.listarUsuarios().toString());
		log.info(miGestorCartera.listarProductos().toString());
		miCartera.save(miGestorCartera.getCartera());

		// miCartera.deleteAll();
		log.info(miCartera.findAll().toString());

		/* No cierro el contexto para que la api se quede a la escucha de peticiones */
		// context.close();
	}

}
