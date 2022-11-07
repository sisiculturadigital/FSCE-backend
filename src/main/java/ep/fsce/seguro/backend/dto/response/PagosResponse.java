package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.PagoRecibidoBean;

public class PagosResponse {
	private String codAdm;
	private List<PagoRecibidoBean> pagos;

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public List<PagoRecibidoBean> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagoRecibidoBean> pagos) {
		this.pagos = pagos;
	}

}
