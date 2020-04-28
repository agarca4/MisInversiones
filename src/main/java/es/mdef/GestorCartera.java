package es.mdef;

import java.util.Collection;
import java.util.Map;
import es.mdef.usuarios.Usuario;

public interface GestorCartera<T, S, U> {

	public S getCartera();

	public U getImportador();

	public void compraProductoFinanciero(T producto, Double capitalInvertido);

	public void vendeProductoFinanciero(T producto, Double capitalDesinvertido);

	public double getCapitalTotal();

	public void altaUsuario(Usuario usuario);

	public void bajaUsuario(Usuario usuario);

	public Collection<Usuario> listarUsuarios();

	public Map<T, Double> listarProductos();

	public double caculaRentabilidad();

	public void consultarCartera(String url);

}
