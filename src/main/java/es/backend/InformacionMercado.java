package es.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Esta clase la usará solo el Importador
@Entity
public class InformacionMercado {

	// en el futuro esta clase tendrá más campos, en funcion de los csv que importe
	// y de la info que necesite de ellos
	// por ahora trabajaré solo con estos 2
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Importador importador;

	private String nombreProductoFinancieroImportado;
	private Double valorActualDeMercado;
	// Este campo lo creo, porque será el que persista en la BBDD

	// Declaro el constructor por defecto con modificador de acceso package para
	// evitar que se instancie la clase desde donde no quiero
	public InformacionMercado() {

	}

	
	Long getId() {
		return id;
	}


	void setId(Long id) {
		this.id = id;
	}


	Importador getMiImportador() {
		return importador;
	}

	void setMiImportador(Importador miImportador) {
		this.importador = miImportador;
	}

	String getNombreProductoFinancieroImportado() {
		return nombreProductoFinancieroImportado;
	}

	void setNombreProductoFinancieroImportado(String nombreProductoFinancieroImportado) {
		this.nombreProductoFinancieroImportado = nombreProductoFinancieroImportado;
	}

	Double getValorActualDeMercado() {
		return valorActualDeMercado;
	}

	void setValorActualDeMercado(Double valorActualDeMercado) {
		this.valorActualDeMercado = valorActualDeMercado;
	}

	@Override
	public String toString() {
		return "El producto " + getNombreProductoFinancieroImportado() + " tiene un valor actual de mercado "
				+ getValorActualDeMercado();
	}

}
