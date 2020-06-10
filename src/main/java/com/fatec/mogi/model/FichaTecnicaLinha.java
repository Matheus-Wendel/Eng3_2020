package com.fatec.mogi.model;

import java.util.List;

public class FichaTecnicaLinha extends EntidadeDominio {

	private String descricao;
	private List<Acessorio> acessorios;

	public FichaTecnicaLinha(String nome, String descricao, List<Acessorio> acessorios) {
		super(nome);
		this.descricao = descricao;
		this.acessorios = acessorios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

}
