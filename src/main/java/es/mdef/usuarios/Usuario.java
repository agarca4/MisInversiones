package es.mdef.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import es.mdef.CarteraInversion;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private String id;
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTERA")
	private CarteraInversion cartera;

	public Usuario() {
	}

	public Usuario(String nombre) {
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public String getId() {
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
