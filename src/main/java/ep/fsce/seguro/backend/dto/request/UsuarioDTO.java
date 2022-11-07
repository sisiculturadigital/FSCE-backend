package ep.fsce.seguro.backend.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioDTO {

	private String email;
	private String password;
	private String nombres;
	private String apellidos;
	private String dni;
	private String codAdm;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-5:00")
	private Date fechaNac;
	private String codRole;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCodRole() {
		return codRole;
	}

	public void setCodRole(String codRole) {
		this.codRole = codRole;
	}

}
