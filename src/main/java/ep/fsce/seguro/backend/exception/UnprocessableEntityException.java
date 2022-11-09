package ep.fsce.seguro.backend.exception;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;
	private HttpStatus status;

	public UnprocessableEntityException(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
