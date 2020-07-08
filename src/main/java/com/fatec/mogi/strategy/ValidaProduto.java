package com.fatec.mogi.strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.FichaTecnicaProduto;
import com.fatec.mogi.model.Linha;
import com.fatec.mogi.model.Produto;
import com.fatec.mogi.repository.CompradorRepository;
import com.fatec.mogi.repository.FichaTecnicaProdutoRepository;
import com.fatec.mogi.repository.LinhaRepository;
@Service
public class ValidaProduto implements IStrategy {

	@Autowired
	CompradorRepository compradorRepository;

	@Autowired
	FichaTecnicaProdutoRepository fichaTecnicaProdutoRepository;

	@Autowired
	LinhaRepository linhaRepository;

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();

		Produto produto = (Produto) entidade;
		produto.setAtivo(true);
		if (produto.getDataEntrega() == null) {
			sb.append("data de entrega invalida ");
		}
		if (produto.getNome() == null || produto.getNome().trim().isBlank()) {
			sb.append("Nome invalido ");

		}
		if (produto.getQuantidade() <= 0) {
			sb.append("quantidade invalida ");
		}
		if (produto.getValorCompra() <= 0) {
			sb.append("valor de compra invalida ");
		}

		String loginComprador = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Comprador compradorLogado = compradorRepository.findByLogin(loginComprador);
		
		produto.setComprador(compradorLogado);
		
		FichaTecnicaProduto fichaTecnica = produto.getFichaTecnica();
		
		Optional<FichaTecnicaProduto> findByIdFicha = fichaTecnicaProdutoRepository.findById(fichaTecnica.getId());
		if (findByIdFicha.isEmpty()) {
			sb.append("ficha invalida ");
		}
		List<Linha> linhas = produto.getLinhas();
		
		for (Linha linha : linhas) {
			Optional<Linha> findByIdLinha = linhaRepository.findById(linha.getId());
			if (findByIdLinha.isEmpty()) {
				sb.append("linha "+linha.getId()+" invalida ");
			}
		}
		
		return sb.toString();
	}

}
