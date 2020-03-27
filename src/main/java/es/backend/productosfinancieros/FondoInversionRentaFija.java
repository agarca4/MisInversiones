package es.backend.productosfinancieros;

public class FondoInversionRentaFija extends ProductoFinancieroImpl {

	public static final String RIESGO = "Bajo";
	// este atributo lo uso para al persistir los datos en la BBDD que me guarde la
	// clase del fondo que guardo
	public final String TIPO = FondoInversionRentaFija.class.getSimpleName();

	private Sector sector;
	private int isin;

	public FondoInversionRentaFija() {
	}

	public FondoInversionRentaFija(String nombre, String comercializadora, Sector sector, int isin) {
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
		return super.toString() + " ," + FondoInversionRentaFija.class.getSimpleName() + " y riesgo "
				+ FondoInversionRentaFija.RIESGO + " centrado en el sector: " + getSector() + ", con ISIN " + getIsin();
	}

}
