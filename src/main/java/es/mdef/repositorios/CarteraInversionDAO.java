package es.mdef.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.CarteraInversion;

@RepositoryRestResource(path="portfolio", itemResourceRel = "portfolio", collectionResourceRel = "portfolios")
public interface CarteraInversionDAO extends JpaRepository<CarteraInversion, String> {


}
