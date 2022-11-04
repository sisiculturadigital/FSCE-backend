package ep.fsce.seguro.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TW_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, name = "DNI")
	private String dni;

	@Column(unique = true, name = "cod_adm")
	private String codAdm;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "ESTADO")
	private String estado;

	@Column(unique = true, name = "vemail")
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoUsuario tipoUser;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(String codAdm) {
		this.codAdm = codAdm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuario getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUsuario tipoUser) {
		this.tipoUser = tipoUser;
	}

}
