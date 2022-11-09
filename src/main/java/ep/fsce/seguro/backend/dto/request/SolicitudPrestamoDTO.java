package ep.fsce.seguro.backend.dto.request;

public class SolicitudPrestamoDTO {

	private Integer nroCuo;
	private Double impSol;
	private String usuIng;
	private Double liquidez;
	private String dni;
	private String ecPtmo;

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

	public Double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(Double liquidez) {
		this.liquidez = liquidez;
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
