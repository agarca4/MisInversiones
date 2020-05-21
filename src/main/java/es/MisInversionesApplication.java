package es;

import java.io.IOException;
import java.text.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import es.mdef.CarteraInversion;
import es.mdef.GestorCartera;
import es.mdef.GestorCarteraImpl;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.productosfinancieros.fondosinversion.SectorFondo;
import es.mdef.productosfinancieros.fondosinversion.TipoFondo;
import es.mdef.repositorios.CarteraInversionDAO;
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

//	private static GestorCartera<FondoInversion, CarteraInversion> miGestorCartera = new GestorCarteraImpl(
//			"agresiva");
//
//	private static GestorCartera<FondoInversion, CarteraInversion> getMiGestorCartera() {
//		return miGestorCartera;
//	}

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

//		FondoInversion fondo1 = new FondoInversion("SP500", 150.00, SectorFondo.CONSUMO_CICLICO,
//				TipoFondo.RENTA_VARIABLE);
//		FondoInversion fondo2 = new FondoInversion("Edeficandi", 52.00, SectorFondo.INDUSTRIA, TipoFondo.RENTA_FIJA);
//		FondoInversion fondo3 = new FondoInversion("MidTem", 18.00, SectorFondo.CONSUMO_DEFENSIVO, TipoFondo.MIXTO);
//		
//		Usuario usuario1 = new Usuario("Juan");
//		Usuario usuario2 = new Usuario("Victoria");
//		Usuario usuario3 = new Usuario("Belen");
//		
//		getMiGestorCartera().altaUsuario(usuario1);
//		getMiGestorCartera().altaUsuario(usuario2);
//		getMiGestorCartera().altaUsuario(usuario3);
//		getMiGestorCartera().bajaUsuario(usuario1);
//
//		getMiGestorCartera().compraProductoFinanciero(fondo1, 1500.00);
//		getMiGestorCartera().compraProductoFinanciero(fondo2, 2000.00);
//		getMiGestorCartera().compraProductoFinanciero(fondo3, 2000.00);
//		getMiGestorCartera().vendeProductoFinanciero(fondo2, 1000.00);
//
//	
//		CarteraInversionDAO miCartera = context.getBean(CarteraInversionDAO.class);
//		miCartera.deleteAll();
//		miCartera.save(miGestorCartera.getCartera());

		// context.close();

	}

}
