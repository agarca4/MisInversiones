package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.backend.Importador;
import es.backend.InformacionMercado;

@Repository
public interface InformacionMercadoDAO extends JpaRepository<InformacionMercado, Long>{

}
