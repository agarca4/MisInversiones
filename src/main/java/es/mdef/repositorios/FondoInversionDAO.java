package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.mdef.productosfinancieros.fondosinversion.FondoInversion;

@RepositoryRestResource(path = "fondos", itemResourceRel = "fondo", collectionResourceRel = "fondos")
public interface FondoInversionDAO extends JpaRepository<FondoInversion, String> {

}
