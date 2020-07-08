package com.fatec.mogi.strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.FichaTecnicaLinha;
import com.fatec.mogi.model.Linha;
import com.fatec.mogi.model.Produto;
import com.fatec.mogi.repository.FichaTecnicaLinhaRepository;
import com.fatec.mogi.repository.ProdutoRepository;
@Service
public class ValidaLinha implements IStrategy {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	FichaTecnicaLinhaRepository fichaTecnicaLinhaRepository;

	@Override
	public String processar(EntidadeDominio entidade) {
		Linha linha = (Linha) entidade;
		StringBuilder sb = new StringBuilder();

		if (linha.getDescricao() == null || linha.getDescricao().trim().isEmpty()) {
			sb.append("Descricao invalida");
		}
		if (linha.getNome() == null || linha.getNome().trim().isEmpty()) {
			sb.append("Nome Invalido");
		}

		List<Produto> produtos = linha.getProdutos();
		if (!(produtos == null) ) {

			for (Produto produto : produtos) {
				Optional<Produto> findById = produtoRepository.findById(produto.getId());
				if (!findById.isPresent()) {
					sb.append("Acessorio " + produto.getId() + " invalido");
				}
			}
		}

		Optional<FichaTecnicaLinha> findByIdFicha = fichaTecnicaLinhaRepository
				.findById(linha.getFichaTecnica().getId());
		if (!findByIdFicha.isPresent()) {
			sb.append("ficha invalida");
		}

		return sb.toString();
	}

}
