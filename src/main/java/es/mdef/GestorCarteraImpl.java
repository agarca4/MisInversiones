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

public class GestorCarteraImpl implements GestorCartera<FondoInversion, CarteraInversion, Importador> {

	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);
	private CarteraInversion cartera;
	private Importador importador;

	// uso private para los get de cartera e importador, xq quiero que todo se haga
	// a traves del gestor
	@Override
	public CarteraInversion getCartera() {
		return cartera;
	}

	@Override
	public Importador getImportador() {
		return importador;
	}

	public GestorCarteraImpl(String nombreCartera) {
		super();
		this.cartera = new CarteraInversion();
		this.importador = new Importador();
		getCartera().setNombreCartera(nombreCartera);
	}

	@Override
	public void compraProductoFinanciero(FondoInversion producto, Double capitalInvertido) {
		getCartera().setCapitalTotal(getCartera().getCapitalTotal() + capitalInvertido);

		if (!(getCartera().getFondos().contains(producto))) {
			producto.setValor(capitalInvertido);
			getCartera().getFondos().add(producto);
			producto.setCartera(getCartera());

		} else {

			producto.setValor(producto.getValor() + capitalInvertido);

		}

	}

	@Override
	public void vendeProductoFinanciero(FondoInversion producto, Double capitalDesinvertido) {

		if (getCartera().getFondos().contains(producto)
				&& capitalDesinvertido.doubleValue() >= producto.getValor()) {

			getCartera().getFondos().remove(producto);
			getCartera().setCapitalTotal(getCartera().getCapitalTotal() - producto.getValor().doubleValue());
			producto.setCartera(null);
		} else if (getCartera().getFondos().contains(producto)
				&& capitalDesinvertido.doubleValue() < producto.getValor()) {
			getCartera().setCapitalTotal(getCartera().getCapitalTotal() - capitalDesinvertido.doubleValue());
			producto.setValor(producto.getValor().doubleValue() - capitalDesinvertido.doubleValue());

		} else {
			log.error("Ese producto no existe en su cartera");

		}

	}

	@Override
	public Double getCapitalTotal() {
		return getCartera().getCapitalTotal();
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		if (!(getCartera().getUsuarios().contains(usuario))) {
			getCartera().getUsuarios().add(usuario);
			usuario.setCartera(getCartera());
		} else {
			log.error(String.valueOf("El usuario ya existe " + getCartera().getNombreCartera()));

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

	@Override
	public Double caculaRentabilidad() {
		Double valorActual = 0.0;
		Double valorInicial = 0.0;
		Double rentabilidadCartera = 0.0;

		for (FondoInversion producto : getCartera().getFondos()) {
			valorInicial += producto.getValor();
		}
		for (String nombreProductoImportado : getImportador().getInformeMercado().keySet()) {
			valorActual += getImportador().getInformeMercado().get(nombreProductoImportado);

		}

		rentabilidadCartera = (((valorActual - valorInicial) / valorInicial) * 100) * valorInicial /

				getCapitalTotal();

		getCartera().setRentabilidadActual(rentabilidadCartera);

		return rentabilidadCartera;

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

	// Este metodo se corresponde con el Caso de Uso CONSULTAR CARTERA
	@Override
	public void consultarCartera(String url) {
		getImportador().importar(url);
		caculaRentabilidad();
		listarProductos();
		listarUsuarios();
		getCapitalTotal();
		generarJsonCartera();
	}

}
