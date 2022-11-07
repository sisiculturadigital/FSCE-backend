package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TW_PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EC_PTMO")
	private String ecPtmo;

	@Column(name = "DES_PRODUCTO")
	private String desProducto;

	public String getEcPtmo() {
		return ecPtmo;
	}

	public void setEcPtmo(String ecPtmo) {
		this.ecPtmo = ecPtmo;
	}

	public String getDesProducto() {
		return desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

}
