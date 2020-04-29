package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;

@RepositoryRestResource
public interface FondoInversionDAO extends JpaRepository<FondoInversion, Integer>{

}
