package es.mdef.productosfinancieros;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ProductoFinancieroImpl implements ProductoFinanciero {

	private String nombreProducto;
	private String comercializadora;
	@Enumerated(EnumType.STRING)
	private Sector sector;
	// Este es un numero que identifica al fondo de inversion de forma unica en el
	// mercado de los productos financieros
	private int isin;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String riesgo;

	ProductoFinancieroImpl() {
	}

	public ProductoFinancieroImpl(String nombreProducto, String comercializadora, Sector sector, int isin, Tipo tipo) {
		super();
		this.nombreProducto = nombreProducto;
		this.comercializadora = comercializadora;
		this.isin = isin;
		this.sector = sector;
		this.tipo = tipo;
		setRiesgo();
	}

	void setRiesgo() {
		switch (this.tipo) {
		case RENTA_FIJA:
			this.riesgo = "BAJO";
			break;
		case RENTA_VARIABLE:
			this.riesgo = "ALTO";
			break;
		case MIXTO:
			this.riesgo = "MEDIO";
			break;
		default:
			this.riesgo = "DESCONOCIDO";
			break;
		}

	}

	Tipo getTipo() {
		return tipo;
	}

	String getRiesgo() {
		return riesgo;
	}

	String getComercializadora() {
		return comercializadora;
	}

	@Override
	public String getNombreProducto() {
		return nombreProducto;
	}

	@Override
	public int getIsin() {
		return isin;
	}

	@Override
	public Sector getSector() {
		return sector;

	}

	@Override
	public String toString() {
		return "Producto Financiero con nombre " + getNombreProducto() + ", de la comercializadora "
				+ getComercializadora() + ", centrado en el sector: " + getSector() + ", con ISIN " + getIsin()
				+ " ,de tipo " + getTipo() + " y riesgo " + getRiesgo();
	}

}
