package com.agendamento.Agendamento.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agendamento.Agendamento.dto.FuncionamentoDTO;
import com.agendamento.Agendamento.entities.DataBloqueada;
import com.agendamento.Agendamento.entities.Funcionamento;
import com.agendamento.Agendamento.repositories.DataBloqueadaRepository;
import com.agendamento.Agendamento.repositories.FuncionamentoRepository;
import com.agendamento.Agendamento.resources.exceptions.DatabaseException;
import com.agendamento.Agendamento.resources.exceptions.InvalidHorarioException;
import com.agendamento.Agendamento.resources.exceptions.ResourceNotFoundException;

@Service
public class FuncionamentoService {
	
	@Autowired
	private FuncionamentoRepository repository;
	
	@Autowired
    private DataBloqueadaRepository repositoryData;
	
	@Transactional(readOnly = true)
	public Page<FuncionamentoDTO> findAllPaged(PageRequest pageRequest){
		Page<Funcionamento> list = repository.findAll(pageRequest);
		return list.map(x -> new FuncionamentoDTO(x));
	}
	
	@Transactional(readOnly = true)
	public FuncionamentoDTO findById(Long id) {
		Optional<Funcionamento> obj = repository.findById(id);
		Funcionamento entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new FuncionamentoDTO(entity);
	}
	
	@Transactional
	public FuncionamentoDTO insert(FuncionamentoDTO dto) {
		validarHorarios(dto);
		Funcionamento entity = new Funcionamento();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new FuncionamentoDTO(entity);		
	}
	
	@Transactional
	public FuncionamentoDTO update(Long id, FuncionamentoDTO dto) {
		try {
			Funcionamento entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new FuncionamentoDTO(entity);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found.");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation.");
		}
	}
	
	@Transactional
    public void inserirDataBloqueada(LocalDate data, String motivo) {
        if (repositoryData.existsByDataBloqueada(data)) {
            throw new DatabaseException("Data já bloqueada!");
        }
        DataBloqueada dataBloqueada = new DataBloqueada(null, data, motivo);
        repositoryData.save(dataBloqueada);
    }

    @Transactional(readOnly = true)
    public boolean isDataBloqueada(LocalDate data) {
        return repositoryData.existsByDataBloqueada(data);
    }
	
	private void copyDtoToEntity(FuncionamentoDTO dto, Funcionamento entity) {
		entity.setDiaSemana(dto.getDiaSemana());
		entity.setHoraAbertura(dto.getHoraAbertura());
		entity.setHoraFechamento(dto.getHoraFechamento());
		entity.setIntervaloMinutos(dto.getIntervaloMinutos());
	}
	

private void validarHorarios(FuncionamentoDTO dto) {
    if (dto.getIntervaloMinutos() < 1) {
        throw new InvalidHorarioException("O intervalo deve ser de pelo menos 1 minuto.");
    }
    if (dto.getHoraAbertura() == null || dto.getHoraFechamento() == null) {
        throw new InvalidHorarioException("Horários de abertura e fechamento são obrigatórios.");
    }
    if (!dto.getHoraAbertura().isBefore(dto.getHoraFechamento())) {
        throw new InvalidHorarioException("A hora de abertura deve ser menor que a de fechamento.");
    }
}
}
