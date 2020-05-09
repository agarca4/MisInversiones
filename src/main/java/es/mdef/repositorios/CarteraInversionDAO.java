package es.mdef.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import es.mdef.CarteraInversion;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path="carteras", itemResourceRel = "cartera", collectionResourceRel = "carteras")
public interface CarteraInversionDAO extends JpaRepository<CarteraInversion, String> {
	
	@RestResource(path = "nombre")
	List<CarteraInversion> findByNombreIgnoreCaseContaining(@Param("nombre") String nombre);
	

}




