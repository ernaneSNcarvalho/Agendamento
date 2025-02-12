package com.agendamento.Agendamento.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_datas_bloqueadas")
public class DataBloqueada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_bloqueada", unique = true)
    @NotNull(message = "A data bloqueada é obrigatória.")
    private LocalDate dataBloqueada;

    @Column(name = "motivo")
    private String motivo;

    public DataBloqueada() {}

    public DataBloqueada(Long id, LocalDate dataBloqueada, String motivo) {
        this.id = id;
        this.dataBloqueada = dataBloqueada;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataBloqueada() {
        return dataBloqueada;
    }

    public void setDataBloqueada(LocalDate dataBloqueada) {
        this.dataBloqueada = dataBloqueada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DataBloqueada other = (DataBloqueada) obj;
        return Objects.equals(id, other.id);
    }
}
