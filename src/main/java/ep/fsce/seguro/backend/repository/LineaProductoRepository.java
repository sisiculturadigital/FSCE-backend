package ep.fsce.seguro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.LineaProducto;
import ep.fsce.seguro.backend.domain.LineaProductoPk;

@Repository
public interface LineaProductoRepository extends JpaRepository<LineaProducto, LineaProductoPk> {

}
