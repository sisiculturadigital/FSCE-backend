package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TW_APORTE_FSCEC")
public class AporteFscec implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String codigo;

	@Column(name = "COD_ADM")
	private String codAdm;

	@Column(name = "AA_APA")
	private String aaApa;

	@Column(name = "MM_APA")
	private String mmApa;

	@Column(name = "IMP_APA")
	private Double impApa;

	@Column(name = "IMP_DU037")
	private Double impDu;

	@ManyToOne
	@JoinColumn(name = "TIP_APA")
	private TipoAporte tipApa;

	@Column(name = "IMP_APOLIQ")
	private Double impApoliq;

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

	public String getAaApa() {
		return aaApa;
	}

	public void setAaApa(String aaApa) {
		this.aaApa = aaApa;
	}

	public String getMmApa() {
		return mmApa;
	}

	public void setMmApa(String mmApa) {
		this.mmApa = mmApa;
	}

	public Double getImpApa() {
		return impApa;
	}

	public void setImpApa(Double impApa) {
		this.impApa = impApa;
	}

	public Double getImpDu() {
		return impDu;
	}

	public void setImpDu(Double impDu) {
		this.impDu = impDu;
	}

	public TipoAporte getTipApa() {
		return tipApa;
	}

	public void setTipApa(TipoAporte tipApa) {
		this.tipApa = tipApa;
	}

	public Double getImpApoliq() {
		return impApoliq;
	}

	public void setImpApoliq(Double impApoliq) {
		this.impApoliq = impApoliq;
	}

}
