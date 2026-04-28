package ru.yanes;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public String hanbleObjectNotFound(EntityNotFoundException ex) {
		return ex.getMessage();
	}
}
