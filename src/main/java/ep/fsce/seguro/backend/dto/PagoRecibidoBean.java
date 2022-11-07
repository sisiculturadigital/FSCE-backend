package ep.fsce.seguro.backend.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PagoRecibidoBean {
	
	private String concepto;
	private Double importe;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-5:00")
	private Date fechChe;

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Date getFechChe() {
		return fechChe;
	}

	public void setFechChe(Date fechChe) {
		this.fechChe = fechChe;
	}

}
