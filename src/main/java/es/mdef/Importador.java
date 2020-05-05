package es.mdef;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Importador {

	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);
	private static String url = "infoMercado.csv";
	private static Map<String, Double> informeMercado = new HashMap<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ningun Importador fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	Importador() {
	}

	public static Map<String, Double> getInformeMercado() {
		return informeMercado;
	}

//Este metodo me importa la info de un csv y me la pasa a un Collection
	public static Map<String, Double> importar() {

		// limpio la colección porque me interesan unicamente los ultimos datos de
		// mercado para calcular ahora la rentabilidad
		getInformeMercado().clear();

		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(Importador.class.getClassLoader().getResource(url).openStream(), "UTF-8"))) {
			String linea;
			buffer.readLine();
			while ((linea = buffer.readLine()) != null) {
				String[] columnas = linea.split(",");
				getInformeMercado().put(columnas[0], Double.parseDouble(columnas[1]));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		generarJsonInfoImportada();

		log.info(String.valueOf(getInformeMercado()));

		return informeMercado;

	}

	// este metodo me genera un Json con la info que he importado
	static void generarJsonInfoImportada() {

		File miInformeMercado = new File("InformeMercado.json");
		ObjectMapper mapper = new ObjectMapper();
		// mapper.addMixIn(InformacionMercado.class, MixinInformacionMercado.class);
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(miInformeMercado, getInformeMercado());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//@JsonIgnoreProperties({ "nombreDeLaSerie" })
//@JsonPropertyOrder({ "HC", "AC", "home", "golesLocal" })
//abstract class MixinInformacionMercado {
//
//	@JsonProperty("nombreProducto")
//	public abstract String getNombreProductoImportado();
//
//	@JsonProperty("valorMercado")
//	public abstract Double getValorActualProductoImportado();
//
//}
