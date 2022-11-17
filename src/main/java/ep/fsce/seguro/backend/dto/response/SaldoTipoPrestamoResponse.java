package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.Prestamo;

public class SaldoTipoPrestamoResponse {
	private String codigoPrestamo;
	private String tipoPrestamo;
	private String impApo;
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

	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public String getImpApo() {
		return impApo;
	}

	public void setImpApo(String impApo) {
		this.impApo = impApo;
	}

}
