package com.desafiocaduser.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.desafiocaduser.api.enums.PerfilUsuario;

@Entity
@Table(name = "usuario")
public class CadUsuario implements Serializable {

	private static final long serialVersionUID = -7392087433525513109L;

	private long id;
	private List<PerfilUsuario> perfilUsuario;
	private String nome;
	private String email;
	private String senha;
	private FoneContado telefones;
	private Date dataCriacao;
	private Date dataAtualizacao;

	public CadUsuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    @Enumerated(EnumType.STRING)
	@OneToOne(mappedBy = "nome", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<PerfilUsuario> getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(List<PerfilUsuario> perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Enumerated(EnumType.STRING)
	@OneToOne(mappedBy = "telefones", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public FoneContado getTelefones() {
		return (FoneContado) telefones;
	}

	public void setTelefones(FoneContado telefones) {
		this.telefones = telefones;
	}

	@Column(name = "data_Craiacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_Atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "CadUsuario [id=" + id + ", perfilUsuario=" + perfilUsuario + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + ", telefones=" + telefones + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
