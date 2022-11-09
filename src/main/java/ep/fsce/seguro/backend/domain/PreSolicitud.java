package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TW_PRESOL")
public class PreSolicitud implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NRO_SOL")
	private String nroSol;

	@Column(name = "NRO_CUO")
	private Integer nroCuo;

	@Column(name = "IMP_SOL")
	private Double impSol;

	@Column(name = "USU_ING")
	private String usuIng;

	@Column(name = "FEC_ING")
	private Date fecIng;

	@Column(name = "NLIQUIDEZ")
	private Double Liquidez;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "EC_PTMO")
	private String ecPtmo;

	public String getNroSol() {
		return nroSol;
	}

	public void setNroSol(String nroSol) {
		this.nroSol = nroSol;
	}

	public Integer getNroCuo() {
		return nroCuo;
	}

	public void setNroCuo(Integer nroCuo) {
		this.nroCuo = nroCuo;
	}

	public Double getImpSol() {
		return impSol;
	}

	public void setImpSol(Double impSol) {
		this.impSol = impSol;
	}

	public String getUsuIng() {
		return usuIng;
	}

	public void setUsuIng(String usuIng) {
		this.usuIng = usuIng;
	}

	public Date getFecIng() {
		return fecIng;
	}

	public void setFecIng(Date fecIng) {
		this.fecIng = fecIng;
	}

	public Double getLiquidez() {
		return Liquidez;
	}

	public void setLiquidez(Double liquidez) {
		Liquidez = liquidez;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEcPtmo() {
		return ecPtmo;
	}

	public void setEcPtmo(String ecPtmo) {
		this.ecPtmo = ecPtmo;
	}

}
