package com.infy.ExceptionHandle;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String exceptionHandler1(MethodArgumentNotValidException ex) {
		return (String) ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	}
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler2(Exception ex) {
//		return ex.getMessage();
//	}
}
