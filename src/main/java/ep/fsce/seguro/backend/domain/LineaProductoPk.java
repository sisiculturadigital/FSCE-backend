package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LineaProductoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EC_PTMO")
	private String ecPtmo;

	@Column(name = "DNI")
	private String dni;

	public String getEcPtmo() {
		return ecPtmo;
	}

	public void setEcPtmo(String ecPtmo) {
		this.ecPtmo = ecPtmo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
