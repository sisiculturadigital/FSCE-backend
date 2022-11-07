package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TW_LINEA_PRODUCTO")
public class LineaProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@EmbeddedId
	private LineaProductoPk lineaProductoPk;

	@Column(name = "IMPORTE")
	private Double importe;

	public LineaProductoPk getLineaProductoPk() {
		return lineaProductoPk;
	}

	public void setLineaProductoPk(LineaProductoPk lineaProductoPk) {
		this.lineaProductoPk = lineaProductoPk;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

}
