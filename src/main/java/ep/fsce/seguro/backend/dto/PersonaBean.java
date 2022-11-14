package ep.fsce.seguro.backend.dto;

import java.util.Date;

public class PersonaBean {

	private String codAdm;
	private String grado;
	private String dni;
	private String nombreApe;
	private Integer edad;
	private String proceso;
	private Double impRem;
	private Double ingBruto;
	private Double ingLiquido;
	private Date fechIngreso;
	private Integer aaServicio;
	private String situacion;

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreApe() {
		return nombreApe;
	}

	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public Double getIngBruto() {
		return ingBruto;
	}

	public void setIngBruto(Double ingBruto) {
		this.ingBruto = ingBruto;
	}

	public Double getIngLiquido() {
		return ingLiquido;
	}

	public void setIngLiquido(Double ingLiquido) {
		this.ingLiquido = ingLiquido;
	}

	public Date getFechIngreso() {
		return fechIngreso;
	}

	public void setFechIngreso(Date fechIngreso) {
		this.fechIngreso = fechIngreso;
	}

	public Integer getAaServicio() {
		return aaServicio;
	}

	public void setAaServicio(Integer aaServicio) {
		this.aaServicio = aaServicio;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public Double getImpRem() {
		return impRem;
	}

	public void setImpRem(Double impRem) {
		this.impRem = impRem;
	}

}
