package com.example.demo.costumExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.constomExceptions.IdNotFound;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFound.class)
	public String Idnotfound(IdNotFound message) {
		return message.getMessage();
	}
	
}
