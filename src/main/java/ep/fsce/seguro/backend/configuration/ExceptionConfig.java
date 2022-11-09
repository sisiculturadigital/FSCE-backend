package ep.fsce.seguro.backend.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ep.fsce.seguro.backend.dto.ErrorMessage;
import ep.fsce.seguro.backend.exception.UnprocessableEntityException;

@RestControllerAdvice
public class ExceptionConfig {
	@ExceptionHandler(value = UnprocessableEntityException.class)
	public ResponseEntity<ErrorMessage> unprocessableEntityException(UnprocessableEntityException ex) {
		ErrorMessage error = new ErrorMessage(ex.getCode(), ex.getMessage());
		return new ResponseEntity<>(error, ex.getStatus());

	}

}
