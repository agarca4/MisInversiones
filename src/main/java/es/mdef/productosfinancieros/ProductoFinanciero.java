package es.mdef.productosfinancieros;

import javax.persistence.Embeddable;
import javax.persistence.Transient;


public interface ProductoFinanciero {

	
	public String getNombreProducto();

	public String getComercializadora();

	
	public int getIsin();

}