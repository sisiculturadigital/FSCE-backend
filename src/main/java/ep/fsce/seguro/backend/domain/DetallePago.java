package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_DETALLE_PAGO")
public class DetallePago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@EmbeddedId
	DetallePagoPk detallePagopk;

	@Column(name = "NRO_CUO")
	private Integer nroCuo;

	@Column(name = "IMP_CUO_CAP")
	private Double impCuCap;

	@Column(name = "IMP_PAGO")
	private Double impPago;

	@Column(name = "TIPO_PAGO")
	private String tipoPago;

	@Column(name = "SITUACION")
	private String situacion;

	@Column(name = "IMP_CUO_INT")
	private Double impCuoInt;

	@Column(name = "IMP_CUO")
	private Double impCuo;

	public DetallePagoPk getDetallePagopk() {
		return detallePagopk;
	}

	public void setDetallePagopk(DetallePagoPk detallePagopk) {
		this.detallePagopk = detallePagopk;
	}

	public Integer getNroCuo() {
		return nroCuo;
	}

	public void setNroCuo(Integer nroCuo) {
		this.nroCuo = nroCuo;
	}

	public Double getImpCuCap() {
		return impCuCap;
	}

	public void setImpCuCap(Double impCuCap) {
		this.impCuCap = impCuCap;
	}

	public Double getImpPago() {
		return impPago;
	}

	public void setImpPago(Double impPago) {
		this.impPago = impPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public Double getImpCuoInt() {
		return impCuoInt;
	}

	public void setImpCuoInt(Double impCuoInt) {
		this.impCuoInt = impCuoInt;
	}

	public Double getImpCuo() {
		return impCuo;
	}

	public void setImpCuo(Double impCuo) {
		this.impCuo = impCuo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
