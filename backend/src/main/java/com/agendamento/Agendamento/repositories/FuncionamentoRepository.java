package com.agendamento.Agendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.Agendamento.entities.Funcionamento;

@Repository
public interface FuncionamentoRepository extends JpaRepository<Funcionamento, Long> {

}
