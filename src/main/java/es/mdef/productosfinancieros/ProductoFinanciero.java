package es.mdef.productosfinancieros;

public interface ProductoFinanciero {

	// Esto lo deberán implementar todos los productos financieros, ya sean fondos,
	// depositos, acciones, etc
	String getNombreProducto();

	int getIsin();

	Sector getSector();

}
