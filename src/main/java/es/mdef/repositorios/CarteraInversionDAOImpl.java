package es.mdef.repositorios;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import es.mdef.CarteraInversion;

@Transactional(readOnly = true)
public class CarteraInversionDAOImpl implements CarteraInversionDAOCustom {

	@Autowired
	CarteraInversionDAO carteraInversionDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<CarteraInversion> getCarterasPorCapitalInvertido(double capital) {

		List<CarteraInversion> carteras = carteraInversionDAO.findAll().stream()
				.filter(j -> j.getCapitalInvertido() == capital).collect(Collectors.toList());

		return carteras;
	}

	@Override
	public List<CarteraInversion> getCarterasPorRentabilidadMinima(Double rentabilidadMinima) {
		List<CarteraInversion> carteras = carteraInversionDAO.findAll().stream()
				.filter(j -> j.getRentabilidad() > rentabilidadMinima).collect(Collectors.toList());

		return carteras;
	}
}
