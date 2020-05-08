package es.mdef.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import es.mdef.CarteraInversion;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path="carteras", itemResourceRel = "cartera", collectionResourceRel = "carteras")
public interface CarteraInversionDAO extends JpaRepository<CarteraInversion, String> {


}
