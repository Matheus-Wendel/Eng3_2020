package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Acessorio;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class ValidaAcessorio implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Acessorio acessorio = (Acessorio) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(acessorio.getDescricao().trim().isEmpty()) {
			sb.append("Descricao  não pode ser vazia");
		}
		if(acessorio.getNome().trim().isEmpty()) {
			sb.append("Nome  não pode ser vazio");
		}
		if(acessorio.getQuantidade() <= 0) {
			sb.append("Quantidade invalida não pode ser vazia");
		}
		return sb.toString();
	}

}
