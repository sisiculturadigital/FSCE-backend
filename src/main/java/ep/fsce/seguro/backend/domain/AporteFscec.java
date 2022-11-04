package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TW_APORTE_FSCEC")
public class AporteFscec implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_ADM")
	private String codAdm;

	@Column(name = "AA_APA")
	private String aaApa;

	@Column(name = "MM_APA")
	private String mmApa;

	@Column(name = "IMP_APA")
	private Integer impApa;

	@Column(name = "IMP_DU037")
	private Integer impDu;

	@Column(name = "TIP_APA")
	private String tipApa;

	@Column(name = "IMP_APOLIQ")
	private Integer impApoliq;

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

	public Integer getImpApa() {
		return impApa;
	}

	public void setImpApa(Integer impApa) {
		this.impApa = impApa;
	}

	public Integer getImpDu() {
		return impDu;
	}

	public void setImpDu(Integer impDu) {
		this.impDu = impDu;
	}

	public String getTipApa() {
		return tipApa;
	}

	public void setTipApa(String tipApa) {
		this.tipApa = tipApa;
	}

	public Integer getImpApoliq() {
		return impApoliq;
	}

	public void setImpApoliq(Integer impApoliq) {
		this.impApoliq = impApoliq;
	}

}
