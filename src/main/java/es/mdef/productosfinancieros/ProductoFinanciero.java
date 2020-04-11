package es.mdef.productosfinancieros;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;


@Embeddable
@MappedSuperclass
public abstract class ProductoFinanciero {

	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;
	private String comercializadora;
	private int isin;

	protected ProductoFinanciero() {
	}

	protected ProductoFinanciero(String nombreProducto, String comercializadora, int isin) {
		super();
		this.nombreProducto = nombreProducto;
		this.comercializadora = comercializadora;
		this.isin = isin;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	String getComercializadora() {
		return comercializadora;
	}

	int getIsin() {
		return isin;
	}

	@Override
	public String toString() {
		return "Producto Financiero con nombre " + getNombreProducto() + ", de la comercializadora "
				+ getComercializadora() + ", con ISIN " + getIsin();
	}

}