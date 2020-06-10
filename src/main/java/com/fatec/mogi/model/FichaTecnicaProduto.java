package com.fatec.mogi.model;

import java.util.List;

public class FichaTecnicaProduto extends EntidadeDominio {

	private String categoria;
	private String subcategoria;
	private String descricao;
	private String componeteBasico;
	private String componentePrimario;
	private String componenteSecundario;
	private String observacoes;

	private List<Acessorio> acessorios;
	
	

	public FichaTecnicaProduto(String nome, String categoria, String subcategoria, String descricao,
			String componeteBasico, String componentePrimario, String componenteSecundario, String observacoes,
			List<Acessorio> acessorios) {
		super(nome);
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.descricao = descricao;
		this.componeteBasico = componeteBasico;
		this.componentePrimario = componentePrimario;
		this.componenteSecundario = componenteSecundario;
		this.observacoes = observacoes;
		this.acessorios = acessorios;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComponeteBasico() {
		return componeteBasico;
	}

	public void setComponeteBasico(String componeteBasico) {
		this.componeteBasico = componeteBasico;
	}

	public String getComponentePrimario() {
		return componentePrimario;
	}

	public void setComponentePrimario(String componentePrimario) {
		this.componentePrimario = componentePrimario;
	}

	public String getComponenteSecundario() {
		return componenteSecundario;
	}

	public void setComponenteSecundario(String componenteSecundario) {
		this.componenteSecundario = componenteSecundario;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

}
