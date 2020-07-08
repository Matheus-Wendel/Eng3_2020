package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Componente;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class ValidaComponente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Componente componente = (Componente) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(componente.getNome().trim().isEmpty()) {
			sb.append("Nome não pode ser vazio");
		}
		return sb.toString();
	}

}
