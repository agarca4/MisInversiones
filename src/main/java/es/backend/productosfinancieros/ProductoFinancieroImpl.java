package es.backend.productosfinancieros;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ProductoFinancieroImpl implements ProductoFinanciero {

	private String nombre;
	private String comercializadora;
	@Enumerated(EnumType.STRING)
	private Sector sector;
	private int isin;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String riesgo;

	ProductoFinancieroImpl() {
	}

	public ProductoFinancieroImpl(String nombre, String comercializadora, Sector sector, int isin, Tipo tipo) {
		super();
		this.nombre = nombre;
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
		return nombre;
	}

	@Override
	public String mostrarInfoCompleta() {
		return toString();
	}

	@Override
	public Sector getSector() {
		return sector;

	}

	@Override
	public int getIsin() {
		return isin;
	}

	@Override
	public String toString() {
		return "Producto Financiero con nombre " + getNombreProducto() + ", de la comercializadora "
				+ getComercializadora() + ", centrado en el sector: " + getSector() + ", con ISIN " + getIsin()
				+ " ,de tipo " + getTipo() + " y riesgo " + getRiesgo();

	}

}
