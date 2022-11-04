package ep.fsce.seguro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.PrestamoInsp;

@Repository
public interface PrestamosIsnpRepository extends JpaRepository<PrestamoInsp, String>{
	List<PrestamoInsp> findByDni(String dni);
}
