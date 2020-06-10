package com.fatec.mogi.model;

public class Acessorio extends EntidadeDominio {
	private String descricao;
	private int quantidade;

	
	
	public Acessorio(String nome, String descricao, int quantidade) {
		super(nome);
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

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
