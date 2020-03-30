package es.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Importador {
	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long importacionNumero;

	@ElementCollection
	private Collection<InformacionMercado> InformeMercado = new ArrayList<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ningun Importador fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	Importador() {
	}

	public Collection<InformacionMercado> getInformeMercado() {
		return InformeMercado;
	}

	public void importar() throws ParseException, IOException {

		// limpio la colección porque me interesan unicamente los ultimos datos de
		// mercado
		getInformeMercado().clear();

		String ruta = "infoMercado.csv";

		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(Importador.class.getClassLoader().getResource(ruta).openStream(), "UTF-8"))) {
			String linea;
			buffer.readLine();
			while ((linea = buffer.readLine()) != null) {
				InformacionMercado informacionMercadoProductoConcreto = new InformacionMercado();
				String[] columnas = linea.split(",");
				informacionMercadoProductoConcreto.setNombreProductoFinancieroImportado(columnas[0]);
				informacionMercadoProductoConcreto.setValorActualDeMercado(Double.parseDouble(columnas[1]));
				getInformeMercado().add(informacionMercadoProductoConcreto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(String.valueOf(getInformeMercado()));

	}

}
//Tengo la Libreria importada, pero no la he usado al final...

//public static void main(String[] args) throws ParseException, IOException {
//	
//	public static List<Map<String, String>> read(File file) throws JsonProcessingException, IOException {
//	    List<Map<String, String>> response = new LinkedList<Map<String, String>>();
//	    CsvMapper mapper = new CsvMapper();
//	    CsvSchema schema = CsvSchema.emptySchema().withHeader();
//	    MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class)
//	            .with(schema)
//	            .readValues(file);
//	    while (iterator.hasNext()) {
//	        response.add(iterator.next());
//	    }
//	    return response;
//	}
