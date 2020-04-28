package es.mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.productosfinancieros.ProductoFinancieroImpl;

@RepositoryRestResource
public interface ProductoFinancieroImplDAO extends JpaRepository<ProductoFinancieroImpl, Integer>{

}
