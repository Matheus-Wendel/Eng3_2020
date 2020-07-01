package com.fatec.mogi.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeDominio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Calendar dthrCadastro;
	
	private String nome;

	public EntidadeDominio(String nome) {
		this.nome = nome;
	}
	public EntidadeDominio() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Calendar getDthrCadastro() {
		return dthrCadastro;
	}

	public void setDthrCadastro(Calendar dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
