package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TW_TIPO_USUARIO")
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(unique = true, name = "des_tipo")
	private String desTipo;

	@OneToMany(mappedBy = "tipoUser")
	@JsonIgnore
	private List<Usuario> usuarios; 
	

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getDesTipo() {
		return desTipo;
	}

	public void setDesTipo(String desTipo) {
		this.desTipo = desTipo;
	}

}
