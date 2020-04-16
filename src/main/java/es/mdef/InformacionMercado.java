package es.mdef;

import javax.persistence.Embeddable;

@Embeddable
public class InformacionMercado {

	String nombreProductoImportado;
	Double ValorActualProductoImportado;

	InformacionMercado() {

	}

	String getNombreProductoImportado() {
		return nombreProductoImportado;
	}

	void setNombreProductoImportado(String nombreProductoImportado) {
		this.nombreProductoImportado = nombreProductoImportado;
	}

	Double getValorActualProductoImportado() {
		return ValorActualProductoImportado;
	}

	void setValorActualProductoImportado(Double valorActualProductoImportado) {
		ValorActualProductoImportado = valorActualProductoImportado;
	}

	@Override
	public String toString() {
		return "Producto: " + getNombreProductoImportado() + " Valor actual: " + getValorActualProductoImportado();
	}

}