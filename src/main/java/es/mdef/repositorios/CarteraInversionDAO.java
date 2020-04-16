package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.mdef.CarteraInversion;

@Repository
public interface CarteraInversionDAO extends JpaRepository<CarteraInversion, String> {

}
