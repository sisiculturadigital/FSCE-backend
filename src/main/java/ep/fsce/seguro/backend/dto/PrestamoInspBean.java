package ep.fsce.seguro.backend.dto;

import java.util.Date;

public class PrestamoInspBean {

	private String nroChe;
	private Double impSol;
	private Date fecAprob;
	private Integer nroCuo;
	private String tipoPrest;
	private Double saldoActual;
	private Double saldoSint;

	public String getNroChe() {
		return nroChe;
	}

	public void setNroChe(String nroChe) {
		this.nroChe = nroChe;
	}

	public Double getImpSol() {
		return impSol;
	}

	public void setImpSol(Double impSol) {
		this.impSol = impSol;
	}

	public Date getFecAprob() {
		return fecAprob;
	}

	public void setFecAprob(Date fecAprob) {
		this.fecAprob = fecAprob;
	}

	public Integer getNroCuo() {
		return nroCuo;
	}

	public void setNroCuo(Integer nroCuo) {
		this.nroCuo = nroCuo;
	}

	public String getTipoPrest() {
		return tipoPrest;
	}

	public void setTipoPrest(String tipoPrest) {
		this.tipoPrest = tipoPrest;
	}

	public Double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Double getSaldoSint() {
		return saldoSint;
	}

	public void setSaldoSint(Double saldoSint) {
		this.saldoSint = saldoSint;
	}

}
