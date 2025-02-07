package com.agendamento.Agendamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agendamento.Agendamento.dto.UsuarioDTO;
import com.agendamento.Agendamento.entities.Usuario;
import com.agendamento.Agendamento.repositories.UsuarioRepository;
import com.agendamento.Agendamento.resources.exceptions.InvalidEmailException;
import com.agendamento.Agendamento.resources.exceptions.InvalidWhatsappException;

import jakarta.persistence.EntityNotFoundException;



@Service
public class UusarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	private static final String REGEX_WHATSAPP = "^\\+55\\s?[1-9]{2}\\s?9?[0-9]{8}$";
	
	private static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	
	@Transactional(readOnly = true)
	public Page<UsuarioDTO> findAllPaged(Pageable pageable){
		Page<Usuario> list = repository.findAll(pageable);
		return list.map(x -> new UsuarioDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new UsuarioDTO(entity);
	}
	
	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UsuarioDTO(entity);
	}
	
	
	private void copyDtoToEntity(UsuarioDTO dto, Usuario entity) {
		validarNumeroWhatsApp(dto.getWhatsapp());
		validarEmail(dto.getEmail());
	    entity.setNome(dto.getNome());
	    entity.setWhatsapp(dto.getWhatsapp());
	    entity.setEndereco(dto.getEndereco());
	    entity.setEmail(dto.getEmail());
	}
	
	 public void validarNumeroWhatsApp(String numeroWhatsApp) {
	        if (numeroWhatsApp == null || !numeroWhatsApp.matches(REGEX_WHATSAPP)) {
	            throw new InvalidWhatsappException("Número de WhatsApp inválido");
	        }
	    }
	 
	 public void validarEmail(String email) {
	        if (email == null || !email.matches(REGEX_EMAIL)) {
	            throw new InvalidEmailException("Email em formato inválido");
	        }
	    }
}
