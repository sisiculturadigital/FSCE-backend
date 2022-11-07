package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.AporteFscec;

@Repository
public interface AporteFscecRepository extends JpaRepository<AporteFscec, String> {

	List<AporteFscec> findByCodAdm(String codAdm);

}
