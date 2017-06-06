package com.kdemo.jooq.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		
		String message = ex.getMessage();
		if(message == null) {
			logger.error("", ex);
		}
		else {
			logger.error(message, ex);
		}
		
		return String.format("Oops: %s", message);
	}

}
