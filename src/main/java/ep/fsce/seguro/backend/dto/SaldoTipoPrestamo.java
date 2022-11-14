package ep.fsce.seguro.backend.dto;

import java.util.List;

import ep.fsce.seguro.backend.dto.response.PrestamoResponse;

public class SaldoTipoPrestamo {
	private String tipoPrestamo;
	private List<PrestamoResponse> prestamos;

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	public List<PrestamoResponse> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<PrestamoResponse> prestamos) {
		this.prestamos = prestamos;
	}

}
