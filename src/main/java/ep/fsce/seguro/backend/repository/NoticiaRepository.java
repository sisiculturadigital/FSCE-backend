package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	@Query(value = "SELECT * FROM TW_NOTICIA N WHERE N.aa_public =?1 AND N.mm_public =?2  order by FECHA_REGISTRO desc", nativeQuery = true)
	List<Noticia> findNoticiaMesAnio(String anio, String mes);
}
