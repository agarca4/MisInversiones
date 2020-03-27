package es.backend.productosfinancieros;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProductoFinancieroFactory {

	@SuppressWarnings("unchecked")
	public static <T extends ProductoFinanciero> T crearProductoFinanciero(Class<T> tipo, Class<?>[] params,
			Object[] valuesClasses) {
		try {
			Constructor<?> cons = tipo.getDeclaredConstructor(params);

			return (T) cons.newInstance(valuesClasses);

		} catch (SecurityException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

//Si peta en algun sitio, devuelvo null
		return null;
	}

}
