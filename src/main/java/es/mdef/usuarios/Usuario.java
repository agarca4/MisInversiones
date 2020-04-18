package es.mdef.usuarios;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Usuario {

	private String nombre;
	@Id
	//@GeneratedValue(generator="CUST_SEQ")
	//private Integer id;
	private UUID id;

	public Usuario() {
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.id = GeneradorId.getInstancia().generaId();

	}
	
	public String getNombre() {
		return nombre;
	}
	
	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario " + getNombre() + ", ID " + getId();
	}

}
