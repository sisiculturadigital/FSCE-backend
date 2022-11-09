package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALDO_PRESTAMO_INSP")
public class PrestamoInsp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NRO_CHE")
	private String nroChe;

	@Column(name = "COD_ADM")
	private String codAdm;

	@Column(name = "DEST")
	private String dest;

	@Column(name = "TIPO_PREST")
	private String tipoPrest;

	@Column(name = "ANO_ENV")
	private String anoEnv;

	@Column(name = "MES_ENV")
	private String mesEnv;

	@Column(name = "IMP_SOL")
	private Integer impSol;

	@Column(name = "DEUDA_TOT_INI")
	private Integer deudaTotIni;

	@Column(name = "FEC_APROB")
	private Date fecAprob;

	@Column(name = "IMP_DESEMBLS")
	private Integer impDesmbls;

	@Column(name = "NRO_CUO")
	private Integer nroCuo;

	@Column(name = "CUO_MEN")
	private Double cuoMen;

	@Column(name = "CUO_CAP")
	private Double cuoCap;

	@Column(name = "INTERES")
	private Double intereses;

	@Column(name = "SALDO_ACTUAL")
	private Integer saldoActual;

	@Column(name = "SALDO_SINT")
	private Integer saldoSint;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "SALDO_VIGENTE")
	private Integer saldoVigente;

	@Column(name = "SALDO_VIGENTE_CAP")
	private Integer saldoVigenteCap;

	@Column(name = "ATRASO")
	private Integer atraso;

	@Column(name = "DEV_GRACIA")
	private Integer devGracia;

	@Column(name = "TIPO_DSCTO")
	private String tipoDscto;

	@Column(name = "COD_EP")
	private String codEp;

	@Column(name = "COD_CPMP")
	private String codCpmp;
	
	@Column(name = "EC_PTMO")
	private String ecPtmo;

	@Column(name = "REFINANCIA")
	private String refinancia;

	public String getNroChe() {
		return nroChe;
	}

	public void setNroChe(String nroChe) {
		this.nroChe = nroChe;
	}

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getTipoPrest() {
		return tipoPrest;
	}

	public void setTipoPrest(String tipoPrest) {
		this.tipoPrest = tipoPrest;
	}

	public String getAnoEnv() {
		return anoEnv;
	}

	public void setAnoEnv(String anoEnv) {
		this.anoEnv = anoEnv;
	}

	public String getMesEnv() {
		return mesEnv;
	}

	public void setMesEnv(String mesEnv) {
		this.mesEnv = mesEnv;
	}

	public Integer getImpSol() {
		return impSol;
	}

	public void setImpSol(Integer impSol) {
		this.impSol = impSol;
	}

	public Integer getDeudaTotIni() {
		return deudaTotIni;
	}

	public void setDeudaTotIni(Integer deudaTotIni) {
		this.deudaTotIni = deudaTotIni;
	}

	public Date getFecAprob() {
		return fecAprob;
	}

	public void setFecAprob(Date fecAprob) {
		this.fecAprob = fecAprob;
	}

	public Integer getImpDesmbls() {
		return impDesmbls;
	}

	public void setImpDesmbls(Integer impDesmbls) {
		this.impDesmbls = impDesmbls;
	}

	public Integer getNroCuo() {
		return nroCuo;
	}

	public void setNroCuo(Integer nroCuo) {
		this.nroCuo = nroCuo;
	}

	public Double getCuoMen() {
		return cuoMen;
	}

	public void setCuoMen(Double cuoMen) {
		this.cuoMen = cuoMen;
	}

	public Double getCuoCap() {
		return cuoCap;
	}

	public void setCuoCap(Double cuoCap) {
		this.cuoCap = cuoCap;
	}

	public Double getIntereses() {
		return intereses;
	}

	public void setIntereses(Double intereses) {
		this.intereses = intereses;
	}

	public Integer getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Integer saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Integer getSaldoSint() {
		return saldoSint;
	}

	public void setSaldoSint(Integer saldoSint) {
		this.saldoSint = saldoSint;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getSaldoVigente() {
		return saldoVigente;
	}

	public void setSaldoVigente(Integer saldoVigente) {
		this.saldoVigente = saldoVigente;
	}

	public Integer getSaldoVigenteCap() {
		return saldoVigenteCap;
	}

	public void setSaldoVigenteCap(Integer saldoVigenteCap) {
		this.saldoVigenteCap = saldoVigenteCap;
	}

	public Integer getAtraso() {
		return atraso;
	}

	public void setAtraso(Integer atraso) {
		this.atraso = atraso;
	}

	public Integer getDevGracia() {
		return devGracia;
	}

	public void setDevGracia(Integer devGracia) {
		this.devGracia = devGracia;
	}

	public String getTipoDscto() {
		return tipoDscto;
	}

	public void setTipoDscto(String tipoDscto) {
		this.tipoDscto = tipoDscto;
	}

	public String getCodEp() {
		return codEp;
	}

	public void setCodEp(String codEp) {
		this.codEp = codEp;
	}

	public String getCodCpmp() {
		return codCpmp;
	}

	public void setCodCpmp(String codCpmp) {
		this.codCpmp = codCpmp;
	}

	public String getRefinancia() {
		return refinancia;
	}

	public void setRefinancia(String refinancia) {
		this.refinancia = refinancia;
	}

}
