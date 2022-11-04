package ep.fsce.seguro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ep.fsce.seguro.backend.domain.MovimientoUsuario;

@Repository
public interface MovUsuarioRepository extends JpaRepository<MovimientoUsuario, Long>{

}
