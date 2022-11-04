package ep.fsce.seguro.backend.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Persona;
import ep.fsce.seguro.backend.dto.PersonaBean;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String>{
	Optional<PersonaBean> findByDni(String dni);
	Optional<PersonaBean> findByDniAndCodAdmAndFecNac(String dni , String codAdm , Date fecha);
}
