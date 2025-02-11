package com.agendamento.Agendamento.resources.exceptions;


import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
		
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Rerousce not found");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}
		
		@ExceptionHandler(DatabaseException.class)
		public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.BAD_REQUEST.value());
			err.setError("Rerousce not found");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}
		
		@ExceptionHandler(InvalidWhatsappException.class)
	    public ResponseEntity<StandardError> invalidWhatsapp(InvalidWhatsappException e, HttpServletRequest request) {
	        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // Código 500
	        StandardError err = new StandardError(Instant.now(), status.value(), "Internal Server Error", e.getMessage(), request.getRequestURI());
	        return ResponseEntity.status(status).body(err);
	    }
		
		@ExceptionHandler(InvalidEmailException.class)
	    public ResponseEntity<StandardError> invalidEmail(InvalidEmailException e, HttpServletRequest request) {
	        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // Código 500
	        StandardError err = new StandardError(Instant.now(), status.value(), "Internal Server Error", e.getMessage(), request.getRequestURI());
	        return ResponseEntity.status(status).body(err);
	    }
		
		@ExceptionHandler(InvalidNomeException.class)
	    public ResponseEntity<StandardError> invalidNome(InvalidNomeException e, HttpServletRequest request) {
	        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // Código 500
	        StandardError err = new StandardError(Instant.now(), status.value(), "Internal Server Error", e.getMessage(), request.getRequestURI());
	        return ResponseEntity.status(status).body(err);
	    }
}
