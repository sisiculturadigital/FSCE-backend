package ep.fsce.seguro.backend.dto;

public class SolicitudDs {

	private String vCodAdm;
	private String tipoBanco;
	private String nroCuenta;
	private String nroCii;
	private String nroContacto;
	private String correo;
	private String departamento;
	private String provincia;
	private String distrito;
	private String direccion;

	public String getTipoBanco() {
		return tipoBanco;
	}

	public void setTipoBanco(String tipoBanco) {
		this.tipoBanco = tipoBanco;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNroCii() {
		return nroCii;
	}

	public void setNroCii(String nroCii) {
		this.nroCii = nroCii;
	}

	public String getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(String nroContacto) {
		this.nroContacto = nroContacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getvCodAdm() {
		return vCodAdm;
	}

	public void setvCodAdm(String vCodAdm) {
		this.vCodAdm = vCodAdm;
	}

}
