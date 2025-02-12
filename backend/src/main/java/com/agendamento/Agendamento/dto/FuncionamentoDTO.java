package com.agendamento.Agendamento.dto;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

import com.agendamento.Agendamento.entities.Funcionamento;
import com.agendamento.Agendamento.enums.DiaSemana;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FuncionamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	
	@NotNull(message = "O dia da semana é obrigatório.")
	private DiaSemana  diaSemana;
	
	@NotNull(message = "A hora de abertura é obrigatória.")
	private LocalTime horaAbertura;
	
	@NotNull(message = "A hora de fechamento é obrigatória.")
    @FutureOrPresent(message = "A hora de fechamento deve ser válida.")
	private LocalTime horaFechamento;
	
	@NotNull(message = "O intervalo entre atendimentos é obrigatório.")
    @Min(value = 1, message = "O intervalo deve ser de pelo menos 1 minuto.")
	private Integer intervaloMinutos;

	public FuncionamentoDTO() {
	}

	public FuncionamentoDTO(Long id, @NotNull(message = "O dia da semana é obrigatório.") DiaSemana  diaSemana,
			@NotNull(message = "A hora de abertura é obrigatória.") LocalTime horaAbertura,
			@NotNull(message = "A hora de fechamento é obrigatória.") @FutureOrPresent(message = "A hora de fechamento deve ser válida.") LocalTime horaFechamento,
			@NotNull(message = "O intervalo entre atendimentos é obrigatório.") @Min(value = 1, message = "O intervalo deve ser de pelo menos 1 minuto.") Integer intervaloMinutos) {
		super();
		Id = id;
		this.diaSemana = diaSemana;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.intervaloMinutos = intervaloMinutos;
	}
	
	public FuncionamentoDTO(Funcionamento entity) {
		this.Id = entity.getId();
		this.diaSemana = entity.getDiaSemana();
		this.horaAbertura = entity.getHoraAbertura();
		this.horaFechamento = entity.getHoraFechamento();
		this.intervaloMinutos = entity.getIntervaloMinutos();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public DiaSemana  getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana  diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(LocalTime horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public LocalTime getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(LocalTime horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public Integer getIntervaloMinutos() {
		return intervaloMinutos;
	}

	public void setIntervaloMinutos(Integer intervaloMinutos) {
		this.intervaloMinutos = intervaloMinutos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
