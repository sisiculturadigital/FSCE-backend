package ep.fsce.seguro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ep.fsce.seguro.backend.domain.PersRemDatos;

public interface PersRemDatosRepository extends JpaRepository<PersRemDatos, String>{

	@Query(value = "SELECT * FROM FS_PERSONA_REM_DATOS WHERE VCOD_ADM =?1", nativeQuery = true)
	Optional<PersRemDatos> findByVCodAdm(String codAdm);
}
