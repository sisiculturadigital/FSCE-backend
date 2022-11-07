package ep.fsce.seguro.backend.dto;

public class AporteFscecPersona {

	private String codAdm;
	private String aaApa;
	private String mmApa;
	private Double impApa;
	private Double impDu;
	private String tipoApa;
	private Double impApoLiq;

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getAaApa() {
		return aaApa;
	}

	public void setAaApa(String aaApa) {
		this.aaApa = aaApa;
	}

	public String getMmApa() {
		return mmApa;
	}

	public void setMmApa(String mmApa) {
		this.mmApa = mmApa;
	}

	public Double getImpApa() {
		return impApa;
	}

	public void setImpApa(Double impApa) {
		this.impApa = impApa;
	}

	public Double getImpDu() {
		return impDu;
	}

	public void setImpDu(Double impDu) {
		this.impDu = impDu;
	}

	public String getTipoApa() {
		return tipoApa;
	}

	public void setTipoApa(String tipoApa) {
		this.tipoApa = tipoApa;
	}

	public Double getImpApoLiq() {
		return impApoLiq;
	}

	public void setImpApoLiq(Double impApoLiq) {
		this.impApoLiq = impApoLiq;
	}

}
