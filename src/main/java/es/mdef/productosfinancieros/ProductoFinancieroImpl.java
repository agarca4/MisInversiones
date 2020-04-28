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

import es.mdef.CarteraInversion;

//@Embeddable
//@MappedSuperclass
//@JsonDeserialize(as = FondoInversion.class)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PRODUCTO_FINANCIERO")
public abstract class ProductoFinancieroImpl implements ProductoFinanciero {

	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;
	private String comercializadora;
	@Id
	private int isin;
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "xxxxx")
	@JoinTable(name="ACTIV_PART", joinColumns=@JoinColumn(name="ACT_NOMB" , referencedColumnName="NOMBRE_ACT"),
	inverseJoinColumns=@JoinColumn(name="PART_DNI", referencedColumnName="PERS_DNI"))
	private CarteraInversion cartera;

	protected ProductoFinancieroImpl() {
	}

	protected ProductoFinancieroImpl(String nombreProducto, String comercializadora, int isin) {
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
	public int getIsin() {
		return isin;
	}

	@Override
	public String toString() {
		return "Producto Financiero: " + getNombreProducto() + ", comercializadora: " + getComercializadora()
				+ ",ISIN: " + getIsin();
	}

}