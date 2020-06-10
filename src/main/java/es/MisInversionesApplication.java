package es;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.mdef.CarteraInversion;
import es.mdef.GestorCartera;
import es.mdef.GestorCarteraImpl;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.productosfinancieros.fondosinversion.SectorFondo;
import es.mdef.productosfinancieros.fondosinversion.TipoFondo;
import es.mdef.repositorios.CarteraInversionDAO;
import es.mdef.usuarios.Usuario;

@SpringBootApplication
@ImportResource({ "classpath:config/jpa-config.xml" })
@Import(ConfiguracionPorJava.class)
public class MisInversionesApplication {

	//private static final Logger log = LoggerFactory.getLogger(MisInversionesApplication.class);

	public static void main(String[] args) throws ParseException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MisInversionesApplication.class, args);

		//GestorCartera<FondoInversion, CarteraInversion> miGestorCartera1 = new GestorCarteraImpl("agresiva");

		/*
		 * Así puedo importar carteras desde un json, en principio mi api lo que hace es
		 * importar fondos desde un csv, pero esto queda preparado y funciona bien, por
		 * si hiciera falta algún día
		 */
//		ObjectMapper mapper = context.getBean(ObjectMapper.class);
//		CarteraInversionDAO carteraDAO = context.getBean(CarteraInversionDAO.class);
//		((GestorCarteraImpl) miGestorCartera1).cargarFondosJson("src/main/resources/carteras.json", mapper, carteraDAO);

//		FondoInversion fondo1 = new FondoInversion("SP500", 80.00, SectorFondo.CONSUMO_CICLICO,
//				TipoFondo.RENTA_VARIABLE);
//		FondoInversion fondo2 = new FondoInversion("Edeficandi", 52.00, SectorFondo.INDUSTRIA, TipoFondo.RENTA_FIJA);
//		FondoInversion fondo3 = new FondoInversion("MidTem", 18.00, SectorFondo.CONSUMO_DEFENSIVO, TipoFondo.MIXTO);
//
//		Usuario usuario1 = new Usuario("Juan");
//		Usuario usuario2 = new Usuario("Victoria");
//		Usuario usuario3 = new Usuario("Belen");
//
//		miGestorCartera1.altaUsuario(usuario1);
//		miGestorCartera1.altaUsuario(usuario2);
//		miGestorCartera1.altaUsuario(usuario3);
//		miGestorCartera1.bajaUsuario(usuario1);
//
//		miGestorCartera1.compraProductoFinanciero(fondo1, 1500.00);
//		miGestorCartera1.compraProductoFinanciero(fondo2, 2000.00);
//		miGestorCartera1.compraProductoFinanciero(fondo3, 2000.00);
//		miGestorCartera1.vendeProductoFinanciero(fondo2, 1000.00);
//
//		CarteraInversionDAO miCartera = context.getBean(CarteraInversionDAO.class);
//		miCartera.deleteAll();
//		miCartera.save(miGestorCartera1.getCartera());
//
//		// Pruebo los metodos personalizados expuestos. Funcionan bien y desde Postman tambien
//		List<CarteraInversion> carterasPorCapital = miCartera.getCarterasPorCapitalInvertido(4500.00);
//		carterasPorCapital.stream().map(CarteraInversion::toString).forEach(log::warn);
//
//		List<CarteraInversion> carterasPorRentabilidad = miCartera.getCarterasPorRentabilidadMinima(-10.00);
//		carterasPorRentabilidad.stream().map(CarteraInversion::toString).forEach(log::warn);

		// context.close();

	}

}
