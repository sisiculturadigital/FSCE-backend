package ep.fsce.seguro.backend.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String>{
	
	Optional<Persona> findByDni(String dni);
	Optional<Persona> findByCodAdm(String codAdm);
	Optional<Persona> findByDniAndCodAdmAndFecNac(String dni , String codAdm , Date fecha);
}