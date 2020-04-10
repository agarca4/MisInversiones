package es.mdef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Importador {
	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long importacionNumero;

	@ElementCollection
	@CollectionTable(name = "PRODUCTOS_IMPORTADOS")
	@MapKeyColumn(name = "NOMBRE_PRODUCTO_IMPORTADO")
    @Column(name = "VALOR_DE_MERCADO")
	//@Column(name = "NOMBRE_PRODUCTO_IMPORTADO")
	private Map<String, Double> informeMercado = new HashMap<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ningun Importador fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	Importador() {
	}

	public Map<String, Double> getInformeMercado() {
		return informeMercado;
	}

	public void importar(String url) {

		// limpio la colección porque me interesan unicamente los ultimos datos de
		// mercado
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
		log.info(String.valueOf(getInformeMercado()));

	}

}
