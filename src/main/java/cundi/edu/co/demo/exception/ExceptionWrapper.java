package cundi.edu.co.demo.exception;

import java.time.LocalTime;
import java.util.List;

public class ExceptionWrapper {
	public LocalTime timestamp;
	public int status;
	public String error;
	public String message;
	public String path;
	public List<String> errors;
	
	public ExceptionWrapper() {
		
	}
	
	public ExceptionWrapper(int status, String error, String message, String path) {
		super();
		this.timestamp = LocalTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public ExceptionWrapper(int status, String error, String message, String path, List<String> errors) {
		super();
		this.timestamp = LocalTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.errors = errors;
	}
	
}
