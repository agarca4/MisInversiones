package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.mdef.productosfinancieros.ProductoFinanciero;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

@Entity
public class CarteraInversion {

	@Id
	private String nombreCartera;
	private Instant fechaCreacionCartera;
	private double capitalTotal;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@ElementCollection
	private Collection<Usuario> usuarios = new ArrayList<>();
	private double rentabilidadActual;

	@ElementCollection
	@MapKeyClass(FondoInversion.class)
	@Column(name = "PRECIO_ADQUISICION")
	private Map<ProductoFinanciero, Double> productosFinancieros = new HashMap<>();

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

	public Map<ProductoFinanciero, Double> getProductosFinancieros() {
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
