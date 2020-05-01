package es.mdef;

import java.util.Collection;

import es.mdef.usuarios.Usuario;

public interface GestorCartera<T, S, U> {

	public S getCartera();

	public U getImportador();

	public void compraProductoFinanciero(T producto, Double capitalInvertido);

	public void vendeProductoFinanciero(T producto, Double capitalDesinvertido);

	public Double getCapitalTotal();

	public void altaUsuario(Usuario usuario);

	public void bajaUsuario(Usuario usuario);

	public Collection<Usuario> listarUsuarios();

	public Collection<T> listarProductos();

	public Double calcularRentabilidad(String url);

}
