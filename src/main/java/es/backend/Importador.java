package es.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

public class Importador {

	private static Collection<InformacionMercado> InformeMercado = new ArrayList<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ningun Importador fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	Importador() {

	}

	static Collection<InformacionMercado> getInformeMercado() {
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
				InformacionMercado InformacionMercadoProductoConcreto = new InformacionMercado();
				String[] columnas = linea.split(",");
				InformacionMercadoProductoConcreto.setNombreProductoFinancieroImportado(columnas[0]);
				InformacionMercadoProductoConcreto.setValorActualDeMercado(Double.parseDouble(columnas[1]));
				getInformeMercado().add(InformacionMercadoProductoConcreto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(getInformeMercado());
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
