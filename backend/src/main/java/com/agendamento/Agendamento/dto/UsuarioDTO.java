package com.agendamento.Agendamento.dto;

import java.io.Serializable;

import com.agendamento.Agendamento.entities.Usuario;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatorio.")
	private String nome;
	
	@NotBlank(message = "Campo obrigatorio.")
	private String whatsapp;
	
	@NotBlank(message = "Campo obrigatorio.")
	private String endereco;
	
	@NotBlank(message = "Campo obrigatorio.")
	private String email;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.whatsapp = entity.getWhatsapp();
		this.endereco = entity.getEndereco();
		this.email = entity.getEmail();
	}

	public UsuarioDTO(Long id, @NotBlank(message = "Campo obrigatorio.") String nome,
			@NotBlank(message = "Campo obrigatorio.") String whatsapp,
			@NotBlank(message = "Campo obrigatorio.") String endereco,
			@NotBlank(message = "Campo obrigatorio.") String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.whatsapp = whatsapp;
		this.endereco = endereco;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
