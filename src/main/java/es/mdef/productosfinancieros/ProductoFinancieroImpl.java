package es.mdef.productosfinancieros;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable
@MappedSuperclass
//@JsonDeserialize(as = FondoInversion.class)
public abstract class ProductoFinancieroImpl implements ProductoFinanciero {

	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;
	private String comercializadora;
	private int isin;

	protected ProductoFinancieroImpl() {
	}

	protected ProductoFinancieroImpl(String nombreProducto, String comercializadora, int isin) {
		super();
		this.nombreProducto = nombreProducto;
		this.comercializadora = comercializadora;
		this.isin = isin;
	}

	@Override
	public String getNombreProducto() {
		return nombreProducto;
	}

	@Override
	public String getComercializadora() {
		return comercializadora;
	}

	@Override
	public int getIsin() {
		return isin;
	}

	@Override
	public String toString() {
		return "Producto Financiero: " + getNombreProducto() + ", comercializadora: " + getComercializadora()
				+ ",ISIN: " + getIsin();
	}

}