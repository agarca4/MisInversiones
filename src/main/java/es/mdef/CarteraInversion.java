package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

@Entity
public class CarteraInversion {

	@Id
	@Column(name = "NOMBRE_CARTERA")
	private String nombreCartera;
	private Instant fechaCreacionCartera;
	private double capitalTotal;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "cartera")
	private Collection<Usuario> usuarios = new ArrayList<>();
	private double rentabilidadActual;

	@OneToMany(targetEntity = FondoInversion.class, mappedBy = "cartera", cascade = CascadeType.ALL)
	private Collection<FondoInversion> productos = new ArrayList<>();

	CarteraInversion() {
		setFechaCreacionCartera(Instant.now());

	}

	public Collection<FondoInversion> getProductosFinancieros() {
		return productos;
	}

	public void setProductosFinancieros(Collection<FondoInversion> productosFinancieros) {
		this.productos = productosFinancieros;
	}

	void setFechaCreacionCartera(Instant fechaCreacionCartera) {
		this.fechaCreacionCartera = fechaCreacionCartera;
	}

	public double getCapitalTotal() {
		return capitalTotal;
	}

	public Instant getFechaCreacionCartera() {
		return fechaCreacionCartera;
	}

	void setCapitalTotal(double capitalTotal) {
		this.capitalTotal = capitalTotal;
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

	public double getRentabilidadActual() {
		return rentabilidadActual;
	}

	/*
	 * Esto no significa que vaya a setear el valor de la rentabilidad a pelo sino
	 * que en el metodo para calcularla que está en el gestor cartera, llamará a
	 * este metodo para asignarsela
	 */
	void setRentabilidadActual(double rentabilidadActual) {
		this.rentabilidadActual = rentabilidadActual;
	}

	@Override
	public String toString() {
		return "CarteraInversion " + getNombreCartera() + ": " + getProductosFinancieros() + ", capital total: "
				+ getCapitalTotal() + ", creada el: " + getFechaCreacionCartera() + ", usuarios: " + getUsuarios()
				+ ", Rentabilidad Actual:" + getRentabilidadActual();
	}

}
