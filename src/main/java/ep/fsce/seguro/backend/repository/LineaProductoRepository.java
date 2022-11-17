package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.LineaProducto;
import ep.fsce.seguro.backend.domain.LineaProductoPk;

@Repository
public interface LineaProductoRepository extends JpaRepository<LineaProducto, LineaProductoPk> {
	
	@Query(value = "SELECT * FROM TW_LINEA_PRODUCTO WHERE dni =?1", nativeQuery = true)
	List<LineaProducto> findByLineaDni(String dni);
	
	
}
