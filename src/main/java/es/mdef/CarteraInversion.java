package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

@Entity
public class CarteraInversion {

	@Id
	private String nombreCartera;
	private Instant fechaCreacionCartera;
	private double capitalTotal;
	@ElementCollection
	private Collection<Usuario> usuarios = new ArrayList<>();
	private double rentabilidadActual;
	@ElementCollection
	@CollectionTable(name = "PRODUCTOS_EN_CARTERA")
    @Column(name = "PRECIO_ADQUISICION")
	private Map<FondoInversion, Double> productosFinancieros = new HashMap<>();

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

	Map<FondoInversion, Double> getProductosInversion() {
		return productosFinancieros;
	}

	double getCapitalTotal() {
		return capitalTotal;
	}

	void setCapitalTotal(double capitalTotal) {
		this.capitalTotal = capitalTotal;
	}

	String getNombreCartera() {
		return nombreCartera;
	}

	void setNombreCartera(String nombreCartera) {
		this.nombreCartera = nombreCartera;
	}

	Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	double getRentabilidadActual() {
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

}