package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_PERSONA_REM_ETAPA")
public class PersRemEtapa implements Serializable {

	@Id
	@Column(name = "VCOD_ADM")
	private String vCodAdm;

	@Column(name = "VFLAG_REG")
	private String vFlagReg;

	@Column(name = "VUSU_REG")
	private String vUsuReg;

	@Column(name = "DFEC_REG")
	private Date vFecReg;

	@Column(name = "VFLAG_VERIF")
	private String vFlagVerif;

	@Column(name = "VUSU_VERIF")
	private String vUsuVerif;

	@Column(name = "DFEC_VERIF")
	private Date dFecVerif;

	@Column(name = "VFLAG_VOUCH")
	private String vFlagVouch;

	@Column(name = "VUSU_VOUCH")
	private String vUsuVouch;

	@Column(name = "DFEC_VOUCH")
	private Date vFecVouch;

	@Column(name = "VFLAG_CRONO")
	private String vFlagCrono;

	@Column(name = "VUSU_CRONO")
	private String vUsuCrono;

	@Column(name = "DFEC_CRONO")
	private Date dFecCrono;

	@Column(name = "VFLAG_DESEM")
	private String vFlagDesem;

	@Column(name = "VUSU_DESEM")
	private String vUsuDesem;

	@Column(name = "DFEC_DESEM")
	private Date dFecDesem;

	public String getvCodAdm() {
		return vCodAdm;
	}

	public void setvCodAdm(String vCodAdm) {
		this.vCodAdm = vCodAdm;
	}

	public String getvFlagReg() {
		return vFlagReg;
	}

	public void setvFlagReg(String vFlagReg) {
		this.vFlagReg = vFlagReg;
	}

	public String getvUsuReg() {
		return vUsuReg;
	}

	public void setvUsuReg(String vUsuReg) {
		this.vUsuReg = vUsuReg;
	}

	public Date getvFecReg() {
		return vFecReg;
	}

	public void setvFecReg(Date vFecReg) {
		this.vFecReg = vFecReg;
	}

	public String getvFlagVerif() {
		return vFlagVerif;
	}

	public void setvFlagVerif(String vFlagVerif) {
		this.vFlagVerif = vFlagVerif;
	}

	public String getvUsuVerif() {
		return vUsuVerif;
	}

	public void setvUsuVerif(String vUsuVerif) {
		this.vUsuVerif = vUsuVerif;
	}

	public Date getdFecVerif() {
		return dFecVerif;
	}

	public void setdFecVerif(Date dFecVerif) {
		this.dFecVerif = dFecVerif;
	}

	public String getvFlagVouch() {
		return vFlagVouch;
	}

	public void setvFlagVouch(String vFlagVouch) {
		this.vFlagVouch = vFlagVouch;
	}

	public String getvUsuVouch() {
		return vUsuVouch;
	}

	public void setvUsuVouch(String vUsuVouch) {
		this.vUsuVouch = vUsuVouch;
	}

	public Date getvFecVouch() {
		return vFecVouch;
	}

	public void setvFecVouch(Date vFecVouch) {
		this.vFecVouch = vFecVouch;
	}

	public String getvFlagCrono() {
		return vFlagCrono;
	}

	public void setvFlagCrono(String vFlagCrono) {
		this.vFlagCrono = vFlagCrono;
	}

	public String getvUsuCrono() {
		return vUsuCrono;
	}

	public void setvUsuCrono(String vUsuCrono) {
		this.vUsuCrono = vUsuCrono;
	}

	public Date getdFecCrono() {
		return dFecCrono;
	}

	public void setdFecCrono(Date dFecCrono) {
		this.dFecCrono = dFecCrono;
	}

	public String getvFlagDesem() {
		return vFlagDesem;
	}

	public void setvFlagDesem(String vFlagDesem) {
		this.vFlagDesem = vFlagDesem;
	}

	public String getvUsuDesem() {
		return vUsuDesem;
	}

	public void setvUsuDesem(String vUsuDesem) {
		this.vUsuDesem = vUsuDesem;
	}

	public Date getdFecDesem() {
		return dFecDesem;
	}

	public void setdFecDesem(Date dFecDesem) {
		this.dFecDesem = dFecDesem;
	}

	private static final long serialVersionUID = 1L;
}
