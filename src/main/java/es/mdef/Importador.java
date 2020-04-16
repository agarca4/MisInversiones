package es.mdef;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Importador {
	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMERO_DE_IMPORTACION")
	private long importacionNumero;

	@ElementCollection
	@CollectionTable(name = "PRODUCTOS_IMPORTADOS")
	private Collection<InformacionMercado> informeMercado = new ArrayList<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ningun Importador fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	Importador() {
	}

	public Collection<InformacionMercado> getInformeMercado() {
		return informeMercado;
	}

//Este metodo me importa la info de un csv y me la pasa a un Collection
	public void importar(String url) {

		// limpio la colección porque me interesan unicamente los ultimos datos de
		// mercado para calcular ahora la rentabilidad
		informeMercado.clear();

		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(Importador.class.getClassLoader().getResource(url).openStream(), "UTF-8"))) {
			String linea;
			buffer.readLine();
			while ((linea = buffer.readLine()) != null) {
				InformacionMercado informacionMercado = new InformacionMercado();
				String[] columnas = linea.split(",");
				informacionMercado.setNombreProductoImportado(columnas[0]);
				informacionMercado.setValorActualProductoImportado(Double.parseDouble(columnas[1]));
				this.getInformeMercado().add(informacionMercado);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		File miInformeMercado = new File("InformeMercado.json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(InformacionMercado.class, MixinInformacionMercado.class);
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(miInformeMercado, getInformeMercado());
		} catch (IOException e) {
			e.printStackTrace();
		}
		generarJsonInfoImportada();
		
		log.info(String.valueOf(getInformeMercado()));

	}

	// este metodo me genera un Json con la info que he importado
	void generarJsonInfoImportada() {

		File miInformeMercado = new File("InformeMercado.json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(InformacionMercado.class, MixinInformacionMercado.class);
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(miInformeMercado, getInformeMercado());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//@JsonIgnoreProperties({ "nombreDeLaSerie" })
//@JsonPropertyOrder({ "HC", "AC", "home", "golesLocal" })
abstract class MixinInformacionMercado {

	@JsonProperty("nombreProducto")
	public abstract String getNombreProductoImportado();

	@JsonProperty("valorMercado")
	public abstract Double getValorActualProductoImportado();

}
