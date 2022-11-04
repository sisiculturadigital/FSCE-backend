package ep.fsce.seguro.backend.dto.response;

import ep.fsce.seguro.backend.dto.SituFinancieraBean;

public class SaldoPrestamoReponse {
	
	private SituFinancieraBean prestamo;

	public SituFinancieraBean getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(SituFinancieraBean prestamo) {
		this.prestamo = prestamo;
	}

}
