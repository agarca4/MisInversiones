package es.backend;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.backend.productosfinancieros.ProductoFinanciero;
import es.backend.productosfinancieros.ProductoFinancieroImpl;
import es.backend.usuarios.Usuario;

//Esta es la clase que controla el negocio, el usuario hará todas las gestiones a través de su GestorCartera
public class GestorCarteraImpl implements GestorCartera<ProductoFinancieroImpl> {

	private static final Logger log = LoggerFactory.getLogger(GestorCarteraImpl.class);
	private CarteraInversion cartera;
	private Importador importador;

	// uso private para los get de cartera e importador, xq quiero que todo se haga
	// a traves del gestor
	public CarteraInversion getCartera() {
		return cartera;
	}

	public Importador getImportador() {
		return importador;
	}

//Ahora mismo no uso la fecha de creacion de la cartera, pero me será util cuando implemente más funcionalidades
	public GestorCarteraImpl() {
		super();
		this.cartera = new CarteraInversion();
		getCartera().setFechaCreacionCartera(Instant.now());
		this.importador = new Importador();
	}

	@Override
	public void asignarNombre(String nombre) {
		getCartera().setNombreCartera(nombre);
	}

	@Override
	public void compraProductoFinanciero(ProductoFinancieroImpl producto, double capitalInvertido) {
		getCartera().setCapitalTotal(getCartera().getCapitalTotal() + capitalInvertido);

		if (!(getCartera().getProductoInversion().containsKey(producto))) {
			getCartera().getProductoInversion().put(producto, capitalInvertido);

		} else {

			double valorAnterior = getCartera().getProductoInversion().get(producto);
			getCartera().getProductoInversion().put(producto, valorAnterior + capitalInvertido);
		}

	}

	@Override
	public void vendeProductoFinanciero(ProductoFinancieroImpl producto, double capitalDesinvertido) {

		getCartera().setCapitalTotal(getCartera().getCapitalTotal() - capitalDesinvertido);

		double valorAnterior = getCartera().getProductoInversion().get(producto);
		if (valorAnterior == capitalDesinvertido) {
			getCartera().getProductoInversion().remove(producto);
		} else {
			getCartera().getProductoInversion().put(producto, valorAnterior - capitalDesinvertido);
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
			log.info(String.valueOf("El usuario que pretende dar de alta ya está asociado a la cartera"
					+ getCartera().getNombreCartera()));

		}
	}

	@Override
	public void bajaUsuario(Usuario usuario) {

		getCartera().getUsuarios().remove(usuario);

	}

	@Override
	public void importarDatos() throws ParseException, IOException {
		getImportador().importar();
	}

	@Override
	public String listarUsuarios() {
		String usuariosCartera = "";
		for (Usuario usuarios : getCartera().getUsuarios()) {
			usuariosCartera += usuarios.toString() + "\n";
		}
		log.info(String.valueOf(usuariosCartera));
		return usuariosCartera;

	}

	@Override
	public String listarProductos() {

		String claveValor = "";
		Iterator<ProductoFinancieroImpl> it = getCartera().getProductoInversion().keySet().iterator();

		while (it.hasNext()) {
			ProductoFinanciero key = it.next();
			claveValor += "Clave: " + key + " -> Valor: " + getCartera().getProductoInversion().get(key) + "\n";

		}
		log.info(String.valueOf(claveValor));
		return claveValor;

	}

	@Override
	public double caculaRentabilidad() {
		double valorActual = 0.0;
		double valorInicial = 0.0;
		double rentabilidadParcial = 0.0;
		double rentabilidadCartera = 0.0;
		String nombre = "";
		Iterator<ProductoFinancieroImpl> it = getCartera().getProductoInversion().keySet().iterator();

		while (it.hasNext()) {
			ProductoFinanciero key = it.next();
			valorInicial = getCartera().getProductoInversion().get(key);
			nombre = ((ProductoFinancieroImpl) key).getNombreProducto();
			for (InformacionMercado producto : getImportador().getInformeMercado()) {
				String nombreProductoImportado = producto.getNombreProductoFinancieroImportado();
				if (nombre.contains(nombreProductoImportado)) {
					valorActual = producto.getValorActualDeMercado();
					rentabilidadParcial = (((valorActual - valorInicial) / valorInicial) * 100) * valorInicial
							/ getCapitalTotal();
				}

			}
			rentabilidadCartera += rentabilidadParcial;
			getCartera().setRentabilidadActual(rentabilidadCartera);
		}
		log.info(String
				.valueOf("Actualmente la rentabilidad financiera de su cartera es del " + rentabilidadCartera + "%"));
		return rentabilidadCartera;

	}

	//Este metodo se corresponde con el Caso de Uso CONSULTAR CARTERA
	@Override
	public void consultarCartera() throws ParseException, IOException {
		importarDatos();
		caculaRentabilidad();
		listarProductos();
		getCapitalTotal();
	}

}
