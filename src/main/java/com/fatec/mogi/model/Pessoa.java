package com.fatec.mogi.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends EntidadeDominio{

	public Pessoa(String nome) {
		super(nome);
	}
	public Pessoa() {
	}

	
}
