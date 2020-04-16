package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.mdef.Importador;

@Repository
public interface ImportadorDAO extends JpaRepository<Importador, Integer> {

}
