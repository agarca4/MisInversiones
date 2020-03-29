package es.backend.productosfinancieros;

public class FondoInversionRentaFija extends ProductoFinancieroImpl {

	public static final String RIESGO = "Bajo";
	public final String TIPO = FondoInversionRentaFija.class.getSimpleName();

	public FondoInversionRentaFija(String nombre, String comercializadora, Sector sector, int isin) {
		super(nombre, comercializadora, sector, isin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " ," + FondoInversionRentaFija.class.getSimpleName() + " y riesgo "
				+ FondoInversionRentaFija.RIESGO;
	}

}
