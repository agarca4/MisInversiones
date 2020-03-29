package es.backend.productosfinancieros;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class FondoInversionRentaVariable extends ProductoFinancieroImpl {

	public static final String RIESGO = "Alto";
	// este atributo lo uso para al persistir los datos en la BBDD que me guarde la
	// clase del fondo que guardo
	public final String TIPO = FondoInversionRentaVariable.class.getSimpleName();

	@Enumerated(EnumType.STRING)
	private Sector sector;
	private int isin;

	public FondoInversionRentaVariable() {
	}

	public FondoInversionRentaVariable(String nombre, String comercializadora, Sector sector, int isin) {
		setNombre(nombre);
		setComercializadora(comercializadora);
		this.sector = sector;
		this.isin = isin;
	}

	public Sector getSector() {
		return sector;
	}

	public int getIsin() {
		return isin;
	}

	@Override
	public String getNombreProducto() {
		super.getNombre();
		return null;
	}

	@Override
	public String mostrarInfoCompleta() {

		return toString();

	}

	@Override
	public String toString() {
		return super.toString() + " ," + FondoInversionRentaVariable.class.getSimpleName() + " y riesgo "
				+ FondoInversionRentaVariable.RIESGO + " centrado en el sector: " + getSector() + ", con ISIN "
				+ getIsin();
	}

}
