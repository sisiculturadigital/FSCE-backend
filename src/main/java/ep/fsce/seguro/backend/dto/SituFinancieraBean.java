package ep.fsce.seguro.backend.dto;

import java.util.List;

public class SituFinancieraBean {

	private PersonaBean persona;
	private List<PrestamoInspBean> prestamos;

	public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	public List<PrestamoInspBean> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<PrestamoInspBean> prestamos) {
		this.prestamos = prestamos;
	}

}
