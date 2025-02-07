package com.agendamento.Agendamento.resources.exceptions;

public class InvalidWhatsappException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidWhatsappException(String message) {
        super(message);
    }
}
