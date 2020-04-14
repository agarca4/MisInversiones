package es.mdef.productosfinancieros.fondosinversion;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import es.mdef.CarteraInversion;
import es.mdef.productosfinancieros.ProductoFinancieroImpl;

@Entity
@DiscriminatorColumn(name="FONDO_INVERSION")
public class FondoInversion extends ProductoFinancieroImpl {	
	
	@Enumerated(EnumType.STRING)
	private SectorFondo sector;
	
	@Enumerated(EnumType.STRING)
	private TipoFondo tipo;
	
	private String riesgo;
	
	@ManyToOne
	private CarteraInversion cartera;
	
	

	FondoInversion() {
	}

	public FondoInversion(String nombreProducto, String comercializadora, int isin, SectorFondo sector,
			TipoFondo tipo) {
		super(nombreProducto, comercializadora, isin);
		this.sector = sector;
		this.tipo = tipo;
		setRiesgo();
	}

	public SectorFondo getSector() {
		return sector;

	}

	
	TipoFondo getTipo() {
		return tipo;
	}

	String getRiesgo() {
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
		return super.toString() + ", centrado en el sector: " + getSector() + " ,de tipo " + getTipo() + " y riesgo "
				+ getRiesgo();
	}



}
