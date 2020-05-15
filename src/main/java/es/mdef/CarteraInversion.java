package es.mdef;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

@Entity
@Table(name = "CARTERAS")
public class CarteraInversion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private String id;
	@Column(name = "NOMBRE_CARTERA")
	private String nombre;
	@Column(name = "FECHA_ALTA")
	private Instant fechaCreacionCartera;
	@Column(name = "CAPITAL_INVERTIDO")
	private double capitalInvertido;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "cartera")
	private Collection<Usuario> usuarios = new ArrayList<>();
	private Double rentabilidad;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = FondoInversion.class, mappedBy = "cartera")
	private Collection<FondoInversion> fondos = new ArrayList<>();

	CarteraInversion() {
		setFechaCreacionCartera(Instant.now());

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<FondoInversion> getFondos() {
		return fondos;
	}

	public void setFondos(Collection<FondoInversion> fondos) {
		this.fondos = fondos;
	}

	public Instant getFechaCreacionCartera() {
		return fechaCreacionCartera;
	}

	void setFechaCreacionCartera(Instant fechaCreacionCartera) {
		this.fechaCreacionCartera = fechaCreacionCartera;
	}

	public double getCapitalInvertido() {

		this.capitalInvertido = 0.0;

		for (FondoInversion fondoInversion : getFondos()) {
			capitalInvertido += fondoInversion.getCapitalInvertido();
		}
		return capitalInvertido;
	}

	public String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	// rentabilidad = (((valorActual - valorInicial) / valorInicial) * 100) *
	// (proporcion inversion en ese producto respecto a la inversion total)
	public Double getRentabilidad() {

		Importador.importar();
		Map<String, Double> capitalInvertido = new HashMap<>();
		Map<String, Double> misFondos = new HashMap<>();
		rentabilidad = 0.0;

		for (FondoInversion producto : getFondos()) {
			misFondos.put(producto.getNombre(), producto.getPrecioParticipacion());
			capitalInvertido.put(producto.getNombre(), producto.getCapitalInvertido());

		}
		for (String nombreProductoImportado : Importador.getInformeMercado().keySet()) {
			if (misFondos.containsKey(nombreProductoImportado)) {
				rentabilidad += (((Importador.getInformeMercado().get(nombreProductoImportado)
						- misFondos.get(nombreProductoImportado)) / misFondos.get(nombreProductoImportado)) * 100)
						* (capitalInvertido.get(nombreProductoImportado) / getCapitalInvertido());
			}

		}

		return rentabilidad;
	}

	@Override
	public String toString() {
		return getNombre() + ": " + getFondos() + ", capital total: " + getCapitalInvertido() + ", creada el: "
				+ getFechaCreacionCartera() + ", usuarios: " + getUsuarios() + ", Rentabilidad:" + getRentabilidad();
	}

}
