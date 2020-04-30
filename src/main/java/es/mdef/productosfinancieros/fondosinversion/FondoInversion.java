package es.mdef.productosfinancieros.fondosinversion;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import es.mdef.CarteraInversion;

@Entity
@Table(name = "FONDOS_DE_INVERSION")
public class FondoInversion {

	@Id
	private String isin;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private SectorFondo sector;
	@Enumerated(EnumType.STRING)
	private TipoFondo tipo;
	private String riesgo;
	private Double valor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTERA")
	@JsonBackReference
	private CarteraInversion cartera;

	FondoInversion() {
	}

	public FondoInversion(String nombreProducto, String isin, SectorFondo sector, TipoFondo tipo) {
		this.nombre = nombreProducto;
		this.isin = isin;
		this.sector = sector;
		this.tipo = tipo;
		setRiesgo();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double precioAdquisicion) {
		this.valor = precioAdquisicion;
	}

	public CarteraInversion getCartera() {
		return cartera;
	}

	public void setCartera(CarteraInversion cartera) {
		this.cartera = cartera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public SectorFondo getSector() {
		return sector;

	}

	public void setSector(SectorFondo sector) {
		this.sector = sector;
	}

	public TipoFondo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFondo tipo) {
		this.tipo = tipo;
	}

	public String getRiesgo() {
		return riesgo;
	}

	public void setRiesgo() {
		switch (this.tipo) {
		case RENTA_FIJA:
			this.riesgo = "BAJO";
			break;
		case RENTA_VARIABLE:
			this.riesgo = "ALTO";
			break;
		case MIXTO:
			this.riesgo = "MEDIO";
			break;
		default:
			this.riesgo = "DESCONOCIDO";
			break;
		}

	}

	@Override
	public String toString() {
		return getNombre() + ", valor: " + getValor() + ", ISIN: " + getIsin() + ", sector: "
				+ getSector() + ", tipo: " + getTipo() + ", riesgo: " + getRiesgo();
	}

}
