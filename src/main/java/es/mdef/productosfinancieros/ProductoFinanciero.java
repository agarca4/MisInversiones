package es.mdef.productosfinancieros;



//@JsonDeserialize(as = FondoInversion.class)
public interface ProductoFinanciero {

	public String getNombreProducto();

	public String getComercializadora();

	public int getIsin();

}