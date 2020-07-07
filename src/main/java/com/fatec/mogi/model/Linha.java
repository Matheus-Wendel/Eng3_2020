package com.fatec.mogi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Linha extends EntidadeDominio {

	private String descricao;
	@OneToOne
	@JoinColumn(name = "ficha_tecnica_linha_id")
	private FichaTecnicaLinha fichaTecnica;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "linhas")
	@JsonIgnoreProperties("linhas")
	List<Produto> produtos;



	

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
