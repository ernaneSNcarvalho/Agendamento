package com.agendamento.Agendamento.enums;

public enum DiaSemana {
    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA,
    SABADO,
    DOMINGO;

    public static DiaSemana fromString(String dia) {
        switch (dia.toLowerCase()) {
            case "segunda-feira": return SEGUNDA_FEIRA;
            case "terça-feira": return TERCA_FEIRA;
            case "quarta-feira": return QUARTA_FEIRA;
            case "quinta-feira": return QUINTA_FEIRA;
            case "sexta-feira": return SEXTA_FEIRA;
            case "sábado": return SABADO;
            case "domingo": return DOMINGO;
            default: throw new IllegalArgumentException("Dia inválido: " + dia);
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case SEGUNDA_FEIRA: return "segunda-feira";
            case TERCA_FEIRA: return "terça-feira";
            case QUARTA_FEIRA: return "quarta-feira";
            case QUINTA_FEIRA: return "quinta-feira";
            case SEXTA_FEIRA: return "sexta-feira";
            case SABADO: return "sábado";
            case DOMINGO: return "domingo";
            default: throw new IllegalArgumentException();
        }
    }
}
