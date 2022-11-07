package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.AporteFscecPersona;

public class AporteFscecReponse {
	
	private List<AporteFscecPersona> aportes;

	public List<AporteFscecPersona> getAportes() {
		return aportes;
	}

	public void setAportes(List<AporteFscecPersona> aportes) {
		this.aportes = aportes;
	}

}
