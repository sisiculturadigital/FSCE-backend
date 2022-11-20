package ep.fsce.seguro.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ep.fsce.seguro.backend.domain.PersRem;

public interface PersRemRepository extends JpaRepository<PersRem, String> {

	@Query(value = "SELECT * FROM FS_PERSONA_REM WHERE VCOD_ADM =?1", nativeQuery = true)
	Optional<PersRem> findByVCodAdm(String codAdm);

	@Modifying
	@Transactional
	@Query("UPDATE PersRem SET vNroCel=:cell , vEmail=:email , vDir=:dir , vNroCta=:nroCuenta, vNroCci=:cci WHERE vCodAdm =:vCodAdm")
	void updateCuenta(String cell, String email, String dir, String nroCuenta, String cci, String vCodAdm);

}
