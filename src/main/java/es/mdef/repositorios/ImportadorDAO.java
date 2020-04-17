package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.mdef.Importador;

@RepositoryRestResource
public interface ImportadorDAO extends JpaRepository<Importador, Integer> {

}
