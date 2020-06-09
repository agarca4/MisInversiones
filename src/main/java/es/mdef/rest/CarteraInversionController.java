package es.mdef.rest;

import java.util.List;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import es.mdef.CarteraInversion;
import es.mdef.repositorios.CarteraInversionDAO;


@RepositoryRestController
@RequestMapping(path = "/carteras/search")
public class CarteraInversionController {

	private CarteraInversionDAO carteraInversionDAO;

	public CarteraInversionController(CarteraInversionDAO carteraInversionDAO) {
		this.carteraInversionDAO = carteraInversionDAO;
	}

	@GetMapping("/por-capital-invertido")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getCarterasPorCapitalInvertido(@RequestParam double capital,
			PersistentEntityResourceAssembler assembler) {

		List<CarteraInversion> carteras = carteraInversionDAO.getCarterasPorCapitalInvertido(capital);

		return assembler.toCollectionModel(carteras);
	}

	@GetMapping("/por-rentabilidad")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getCarterasPorRentabilidad(@RequestParam Double rentabilidadMinima,
			PersistentEntityResourceAssembler assembler) {

		List<CarteraInversion> carteras = carteraInversionDAO.getCarterasPorRentabilidadMinima(rentabilidadMinima);

		return assembler.toCollectionModel(carteras);
	}
}
