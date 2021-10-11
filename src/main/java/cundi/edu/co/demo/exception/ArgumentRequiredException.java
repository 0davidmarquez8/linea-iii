package cundi.edu.co.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArgumentRequiredException extends Exception {
	/**
	 * excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;


	public ArgumentRequiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
