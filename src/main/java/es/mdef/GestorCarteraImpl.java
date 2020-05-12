package es.mdef;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

//Esta es la clase que controla el negocio, el usuario hará todas las gestiones a través de su GestorCartera

public class GestorCarteraImpl implements GestorCartera<FondoInversion, CarteraInversion> {

	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);
	private CarteraInversion cartera;

	public CarteraInversion getCartera() {
		return cartera;
	}

	public GestorCarteraImpl(String nombreCartera) {
		this.cartera = new CarteraInversion();
		getCartera().setNombre(nombreCartera);
	}

	@Override
	public void compraProductoFinanciero(FondoInversion fondo, Double capitalInvertido) {

		if (!(getCartera().getFondos().contains(fondo))) {
			getCartera().getFondos().add(fondo);
			fondo.setCartera(getCartera());
			fondo.setCapitalInvertido(capitalInvertido);

		} else {
			fondo.setCapitalInvertido(fondo.getCapitalInvertido() + capitalInvertido);
		}

	}

	@Override
	public void vendeProductoFinanciero(FondoInversion producto, Double capitalDesinvertido) {

		if (getCartera().getFondos().contains(producto)
				&& capitalDesinvertido.doubleValue() >= producto.getCapitalInvertido()) {
			producto.setCapitalInvertido(0.0);
			getCartera().getFondos().remove(producto);
			producto.setCartera(null);
		} else if (getCartera().getFondos().contains(producto)
				&& capitalDesinvertido.doubleValue() < producto.getCapitalInvertido()) {
			producto.setCapitalInvertido(
					producto.getCapitalInvertido().doubleValue() - capitalDesinvertido.doubleValue());

		} else {
			log.error("Ese producto no existe en su cartera");

		}

	}

	@Override
	public void altaUsuario(Usuario usuario) {
		if (!(getCartera().getUsuarios().contains(usuario))) {
			getCartera().getUsuarios().add(usuario);
			usuario.setCartera(getCartera());
		} else {
			log.error(String.valueOf("El usuario ya existe " + getCartera().getNombre()));

		}
	}

	@Override
	public void bajaUsuario(Usuario usuario) {

		getCartera().getUsuarios().remove(usuario);
		usuario.setCartera(null);

	}

	@Override
	public Collection<Usuario> listarUsuarios() {

		return getCartera().getUsuarios();

	}

	@Override
	public Collection<FondoInversion> listarProductos() {

		return getCartera().getFondos();

	}

	// este metodo me genera un Json con la info de mi cartera de inversiones
	void generarJsonCartera() {

		File miCartera = new File("MiCartera.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(miCartera, getCartera());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
