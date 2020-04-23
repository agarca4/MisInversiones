package es.mdef;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.mdef.productosfinancieros.ProductoFinanciero;
import es.mdef.usuarios.Usuario;

//Esta es la clase que controla el negocio, el usuario hará todas las gestiones a través de su GestorCartera

public class GestorCarteraImpl implements GestorCartera<ProductoFinanciero, CarteraInversion, Importador> {

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

//Ahora mismo no uso la fecha de creacion de la cartera, pero me será util cuando implemente más funcionalidades
	public GestorCarteraImpl(String nombreCartera) {
		super();
		this.cartera = new CarteraInversion();
		this.importador = new Importador();
		getCartera().setNombreCartera(nombreCartera);
	}

	@Override
	public void compraProductoFinanciero(ProductoFinanciero producto, double capitalInvertido) {
		getCartera().setCapitalTotal(getCartera().getCapitalTotal() + capitalInvertido);

		if (!(getCartera().getProductosFinancieros().containsKey(producto))) {
			getCartera().getProductosFinancieros().put(producto, capitalInvertido);

		} else {

			double valorAnterior = getCartera().getProductosFinancieros().get(producto);
			getCartera().getProductosFinancieros().put(producto, valorAnterior + capitalInvertido);
		}

	}

	@Override
	public void vendeProductoFinanciero(ProductoFinanciero producto, double capitalDesinvertido) {

		if (getCartera().getProductosFinancieros().containsKey(producto)) {

			getCartera().setCapitalTotal(getCartera().getCapitalTotal() - capitalDesinvertido);
			double valorAnterior = getCartera().getProductosFinancieros().get(producto);

			if (valorAnterior == capitalDesinvertido) {
				getCartera().getProductosFinancieros().remove(producto);
			} else {
				getCartera().getProductosFinancieros().put(producto, valorAnterior - capitalDesinvertido);

			}

		} else {
			log.error("Ese producto no existe en su cartera");
		}

	}

	@Override
	public double getCapitalTotal() {
		return getCartera().getCapitalTotal();
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		if (!(getCartera().getUsuarios().contains(usuario))) {
			getCartera().getUsuarios().add(usuario);
		} else {
			log.error(String.valueOf("El usuario que pretende dar de alta ya está asociado a la cartera "
					+ getCartera().getNombreCartera()));

		}
	}

	@Override
	public void bajaUsuario(Usuario usuario) {

		getCartera().getUsuarios().remove(usuario);

	}

	@Override
	public Collection<Usuario> listarUsuarios() {

		return getCartera().getUsuarios();

	}

	@Override
	public Map<ProductoFinanciero, Double> listarProductos() {

		return getCartera().getProductosFinancieros();

	}

	@Override
	public double caculaRentabilidad() {
		double valorActual = 0.0;
		double valorInicial = 0.0;
		double rentabilidadParcial = 0.0;
		double rentabilidadCartera = 0.0;
		Iterator<ProductoFinanciero> it = getCartera().getProductosFinancieros().keySet().iterator();

		while (it.hasNext()) {
			ProductoFinanciero key = it.next();
			valorInicial = getCartera().getProductosFinancieros().get(key);
			for (String nombreProductoImportado : getImportador().getInformeMercado().keySet()) {
				if (key.getNombreProducto().contains(nombreProductoImportado)) {
					valorActual = getImportador().getInformeMercado().get(nombreProductoImportado);
					rentabilidadParcial = (((valorActual - valorInicial) / valorInicial) * 100) * valorInicial
							/ getCapitalTotal();
				}

			}
			rentabilidadCartera += rentabilidadParcial;
			getCartera().setRentabilidadActual(rentabilidadCartera);
		}
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
		getCapitalTotal();
		generarJsonCartera();
	}

}
