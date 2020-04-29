package es.mdef.usuarios;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import es.mdef.CarteraInversion;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	private String nombre;
	@Id
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTERA")
	@JsonBackReference
	private CarteraInversion cartera;

	public Usuario() {
	}

	public Usuario(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
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
