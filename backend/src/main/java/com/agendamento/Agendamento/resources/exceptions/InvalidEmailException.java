package com.agendamento.Agendamento.resources.exceptions;

public class InvalidEmailException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidEmailException(String message) {
        super(message);
    }
}
