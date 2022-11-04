package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallePagoPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "COD_ADM")
	private String codAdm;

	@Column(name = "AA_CUO")
	private String aaCuo;

	@Column(name = "MM_CUO")
	private String mmCuo;

	@Column(name = "NRO_CHE")
	private String nroChe;

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getAaCuo() {
		return aaCuo;
	}

	public void setAaCuo(String aaCuo) {
		this.aaCuo = aaCuo;
	}

	public String getMmCuo() {
		return mmCuo;
	}

	public void setMmCuo(String mmCuo) {
		this.mmCuo = mmCuo;
	}

	public String getNroChe() {
		return nroChe;
	}

	public void setNroChe(String nroChe) {
		this.nroChe = nroChe;
	}

}
