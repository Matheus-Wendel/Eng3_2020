package com.fatec.mogi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class FichaTecnicaProduto extends EntidadeDominio {

	private String categoria;
	private String subcategoria;
	private String descricao;
	private String componenteBasico;
	private String componentePrimario;
	private String componenteSecundario;
	private String observacoes;

	@ManyToMany
	private List<Acessorio> acessorios;



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

	public String getComponenteBasico() {
		return componenteBasico;
	}

	public void setComponenteBasico(String componenteBasico) {
		this.componenteBasico = componenteBasico;
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
