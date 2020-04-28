package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.mdef.usuarios.Usuario;

@RepositoryRestResource
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

}
