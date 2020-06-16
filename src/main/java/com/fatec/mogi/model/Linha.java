package com.fatec.mogi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Linha extends EntidadeDominio {

	private String descricao;
	@OneToOne
	@JoinColumn(name = "linha_id")
	private FichaTecnicaLinha fichaTecnica;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "linhas")

	List<Produto> Produtos;

	public Linha(String nome, String descricao, FichaTecnicaLinha fichaTecnica, List<Produto> produtos) {
		super(nome);
		this.descricao = descricao;
		this.fichaTecnica = fichaTecnica;
		Produtos = produtos;
	}

	public List<Produto> getProdutos() {
		return Produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
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
