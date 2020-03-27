package es.backend.productosfinancieros;

public class FondoInversionMixto extends ProductoFinancieroImpl {

	public static final String RIESGO = "Medio";
	// este atributo lo uso para al persistir los datos en la BBDD que me guarde la
	// clase del fondo que guardo
	public final String TIPO = FondoInversionMixto.class.getSimpleName();
	private Sector sector;
	private int isin;

	public FondoInversionMixto() {
	}

	public FondoInversionMixto(String nombre, String comercializadora, Sector sector, int isin) {
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
		return super.toString() + " ," + FondoInversionMixto.class.getSimpleName() + " y riesgo "
				+ FondoInversionMixto.RIESGO + " centrado en el sector: " + getSector() + ", con ISIN " + getIsin();
	}

}
