package es.backend.usuarios;

import javax.persistence.Embeddable;

@Embeddable
public class Usuario {

	private String nombre;
	private Integer id;

	public Usuario() {
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.id = GeneradorId.getInstancia().asignadorId();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario con nombre " + getNombre() + " e ID " + getId();
	}

}
