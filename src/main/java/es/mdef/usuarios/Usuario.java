package es.mdef.usuarios;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import es.mdef.CarteraInversion;

@Entity
public class Usuario {

	private String nombre;
	@Id
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTERA")
	@JsonBackReference
	private CarteraInversion cartera;

	public Usuario() {
	}

	public Usuario(String nombre, long id, CarteraInversion cartera) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.cartera = cartera;

	}

	public String getNombre() {
		return nombre;
	}

	public long getId() {
		return id;
	}

	public CarteraInversion getCartera() {
		return cartera;
	}

	public void setCartera(CarteraInversion cartera) {
		this.cartera = cartera;
	}

	@Override
	public String toString() {
		return "Usuario " + getNombre() + ", ID " + getId();
	}

}
