package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.backend.productosfinancieros.FondoInversionMixto;

@Repository
public interface FondoInversionMixtoDAO extends JpaRepository<FondoInversionMixto, String> {

}
