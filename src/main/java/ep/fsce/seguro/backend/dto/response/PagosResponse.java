package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.PagoRecibidoBean;

public class PagosResponse {
	private String codAdm;
	private List<PagoRecibidoBean> pagos;
	private List<PagoRecibidoBean> devoluciones;
	private String pagoTotal;
	private String devolucionTotal;
	private String totalTransferido;

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

	public List<PagoRecibidoBean> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(List<PagoRecibidoBean> devoluciones) {
		this.devoluciones = devoluciones;
	}

	public String getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(String pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public String getDevolucionTotal() {
		return devolucionTotal;
	}

	public void setDevolucionTotal(String devolucionTotal) {
		this.devolucionTotal = devolucionTotal;
	}

	public String getTotalTransferido() {
		return totalTransferido;
	}

	public void setTotalTransferido(String totalTransferido) {
		this.totalTransferido = totalTransferido;
	}

}
