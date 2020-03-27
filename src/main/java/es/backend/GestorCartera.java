package es.backend;

import java.io.IOException;
import java.text.ParseException;

import es.backend.usuarios.Usuario;

public interface GestorCartera<T> {

	public void asignarNombre(String nombre);

	public void compraProductoFinanciero(T producto, double capitalInvertido);

	public void vendeProductoFinanciero(T producto, double capitalDesinvertido);

	public double getCapitalTotal();

	public void altaUsuario(Usuario usuario);

	public void bajaUsuario(Usuario usuario);

	public void importarDatos() throws ParseException, IOException;

	// me interesa que estos dos metodos me devuelvan el String por si en un futuro
	// hago una clase Informe que se alimente de ellos
	public String listarUsuarios();

	public String listarProductos();

	public double caculaRentabilidad();

}
