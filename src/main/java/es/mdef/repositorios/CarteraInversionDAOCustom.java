package es.mdef.repositorios;

import java.util.List;

import es.mdef.CarteraInversion;

public interface CarteraInversionDAOCustom {

	List<CarteraInversion> getCarterasPorCapitalInvertido(double capital);

	List<CarteraInversion> getCarterasPorRentabilidadMinima(Double rentabilidadMinima);

}
