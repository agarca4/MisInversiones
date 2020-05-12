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

	private static GestorCartera<FondoInversion, CarteraInversion> miGestorCartera = new GestorCarteraImpl(
			"agresiva");

	private static GestorCartera<FondoInversion, CarteraInversion> getMiGestorCartera() {
		return miGestorCartera;
	}

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

		FondoInversion fondo1 = new FondoInversion("SP500", 70.00, SectorFondo.CONSUMO_CICLICO,
				TipoFondo.RENTA_VARIABLE);
		FondoInversion fondo2 = new FondoInversion("Edeficandi", 50.00, SectorFondo.INDUSTRIA, TipoFondo.RENTA_FIJA);
		FondoInversion fondo3 = new FondoInversion("MidTem", 16.00, SectorFondo.CONSUMO_DEFENSIVO, TipoFondo.MIXTO);

		Usuario usuario1 = new Usuario("Juan");
		Usuario usuario2 = new Usuario("Victoria");
		Usuario usuario3 = new Usuario("Belen");
		
		getMiGestorCartera().altaUsuario(usuario1);
		getMiGestorCartera().altaUsuario(usuario2);
		getMiGestorCartera().altaUsuario(usuario3);
		getMiGestorCartera().bajaUsuario(usuario1);

		getMiGestorCartera().compraProductoFinanciero(fondo1, 1500.00);
		getMiGestorCartera().compraProductoFinanciero(fondo2, 2000.00);
		getMiGestorCartera().compraProductoFinanciero(fondo3, 2000.00);
		getMiGestorCartera().vendeProductoFinanciero(fondo2, 1000.00);

		
		//Como en el front no se va a implementar el alta de fondos nuevos, al crear una cartera siempre me va a dar 0 capital y 0 rentabilidad
		//para evitar esto he comentado los metodos de getRentabilidad() y getCapital(), de forma que pueda setearselos en el back y tambien en el front.
		//Cuando implemente en el front la funcionalidad de alta fondos nuevos, ya podré usar estos metodos que calculan ambas propiedades
		getMiGestorCartera().getCartera().setCapitalInvertido(50000);
		getMiGestorCartera().getCartera().setRentabilidad(4.0);

		
		CarteraInversionDAO miCartera = context.getBean(CarteraInversionDAO.class);
		miCartera.deleteAll();
		miCartera.save(miGestorCartera.getCartera());

		// context.close();

	}

}
