package es.backend;

//Esta clase la usará solo el Importador
public class InformacionMercado {

	// en el futuro esta clase tendrá más campos, en funcion de los csv que importe
	// y de la info que necesite de ellos
	// por ahora trabajaré solo con estos 2
	private String nombreProductoFinancieroImportado;
	private Double valorActualDeMercado;

	// Declaro el constructor por defecto con modificador de acceso package para
	// evitar que se instancie la clase desde donde no quiero
	InformacionMercado() {

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
