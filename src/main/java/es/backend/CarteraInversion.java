package es.backend;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import es.backend.productosfinancieros.ProductoFinancieroImpl;
import es.backend.usuarios.Usuario;

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
	private Map<ProductoFinancieroImpl, Double> productoInversion = new HashMap<>();

	// Implemento el constructor por defecto con modificador de acceso package para
	// evitar que se cree ninguna Cartera fuera
	// del GestorCartera que es quien
	// gobierna la logica del negocio
	CarteraInversion() {

	}

	// Este get no lo uso todavia, pero lo usaré
	Instant getFechaCreacionCartera() {
		return fechaCreacionCartera;
	}

	void setFechaCreacionCartera(Instant fechaCreacionCartera) {
		this.fechaCreacionCartera = fechaCreacionCartera;
	}

	Map<ProductoFinancieroImpl, Double> getProductoInversion() {
		return productoInversion;
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

	void setRentabilidadActual(double rentabilidadActual) {
		this.rentabilidadActual = rentabilidadActual;
	}

}
