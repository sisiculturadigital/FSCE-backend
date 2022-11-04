package ep.fsce.seguro.backend.dto.request;

public class TipoPrestamoDTO {

	private Integer codigo;
	private String description;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
