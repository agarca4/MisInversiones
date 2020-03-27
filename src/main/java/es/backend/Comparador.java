package es.backend;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.backend.usuarios.Usuario;

// Esta clase no aporta ninguna funcionalidad al negocio, la hago porque nos
// dijo que metieramos de todo un poco
// para comprobar que se sabe hacer un comparador de varios niveles
// de hecho no la meto en el UML
public class Comparador {

	static Comparator<Usuario> COMPARADOR_NOMBRE = (o1, o2) -> o1.getNombre().compareTo(o2.getNombre());
	static Comparator<Usuario> COMPARADOR_ID = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

	public static void ordenarUsuarios(List<Usuario> usuarios) {
		Collections.sort(usuarios, Comparador.COMPARADOR);
	}

	// primero me compara el nombre y si es el mismo se va al id
	public static final Comparator<Usuario> COMPARADOR = new Comparator<Usuario>() {

		@Override
		public int compare(Usuario o1, Usuario o2) {

			int valorComparacion = COMPARADOR_NOMBRE.compare(o1, o2);

			if (valorComparacion == 0) {

				valorComparacion = COMPARADOR_ID.compare(o1, o2);
			}

			return valorComparacion;
		}

	};

}