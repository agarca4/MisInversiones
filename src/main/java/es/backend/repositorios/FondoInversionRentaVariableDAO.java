package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.backend.productosfinancieros.FondoInversionRentaVariable;

@Repository
public interface FondoInversionRentaVariableDAO extends JpaRepository<FondoInversionRentaVariable, String> {

}
