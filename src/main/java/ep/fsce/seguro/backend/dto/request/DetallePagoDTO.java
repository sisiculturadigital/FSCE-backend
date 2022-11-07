package ep.fsce.seguro.backend.dto.request;

public class DetallePagoDTO {
	
	private String codAdm;
	private String aaCuo;
	private String mmCuo;
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
