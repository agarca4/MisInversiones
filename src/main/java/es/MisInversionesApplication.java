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
	private static GestorCartera<FondoInversion, CarteraInversion, Importador> miGestorCartera = new GestorCarteraImpl(
			"Cartera agresiva");

	protected static GestorCartera<FondoInversion, CarteraInversion, Importador> getMiGestorCartera() {
		return miGestorCartera;
	}

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

		FondoInversion fondo1 = new FondoInversion("SP500", 155555, SectorFondo.CONSUMO_CICLICO,
				TipoFondo.RENTA_VARIABLE);
		FondoInversion fondo2 = new FondoInversion("Edeficandi", 288120, SectorFondo.INDUSTRIA, TipoFondo.RENTA_FIJA);
		FondoInversion fondo3 = new FondoInversion("MidTem", 312069, SectorFondo.CONSUMO_DEFENSIVO, TipoFondo.MIXTO);

		Usuario usuario1 = new Usuario("Juan");
		Usuario usuario2 = new Usuario("Victoria");
		Usuario usuario3 = new Usuario("Belen");

		getMiGestorCartera().altaUsuario(usuario1);
		getMiGestorCartera().altaUsuario(usuario2);
		getMiGestorCartera().altaUsuario(usuario3);
		getMiGestorCartera().bajaUsuario(usuario1);

		// compro y vendo asociandole el importe que invierto o desinvierto
		getMiGestorCartera().compraProductoFinanciero(fondo1, 1500.00);
		getMiGestorCartera().compraProductoFinanciero(fondo2, 2000.00);
		getMiGestorCartera().compraProductoFinanciero(fondo3, 1000.00);

		getMiGestorCartera().vendeProductoFinanciero(fondo2, 1000.00);

		getMiGestorCartera().consultarCartera("infoMercado.csv");

		ImportadorDAO infoMercadoImportada = context.getBean(ImportadorDAO.class);
		infoMercadoImportada.deleteAll();
		infoMercadoImportada.save(miGestorCartera.getImportador());

		CarteraInversionDAO miCartera = context.getBean(CarteraInversionDAO.class);
		miCartera.deleteAll();
		miCartera.save(miGestorCartera.getCartera());

		// context.close();

	}

}
