package com.agendamento.Agendamento.resources.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVerionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
