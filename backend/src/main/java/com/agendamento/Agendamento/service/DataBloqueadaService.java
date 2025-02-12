package com.agendamento.Agendamento.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agendamento.Agendamento.entities.DataBloqueada;
import com.agendamento.Agendamento.repositories.DataBloqueadaRepository;
import com.agendamento.Agendamento.resources.exceptions.DatabaseException;
import com.agendamento.Agendamento.resources.exceptions.ResourceNotFoundException;

@Service
public class DataBloqueadaService {

    @Autowired
    private DataBloqueadaRepository repository;

    @Transactional
    public void inserirDataBloqueada(LocalDate data, String motivo) {
        if (repository.existsByDataBloqueada(data)) {
            throw new DatabaseException("Data já bloqueada!");
        }
        DataBloqueada dataBloqueada = new DataBloqueada(null, data, motivo);
        repository.save(dataBloqueada);
    }

    @Transactional(readOnly = true)
    public boolean isDataBloqueada(LocalDate data) {
        return repository.existsByDataBloqueada(data);
    }

    @Transactional(readOnly = true)
    public List<DataBloqueada> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Data bloqueada não encontrada!");
        }
        repository.deleteById(id);
    }
}
