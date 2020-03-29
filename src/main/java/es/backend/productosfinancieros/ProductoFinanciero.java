package es.backend.productosfinancieros;


public interface ProductoFinanciero {
	
	
	String getNombreProducto();

	String mostrarInfoCompleta();
	
	Sector getSector();
	
	int getIsin();

}
