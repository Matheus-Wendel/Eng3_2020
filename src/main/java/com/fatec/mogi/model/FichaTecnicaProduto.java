package com.fatec.mogi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class FichaTecnicaProduto extends EntidadeDominio {

	private String categoria;
	private String subcategoria;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "componente_basico_id")
	private Componente componenteBasico;
	@ManyToOne
	@JoinColumn(name = "componente_primario_id")
	private Componente componentePrimario;
	@ManyToOne
	@JoinColumn(name = "componente_secundario_id")
	private Componente componenteSecundario;
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

	public Componente getComponenteBasico() {
		return componenteBasico;
	}

	public void setComponenteBasico(Componente componenteBasico) {
		this.componenteBasico = componenteBasico;
	}

	public Componente getComponentePrimario() {
		return componentePrimario;
	}

	public void setComponentePrimario(Componente componentePrimario) {
		this.componentePrimario = componentePrimario;
	}

	public Componente getComponenteSecundario() {
		return componenteSecundario;
	}

	public void setComponenteSecundario(Componente componenteSecundario) {
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
