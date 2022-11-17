package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	@Query(value = "SELECT * FROM TW_NOTICIA T WHERE MONTH(T.FECHA_REGISTRO) = MONTH(CURRENT_TIMESTAMP) AND YEAR(T.FECHA_REGISTRO) = YEAR(FECHA_REGISTRO)", nativeQuery = true)
	List<Noticia> findNoticiaMesAnio();
}
