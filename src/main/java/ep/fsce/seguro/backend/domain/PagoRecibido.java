package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FS_PAGO_RECIBIDO")
public class PagoRecibido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String codigo;

	@Column(name = "COD_ADM")
	private String codAdm;

	@Column(name = "CONCEPTO")
	private String concepto;

	@Column(name = "IMPORTE")
	private Double importe;

	@Column(name = "FEC_CHE")
	private Date fecChe;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

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

	public Date getFecChe() {
		return fecChe;
	}

	public void setFecChe(Date fecChe) {
		this.fecChe = fecChe;
	}

}
