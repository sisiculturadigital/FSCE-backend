package ep.fsce.seguro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findByEmail(String email);

	@Query("SELECT t FROM Usuario t WHERE t.email =?1 and t.password=?2")
	Usuario findEmailPass(String email, String pass);
	
	Optional<Usuario> findByDniAndCodAdm(String dni , String codAdm);
}
