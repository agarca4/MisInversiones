package es.mdef.productosfinancieros.fondosinversion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import es.mdef.CarteraInversion;

@Entity
@Table(name = "FONDOS")
public class FondoInversion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private String id;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private SectorFondo sector;
	@Enumerated(EnumType.STRING)
	private TipoFondo tipo;
	private String riesgo;
	@Column(name="PRECIO_COMPRA_PARTICIPACIONES")
	private Double precioParticipacion;
	private Double capitalInvertido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTERA")
	@JsonBackReference
	private CarteraInversion cartera;

	FondoInversion() {
	}

	public FondoInversion(String nombreProducto, Double precioParticipacion, SectorFondo sector, TipoFondo tipo) {
		this.nombre = nombreProducto;
		this.precioParticipacion = precioParticipacion;
		this.sector = sector;
		this.tipo = tipo;
		setRiesgo();
	}

	public Double getCapitalInvertido() {
		return capitalInvertido;
	}

	public void setCapitalInvertido(Double capitalInvertido) {
		this.capitalInvertido = capitalInvertido;
	}

	public Double getPrecioParticipacion() {
		return precioParticipacion;
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

	public SectorFondo getSector() {
		return sector;

	}

	public TipoFondo getTipo() {
		return tipo;
	}

	public String getRiesgo() {
		return riesgo;
	}

	void setRiesgo() {
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
		return getNombre() + ", valor: " + getPrecioParticipacion() + ", sector: " + getSector() + ", tipo: "
				+ getTipo() + ", riesgo: " + getRiesgo();
	}

}
