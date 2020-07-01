package com.fatec.mogi.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Produto extends EntidadeDominio {

	private double valorCompra;
	private Calendar dataEntrega;
	private int quantidade;
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name = "comprador_id")
	private Comprador comprador;
	@OneToOne
	@JoinColumn(name = "produto_id")
	private FichaTecnicaProduto fichaTecnica;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "produto_linha",
			joinColumns = @JoinColumn(name ="produto_id"),
			inverseJoinColumns = @JoinColumn(name="linha_id"))
	private List<Linha> linhas;
	
	
	public Produto(String nome, double valorCompra, Calendar dataEntrega, int quantidade, boolean ativo,
			Comprador comprador, FichaTecnicaProduto fichaTecnica, List<Linha> linhas) {
		super(nome);
		this.valorCompra = valorCompra;
		this.dataEntrega = dataEntrega;
		this.quantidade = quantidade;
		this.ativo = ativo;
		this.comprador = comprador;
		this.fichaTecnica = fichaTecnica;
		this.linhas = linhas;
	}

	public Produto() {
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public FichaTecnicaProduto getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnicaProduto fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

}
