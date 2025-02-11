package com.agendamento.Agendamento.resources.exceptions;

public class InvalidNomeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidNomeException(String message) {
        super(message);
    }
}
