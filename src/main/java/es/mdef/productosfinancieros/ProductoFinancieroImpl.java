package es.mdef.productosfinancieros;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import es.mdef.CarteraInversion;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;

//@Embeddable
//@MappedSuperclass
//@JsonDeserialize(as = FondoInversion.class)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PRODUCTO_FINANCIERO")
//@JsonDeserialize(as = FondoInversion.class)
public abstract class ProductoFinancieroImpl implements ProductoFinanciero {

	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;
	private String comercializadora;
	@Id
	private Integer isin;
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "xxxxx")
	//@JoinTable(name="PRODUCTO_FINANCIERO")
	private CarteraInversion cartera;

	protected ProductoFinancieroImpl() {
	}

	protected ProductoFinancieroImpl(String nombreProducto, String comercializadora, Integer isin) {
		super();
		this.nombreProducto = nombreProducto;
		this.comercializadora = comercializadora;
		this.isin = isin;
	}

	public CarteraInversion getCartera() {
		return cartera;
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
	public Integer getIsin() {
		return isin;
	}

	@Override
	public String toString() {
		return "Producto Financiero: " + getNombreProducto() + ", comercializadora: " + getComercializadora()
				+ ",ISIN: " + getIsin();
	}

}