package cundi.edu.co.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends Exception {

	/**
	 * excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;


	public ModelNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
