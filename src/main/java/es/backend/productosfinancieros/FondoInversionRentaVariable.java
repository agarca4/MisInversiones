package es.backend.productosfinancieros;

public class FondoInversionRentaVariable extends ProductoFinancieroImpl {

	public static final String RIESGO = "Alto";
	public final String TIPO = FondoInversionRentaVariable.class.getSimpleName();

	public FondoInversionRentaVariable(String nombre, String comercializadora, Sector sector, int isin) {
		super(nombre, comercializadora, sector, isin);
	}

	@Override
	public String toString() {
		return super.toString() + " ," + FondoInversionRentaVariable.class.getSimpleName() + " y riesgo "
				+ FondoInversionRentaVariable.RIESGO;
	}
}
