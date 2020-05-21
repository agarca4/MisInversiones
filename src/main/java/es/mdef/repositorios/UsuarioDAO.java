package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.mdef.usuarios.Usuario;

@CrossOrigin(origins = {"http://localhost:4200" , "https://agarca4.github.io"})
@RepositoryRestResource(path = "usuarios", itemResourceRel = "usuario", collectionResourceRel = "usuarios")
public interface UsuarioDAO extends JpaRepository<Usuario, String> {

}
