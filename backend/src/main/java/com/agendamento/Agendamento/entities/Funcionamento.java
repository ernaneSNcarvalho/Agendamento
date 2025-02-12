package com.agendamento.Agendamento.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import com.agendamento.Agendamento.enums.DiaSemana;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionamento")
public class Funcionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "dia_semana")
	@NotNull(message = "O dia da semana é obrigatório.")
	private DiaSemana diaSemana;
	
	@Column(name = "hora_abertura", columnDefinition = "TIME")
	@NotNull(message = "A hora de abertura é obrigatória.")
	private LocalTime horaAbertura;

	@Column(name = "hora_fechamento", columnDefinition = "TIME")
	@NotNull(message = "A hora de fechamento é obrigatória.")
	private LocalTime horaFechamento;
	
	@NotNull(message = "O intervalo entre atendimentos é obrigatório.")
	@Min(value = 1, message = "O intervalo deve ser de pelo menos 1 minuto.")
	private Integer intervaloMinutos;
	
	public Funcionamento() {
	}

	public Funcionamento(Long id, DiaSemana  diaSemana, LocalTime horaAbertura, LocalTime horaFechamento,
			Integer intervaloMinutos) {
		super();
		this.id = id;
		this.diaSemana = diaSemana;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.intervaloMinutos = intervaloMinutos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionamento other = (Funcionamento) obj;
		return Objects.equals(id, other.id);
	}
}
