package es.mdef.productosfinancieros;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

//@Entity
//@MappedSuperclass
@Entity
@Inheritance
public abstract class ProductoFinancieroImpl implements ProductoFinanciero {

	@Id
	@Column(name = "NOMBRE_PRODUCTO")
	String nombreProducto;
	
	String comercializadora;
	int isin;

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
		return "Producto Financiero con nombre " + getNombreProducto() + ", de la comercializadora "
				+ getComercializadora() + ", con ISIN " + getIsin();
	}

}