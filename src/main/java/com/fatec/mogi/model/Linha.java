package com.fatec.mogi.model;

public class Linha extends EntidadeDominio {

	private String descricao;
	private FichaTecnicaLinha fichaTecnica;

	public Linha(String nome, String descricao, FichaTecnicaLinha fichaTecnica) {
		super(nome);
		this.descricao = descricao;
		this.fichaTecnica = fichaTecnica;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FichaTecnicaLinha getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnicaLinha fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

}
