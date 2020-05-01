package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

@Entity
@Table(name = "CARTERAS")
public class CarteraInversion {

	@Id
	@Column(name = "NOMBRE_CARTERA")
	private String nombreCartera;
	@Column(name = "FECHA_ALTA")
	private Instant fechaCreacionCartera;
	@Column(name = "CAPITAL_INVERTIDO")
	private double capitalInvertido;

	@Transient
	private GestorCarteraImpl gestor;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "cartera")
	private Collection<Usuario> usuarios = new ArrayList<>();
	private Double rentabilidad;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = FondoInversion.class, mappedBy = "cartera")
	private Collection<FondoInversion> fondos = new ArrayList<>();

	CarteraInversion() {
		setFechaCreacionCartera(Instant.now());

	}

	public Collection<FondoInversion> getFondos() {
		return fondos;
	}

	public void setFondos(Collection<FondoInversion> fondos) {
		this.fondos = fondos;
	}

	void setFechaCreacionCartera(Instant fechaCreacionCartera) {
		this.fechaCreacionCartera = fechaCreacionCartera;
	}

	public double getCapitalInvertido() {
		return capitalInvertido;
	}

	public Instant getFechaCreacionCartera() {
		return fechaCreacionCartera;
	}

	void setCapitalInvertido(double capitalTotal) {
		this.capitalInvertido = capitalTotal;
	}

	public String getNombreCartera() {
		return nombreCartera;
	}

	void setNombreCartera(String nombreCartera) {
		this.nombreCartera = nombreCartera;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Double getRentabilidad(String url) {
		getGestor().calcularRentabilidad(url);
		return rentabilidad;
	}

	void setRentabilidad(Double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}

	private GestorCarteraImpl getGestor() {
		return gestor;
	}

	@Override
	public String toString() {
		return getNombreCartera() + ": " + getFondos() + ", capital total: " + getCapitalInvertido() + ", creada el: "
				+ getFechaCreacionCartera() + ", usuarios: " + getUsuarios() + ", Rentabilidad:"
				+ rentabilidad;
	}

}
