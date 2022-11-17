package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tw_persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DNI", unique = true)
	private String dni;

	@Column(name = "COD_ADM", unique = true)
	private String codAdm;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "SITUACION")
	private String situacion;

	@Column(name = "GRADO")
	private String grado;

	@Column(name = "IMP_REM")
	private Double impRem;

	@Column(name = "IMP_LIQ")
	private Double impLiq;

	@Column(name = "EDAD")
	private Integer edad;

	@Column(name = "FEC_NAC")
	private Date fecNac;

	@Column(name = "FECHA_ING")
	private String fechaIng;

	@Column(name = "AA_SERV")
	private Integer aaServ;

	@Column(name = "PROCESO")
	private String proceso;

	@Column(name = "LIQ_AFECTA")
	private Double liqAfecta;

	@Column(name = "BENEFICIO")
	private Double beneficio;

	@Column(name = "EXCESO")
	private Double exceso;

	@Column(name = "EXCEDIDO")
	private String excedido;

	@Column(name = "NRO_APO")
	private String nroApo;

	@Column(name = "IMP_APO")
	private Double impApo;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Double getImpRem() {
		return impRem;
	}

	public void setImpRem(Double impRem) {
		this.impRem = impRem;
	}

	public Double getImpLiq() {
		return impLiq;
	}

	public void setImpLiq(Double impLiq) {
		this.impLiq = impLiq;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(String fechaIng) {
		this.fechaIng = fechaIng;
	}

	public Integer getAaServ() {
		return aaServ;
	}

	public void setAaServ(Integer aaServ) {
		this.aaServ = aaServ;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public Double getLiqAfecta() {
		return liqAfecta;
	}

	public void setLiqAfecta(Double liqAfecta) {
		this.liqAfecta = liqAfecta;
	}

	public Double getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Double beneficio) {
		this.beneficio = beneficio;
	}

	public Double getExceso() {
		return exceso;
	}

	public void setExceso(Double exceso) {
		this.exceso = exceso;
	}

	public String getExcedido() {
		return excedido;
	}

	public void setExcedido(String excedido) {
		this.excedido = excedido;
	}

	public String getNroApo() {
		return nroApo;
	}

	public void setNroApo(String nroApo) {
		this.nroApo = nroApo;
	}

	public Double getImpApo() {
		return impApo;
	}

	public void setImpApo(Double impApo) {
		this.impApo = impApo;
	}

}
