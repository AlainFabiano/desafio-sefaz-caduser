package com.desafiocaduser.api.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public abstract class FoneContado implements Serializable {

	
	private static final long serialVersionUID = -4463053119499861885L;

	public FoneContado() {
	}
	
	@Column(name = "ddd", nullable = false)
	private Number ddd;
	
	@Column(name = "numer", nullable = false)
	private String numero;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;

	public Number getDdd() {
		return ddd;
	}
	public void setDdd(Number ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "FoneContado [ddd=" + ddd + ", numero=" + numero + ", tipo=" + tipo + "]";
	}
	
}
