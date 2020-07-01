package com.fatec.mogi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Produto;
import com.fatec.mogi.repository.ProdutoRepository;
@Service
public class ProdutoDAO implements IDAO {

	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		return ResponseEntity.ok().body(produtoRepository.save(produto));
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		produtoRepository.deleteById(produto.getId());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		List<Produto> listaRetorno = new ArrayList<>();

		if (produto.getId() != null) {

			Optional<Produto> findById = produtoRepository.findById(produto.getId());

			if (findById.isPresent()) {
				listaRetorno.add(findById.get());
				return ResponseEntity.ok().body(listaRetorno);
			} else {
				return new ResponseEntity<List<? extends EntidadeDominio>>(listaRetorno, HttpStatus.NOT_FOUND);

			}
		}
		if (produto.getNome() != null) {
			listaRetorno.addAll(produtoRepository.findByNomeContaining(produto.getNome()));
			return ResponseEntity.ok().body(listaRetorno);
		}

		listaRetorno.addAll(produtoRepository.findAll());

		return ResponseEntity.ok().body(listaRetorno);
	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		return ResponseEntity.ok().body(produtoRepository.save(produto));
	}
}
