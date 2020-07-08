package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class ValidaComprador implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Comprador comprador = (Comprador) entidade;
		StringBuilder sb = new StringBuilder();
		
		IStrategy validaSenha = new ValidaSenha();
		
		sb.append(validaSenha.processar(entidade));
		
		if(comprador.getNome().trim().isEmpty()) {
			sb.append("Nome não pode ser vazio");
		}
		if(comprador.getLogin().trim().isEmpty()) {
			sb.append("login não pode ser vazio");
		}
		return sb.toString();
	}

}
