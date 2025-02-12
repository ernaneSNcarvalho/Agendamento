package com.agendamento.Agendamento.resources.exceptions;

public class InvalidHorarioException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidHorarioException(String message) {
        super(message);
    }
}
