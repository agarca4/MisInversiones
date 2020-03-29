package es.backend.productosfinancieros;

public class FondoInversionMixto extends ProductoFinancieroImpl {

	public static final String RIESGO = "Medio";
	public final String TIPO = FondoInversionMixto.class.getSimpleName();

	public FondoInversionMixto(String nombre, String comercializadora, Sector sector, int isin) {
		super(nombre, comercializadora, sector, isin);
	}

	@Override
	public String toString() {
		return super.toString() + " ," + FondoInversionMixto.class.getSimpleName() + " y riesgo "
				+ FondoInversionMixto.RIESGO;
	}

}
