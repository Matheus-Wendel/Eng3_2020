package com.fatec.mogi.model;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public abstract class Pessoa extends EntidadeDominio{

	public Pessoa(String nome) {
		super(nome);
	}

	
}
