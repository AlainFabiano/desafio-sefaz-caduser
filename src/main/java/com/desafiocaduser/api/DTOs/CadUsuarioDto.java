package com.desafiocaduser.api.DTOs;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CadUsuarioDto {


	private String nome;
	private String email;
	private String telefones;

	
	@NotEmpty(message = "Este campo não pode ser vazio.")
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "CadUsuarioDto [nome=" + nome + ", email=" + email + ", telefones=" + telefones + "]";
	}

}
