package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.Prestamo;

public class SaldoTipoPrestamoResponse {
	private String tipoPrestamo;
	private List<Prestamo> prestamos;

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}
