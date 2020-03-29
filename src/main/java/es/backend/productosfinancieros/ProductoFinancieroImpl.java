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

	public ProductoFinancieroImpl() {
	}

	public ProductoFinancieroImpl(String nombre, String comercializadora, Sector sector, int isin) {
		super();
		this.nombre = nombre;
		this.comercializadora = comercializadora;
		this.isin = isin;
		this.sector = sector;
	}

	void setIsin(int isin) {
		this.isin = isin;
	}

	void setSector(Sector sector) {
		this.sector = sector;
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
				+ getComercializadora() + ", centrado en el sector: " + getSector() + ", con ISIN " + getIsin();

	}

}
