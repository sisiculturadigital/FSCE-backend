package ep.fsce.seguro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

	@Query("SELECT t FROM TipoUsuario t WHERE t.idTipo =?1")
	TipoUsuario findByTipoUsuario(Integer id);

}
