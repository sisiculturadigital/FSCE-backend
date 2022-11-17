package ep.fsce.seguro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
	
	Optional<Producto> findByEcPtmo(String ecPtmo);

}
