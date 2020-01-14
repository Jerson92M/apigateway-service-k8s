package com.facturacion.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;


@ControllerAdvice
public class Exceptions {
	
	final static Logger logger = LogManager.getLogger(Exceptions.class);

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseBody
	public ResponseEntity<Response> httpClientErrorException(HttpClientErrorException e) {
		
		logger.error("Error!",e);
		
		String message = e.getResponseBodyAsString();
		HttpStatus status = e.getStatusCode();
	    
	    return new ResponseEntity<>(new Response(message), status);
	}
	
}
