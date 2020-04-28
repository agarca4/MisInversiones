package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import es.mdef.productosfinancieros.ProductoFinancieroImpl;
import es.mdef.usuarios.Usuario;

@Entity
public class CarteraInversion {

	@Id
	@Column(name= "NOMBRE_CARTERA")
	private String nombreCartera;
	private Instant fechaCreacionCartera;
	private double capitalTotal;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "cartera")
	private Collection<Usuario> usuarios = new ArrayList<>();
	private double rentabilidadActual;

	// @ElementCollection
	@OneToMany(targetEntity = ProductoFinancieroImpl.class, mappedBy = "cartera", cascade = CascadeType.ALL)
	//@MapKeyClass(FondoInversion.class)
	@MapKeyClass( ProductoFinancieroImpl.class )
	//@Column(name = "PRECIO_ADQUISICION")
	private Map<ProductoFinancieroImpl, Double> productosFinancieros = new HashMap<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ninguna Cartera fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	CarteraInversion() {
		setFechaCreacionCartera(Instant.now());

	}

	void setFechaCreacionCartera(Instant fechaCreacionCartera) {
		this.fechaCreacionCartera = fechaCreacionCartera;
	}
	@OneToMany(targetEntity = ProductoFinancieroImpl.class)
	public Map<ProductoFinancieroImpl, Double> getProductosFinancieros() {
		return productosFinancieros;
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

	@OneToMany(targetEntity = Usuario.class)
	public Collection<Usuario> getUsuarios() {
		return usuarios;
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
