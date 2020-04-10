package es.mdef.usuarios;

import java.util.UUID;

import javax.persistence.Embeddable;


@Embeddable
public class Usuario {
	
	private String nombre;
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
		return "Usuario con nombre " + getNombre() + " e ID " + getId();
	}

}
