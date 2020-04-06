package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.backend.Importador;

@Repository
public interface ImportadorDAO extends JpaRepository<Importador, Integer> {

}