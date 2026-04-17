package ru.yanes;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public String hanbleObjectNotFound(ObjectNotFoundException ex) {
		return ex.getMessage();
	}
}
