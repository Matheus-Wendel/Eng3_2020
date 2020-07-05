package com.fatec.mogi.strategy;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Produto;

public class ValidaProduto implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		try {
			Produto produto= (Produto) entidade;
			produto.setAtivo(true);
		} catch (Exception e) {
			sb.append(e.getMessage());

		}
		return sb.toString();
	}

}
