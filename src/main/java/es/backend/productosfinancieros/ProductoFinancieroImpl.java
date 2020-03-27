package es.backend.productosfinancieros;

public abstract class ProductoFinancieroImpl implements ProductoFinanciero {

	private String nombre;
	private String comercializadora;

	public ProductoFinancieroImpl() {
		super();
	}

//	public ProductoFinancieroImpl(String nombre, String comercializadora) {
//		super();
//		this.nombre = nombre;
//		this.comercializadora = comercializadora;
//	}

	public String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	void setComercializadora(String comercializadora) {
		this.comercializadora = comercializadora;
	}

	public String getComercializadora() {
		return comercializadora;
	}

	@Override
	public String toString() {
		return "Producto Financiero con nombre " + getNombre() + ", de la comercializadora " + getComercializadora();
	}

}
