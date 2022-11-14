package ep.fsce.seguro.backend.dto;

import java.util.List;

public class AporteAnual {
	private String anio;
	private List<AporteFscecPersona> aporteAnual;

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public List<AporteFscecPersona> getAporteAnual() {
		return aporteAnual;
	}

	public void setAporteAnual(List<AporteFscecPersona> aporteAnual) {
		this.aporteAnual = aporteAnual;
	}

}
