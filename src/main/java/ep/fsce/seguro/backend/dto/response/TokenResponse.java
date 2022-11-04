package ep.fsce.seguro.backend.dto.response;

import java.io.Serializable;

public class TokenResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String token;

	public TokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
