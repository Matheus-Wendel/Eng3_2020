package com.fatec.mogi.model;

import javax.persistence.Entity;

@Entity
public class Acessorio extends EntidadeDominio {
	private String descricao;
	private int quantidade;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
