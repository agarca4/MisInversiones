package es.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.backend.usuarios.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}
