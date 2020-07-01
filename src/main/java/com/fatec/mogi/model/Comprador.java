package com.fatec.mogi.model;

import javax.persistence.Entity;

@Entity
public class Comprador extends Pessoa {

	private String login;
	private String senha;

	public Comprador(String nome, String login, String senha) {
		super(nome);
		this.login = login;
		this.senha = senha;
	}
	public Comprador() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
