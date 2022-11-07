package ep.fsce.seguro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

}
