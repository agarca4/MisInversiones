package es.mdef;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InformacionMercado {

	@Column(name = "PRODUCTO")
	String nombreProductoImportado;
	@Column(name = "VALOR_DE_MERCADO")
	Double ValorActualProductoImportado;

	InformacionMercado() {

	}

	public String getNombreProductoImportado() {
		return nombreProductoImportado;
	}

	void setNombreProductoImportado(String nombreProductoImportado) {
		this.nombreProductoImportado = nombreProductoImportado;
	}

	public Double getValorActualProductoImportado() {
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