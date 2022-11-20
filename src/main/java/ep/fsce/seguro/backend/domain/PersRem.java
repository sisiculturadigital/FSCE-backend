package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_PERSONA_REM")
public class PersRem implements Serializable {

	@Id
	@Column(name = "VCOD_ADM")
	private String vCodAdm;

	@Column(name = "VDNI")
	private String vDni;

	@Column(name = "VGRADO")
	private String vGrado;

	@Column(name = "VNOM")
	private String vNom;

	@Column(name = "VNRO_CEL")
	private String vNroCel;

	@Column(name = "VEMAIL")
	private String vEmail;

	@Column(name = "VDIR")
	private String vDir;

	@Column(name = "DFEC_ING")
	private Date dFecIng;

	@Column(name = "DFEC_BAJ")
	private Date dFecBaj;

	@Column(name = "DFEC_PRO")
	private Date dFecPro;

	@Column(name = "VNRO_CTA")
	private String vNroCta;

	@Column(name = "VNRO_CCI")
	private String vNroCci;

	@Column(name = "VIP")
	private String vip;

	@Column(name = "VUSU_VERIF")
	private String vUsuVerif;

	@Column(name = "DFEC_VERIF")
	private Date dFecVerif;

	@Column(name = "DFEC_APO")
	private Date dFecApo;

	@Column(name = "DFEC_ULT_APO")
	private Date dFecUltApo;

	@Column(name = "NNRO_APO")
	private String nNroApo;

	@Column(name = "NIMP_APO")
	private Double nImpApo;

	@Column(name = "NIMP_BENEF")
	private Double nImpBenef;

	@Column(name = "NIMP_REM1")
	private Double nImpRem1;

	@Column(name = "NIMP_REM2")
	private Double nImpRem2;

	@Column(name = "VTIP_FON")
	private String vTipFon;

	@Column(name = "DFEC_REM1")
	private Date dFecRem1;

	@Column(name = "DFEC_REM2")
	private Date dFecRem2;

	@Column(name = "DFEC_NAC")
	private Date dFecNac;

	public String getvCodAdm() {
		return vCodAdm;
	}

	public void setvCodAdm(String vCodAdm) {
		this.vCodAdm = vCodAdm;
	}

	public String getvDni() {
		return vDni;
	}

	public void setvDni(String vDni) {
		this.vDni = vDni;
	}

	public String getvGrado() {
		return vGrado;
	}

	public void setvGrado(String vGrado) {
		this.vGrado = vGrado;
	}

	public String getvNom() {
		return vNom;
	}

	public void setvNom(String vNom) {
		this.vNom = vNom;
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

	public String getvDir() {
		return vDir;
	}

	public void setvDir(String vDir) {
		this.vDir = vDir;
	}

	public Date getdFecIng() {
		return dFecIng;
	}

	public void setdFecIng(Date dFecIng) {
		this.dFecIng = dFecIng;
	}

	public Date getdFecBaj() {
		return dFecBaj;
	}

	public void setdFecBaj(Date dFecBaj) {
		this.dFecBaj = dFecBaj;
	}

	public Date getdFecPro() {
		return dFecPro;
	}

	public void setdFecPro(Date dFecPro) {
		this.dFecPro = dFecPro;
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

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
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

	public Date getdFecApo() {
		return dFecApo;
	}

	public void setdFecApo(Date dFecApo) {
		this.dFecApo = dFecApo;
	}

	public Date getdFecUltApo() {
		return dFecUltApo;
	}

	public void setdFecUltApo(Date dFecUltApo) {
		this.dFecUltApo = dFecUltApo;
	}

	public String getnNroApo() {
		return nNroApo;
	}

	public void setnNroApo(String nNroApo) {
		this.nNroApo = nNroApo;
	}

	public Double getnImpApo() {
		return nImpApo;
	}

	public void setnImpApo(Double nImpApo) {
		this.nImpApo = nImpApo;
	}

	public Double getnImpBenef() {
		return nImpBenef;
	}

	public void setnImpBenef(Double nImpBenef) {
		this.nImpBenef = nImpBenef;
	}

	public Double getnImpRem1() {
		return nImpRem1;
	}

	public void setnImpRem1(Double nImpRem1) {
		this.nImpRem1 = nImpRem1;
	}

	public Double getnImpRem2() {
		return nImpRem2;
	}

	public void setnImpRem2(Double nImpRem2) {
		this.nImpRem2 = nImpRem2;
	}

	public String getvTipFon() {
		return vTipFon;
	}

	public void setvTipFon(String vTipFon) {
		this.vTipFon = vTipFon;
	}

	public Date getdFecRem1() {
		return dFecRem1;
	}

	public void setdFecRem1(Date dFecRem1) {
		this.dFecRem1 = dFecRem1;
	}

	public Date getdFecRem2() {
		return dFecRem2;
	}

	public void setdFecRem2(Date dFecRem2) {
		this.dFecRem2 = dFecRem2;
	}

	public Date getdFecNac() {
		return dFecNac;
	}

	public void setdFecNac(Date dFecNac) {
		this.dFecNac = dFecNac;
	}

	private static final long serialVersionUID = 1L;
}
