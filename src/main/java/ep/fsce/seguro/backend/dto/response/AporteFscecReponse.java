package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.AporteFscecPersona;

public class AporteFscecReponse {

	private String subTotalAportes;
	private String subTotalCuotas;
	private String totalAportes;
	private String totalCuotas;

	private List<AporteFscecPersona> aportes;

	public List<AporteFscecPersona> getAportes() {
		return aportes;
	}

	public void setAportes(List<AporteFscecPersona> aportes) {
		this.aportes = aportes;
	}

	public String getSubTotalAportes() {
		return subTotalAportes;
	}

	public void setSubTotalAportes(String subTotalAportes) {
		this.subTotalAportes = subTotalAportes;
	}

	public String getSubTotalCuotas() {
		return subTotalCuotas;
	}

	public void setSubTotalCuotas(String subTotalCuotas) {
		this.subTotalCuotas = subTotalCuotas;
	}

	public String getTotalAportes() {
		return totalAportes;
	}

	public void setTotalAportes(String totalAportes) {
		this.totalAportes = totalAportes;
	}

	public String getTotalCuotas() {
		return totalCuotas;
	}

	public void setTotalCuotas(String totalCuotas) {
		this.totalCuotas = totalCuotas;
	}

}
