package es.mdef.usuarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

//Uso un singleton
//Voy a comentar todo lo referente al generador de iD,s con numeros y voy a usar el de UUID que me sugirió el Cte Lanchas

public class GeneradorId {

//	public static final int MINIMO_ID = 10000;
//	public static final int MAXIMO_ID = 99999;

	private static GeneradorId INSTANCIA = null;
	// private Collection<Integer> historicoIds = new ArrayList<>();
	private Collection<UUID> historicoIds = new ArrayList<>();

	private GeneradorId() {

	}

//	Collection<Integer> getHistoricoIds() {
//		return historicoIds;
//	}

	Collection<UUID> getHistoricoIds() {
		return historicoIds;
	}

	public synchronized static GeneradorId getInstancia() {

		INSTANCIA = (INSTANCIA == null) ? new GeneradorId() : INSTANCIA;

		return INSTANCIA;

	}

	public UUID generaId() {

		// Integer id;
		UUID id;

		do {
			// id = generaNumeroAleatorio(MINIMO_ID, MAXIMO_ID);
			id = UUID.randomUUID();
		} while (getHistoricoIds().contains(id));

		getHistoricoIds().add(id);

		return id;
	}

//	public static int generaNumeroAleatorio(int minimo, int maximo) {
//
//		int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
//		return num;
//	}

}
