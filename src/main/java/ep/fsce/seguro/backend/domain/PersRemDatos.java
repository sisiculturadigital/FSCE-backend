package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_PERSONA_REM_DATOS")
public class PersRemDatos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VCOD_ADM")
	private String vCodAdm;

	@Column(name = "VDIR")
	private String vDir;

	@Column(name = "VDIST")
	private String vDist;

	@Column(name = "VPROV")
	private String vProv;

	@Column(name = "VDEPA")
	private String vDepa;

	@Column(name = "VNRO_CEL")
	private String vNroCel;

	@Column(name = "VEMAIL")
	private String vEmail;

	@Column(name = "VBANCO")
	private String vBanco;

	@Column(name = "VNRO_CTA")
	private String vNroCta;

	@Column(name = "VNRO_CCI")
	private String vNroCci;

	@Column(name = "DFEC_ING")
	private Date dFecIng;

	@Column(name = "VFLAG_VERIF")
	private String vFlagVerif;

	@Column(name = "VFLAG_REG")
	private String vFlagReg;

	@Column(name = "VFLAG_VOUCH")
	private String vFlagVouch;

	@Column(name = "VFLAG_CRONO")
	private String vFlagCrono;

	@Column(name = "VFLAG_DESEM")
	private String vFlagDesem;

	@Column(name = "VFLAG_FALLE")
	private String vFlagFalle;

	@Column(name = "VFLAG_ATRASO_PRES")
	private String vFlagAtrasoPres;

	@Column(name = "VANOMES_ATRASO")
	private String vAnomesAtraso;

	public String getvCodAdm() {
		return vCodAdm;
	}

	public void setvCodAdm(String vCodAdm) {
		this.vCodAdm = vCodAdm;
	}

	public String getvDir() {
		return vDir;
	}

	public void setvDir(String vDir) {
		this.vDir = vDir;
	}

	public String getvDist() {
		return vDist;
	}

	public void setvDist(String vDist) {
		this.vDist = vDist;
	}

	public String getvProv() {
		return vProv;
	}

	public void setvProv(String vProv) {
		this.vProv = vProv;
	}

	public String getvDepa() {
		return vDepa;
	}

	public void setvDepa(String vDepa) {
		this.vDepa = vDepa;
	}

	public String getvNroCel() {
		return vNroCel;
	}

	public void setvNroCel(String vNroCel) {
		this.vNroCel = vNroCel;
	}

	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvBanco() {
		return vBanco;
	}

	public void setvBanco(String vBanco) {
		this.vBanco = vBanco;
	}

	public String getvNroCta() {
		return vNroCta;
	}

	public void setvNroCta(String vNroCta) {
		this.vNroCta = vNroCta;
	}

	public String getvNroCci() {
		return vNroCci;
	}

	public void setvNroCci(String vNroCci) {
		this.vNroCci = vNroCci;
	}

	public Date getdFecIng() {
		return dFecIng;
	}

	public void setdFecIng(Date dFecIng) {
		this.dFecIng = dFecIng;
	}

	public String getvFlagVerif() {
		return vFlagVerif;
	}

	public void setvFlagVerif(String vFlagVerif) {
		this.vFlagVerif = vFlagVerif;
	}

	public String getvFlagReg() {
		return vFlagReg;
	}

	public void setvFlagReg(String vFlagReg) {
		this.vFlagReg = vFlagReg;
	}

	public String getvFlagVouch() {
		return vFlagVouch;
	}

	public void setvFlagVouch(String vFlagVouch) {
		this.vFlagVouch = vFlagVouch;
	}

	public String getvFlagCrono() {
		return vFlagCrono;
	}

	public void setvFlagCrono(String vFlagCrono) {
		this.vFlagCrono = vFlagCrono;
	}

	public String getvFlagDesem() {
		return vFlagDesem;
	}

	public void setvFlagDesem(String vFlagDesem) {
		this.vFlagDesem = vFlagDesem;
	}

	public String getvFlagFalle() {
		return vFlagFalle;
	}

	public void setvFlagFalle(String vFlagFalle) {
		this.vFlagFalle = vFlagFalle;
	}

	public String getvFlagAtrasoPres() {
		return vFlagAtrasoPres;
	}

	public void setvFlagAtrasoPres(String vFlagAtrasoPres) {
		this.vFlagAtrasoPres = vFlagAtrasoPres;
	}

	public String getvAnomesAtraso() {
		return vAnomesAtraso;
	}

	public void setvAnomesAtraso(String vAnomesAtraso) {
		this.vAnomesAtraso = vAnomesAtraso;
	}

}
