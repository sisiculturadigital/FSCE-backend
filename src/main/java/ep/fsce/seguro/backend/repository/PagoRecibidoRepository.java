package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.PagoRecibido;

@Repository
public interface PagoRecibidoRepository extends JpaRepository<PagoRecibido, String> {
	List<PagoRecibido> findByCodAdm(String codAdm);
}
