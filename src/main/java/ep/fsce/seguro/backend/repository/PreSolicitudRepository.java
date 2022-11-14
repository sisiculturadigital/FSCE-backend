package ep.fsce.seguro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.PreSolicitud;

@Repository
public interface PreSolicitudRepository extends JpaRepository<PreSolicitud, String> {
	
	@Query(value = "SELECT COUNT(*) FROM TW_PRESOL", nativeQuery = true)
	Integer cantidadRegistros();

}
