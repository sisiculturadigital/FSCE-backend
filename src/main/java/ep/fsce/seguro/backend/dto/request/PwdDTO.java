package ep.fsce.seguro.backend.dto.request;

public class PwdDTO {

	private String email;
	private String newPwd;

	public PwdDTO() {
		super();
	}

	public PwdDTO(String email, String lastPwd, String newPwd) {
		super();
		this.email = email;
		this.newPwd = newPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

}
