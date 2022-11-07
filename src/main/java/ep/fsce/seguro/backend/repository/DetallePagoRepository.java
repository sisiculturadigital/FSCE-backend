package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.DetallePago;
import ep.fsce.seguro.backend.domain.DetallePagoPk;

@Repository
public interface DetallePagoRepository extends JpaRepository<DetallePago, DetallePagoPk> {

	@Query("SELECT d FROM DetallePago d WHERE d.detallePagopk.codAdm = ?1 and d.detallePagopk.aaCuo = ?2 "
			+ "and d.detallePagopk.mmCuo = ?3 and d.detallePagopk.nroChe = ?4")
	List<DetallePago> buscarDetalle(String codAdm, String aaCuo, String mmCuo, String nroChe);

}
