package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.backend.productosfinancieros.FondoInversionRentaFija;

@Repository
public interface FondoInversionRentaFijaDAO extends JpaRepository<FondoInversionRentaFija, String> {

}
