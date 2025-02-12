package com.agendamento.Agendamento.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.Agendamento.entities.DataBloqueada;

@Repository
public interface DataBloqueadaRepository extends JpaRepository<DataBloqueada, Long> {
    boolean existsByDataBloqueada(LocalDate dataBloqueada);
}
