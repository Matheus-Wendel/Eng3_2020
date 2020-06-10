package com.fatec.mogi.model;

import java.util.Calendar;

public abstract class EntidadeDominio {

	private int id;
	private Calendar dthrCadastro;
	private String nome;
	
	

	public EntidadeDominio(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
