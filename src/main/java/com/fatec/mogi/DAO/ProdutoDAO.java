package com.fatec.mogi.DAO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Produto;
import com.fatec.mogi.repository.ProdutoRepository;
@Service
public class ProdutoDAO extends AbstractDAO<Produto> {

	ProdutoRepository  produtoRepository;
	
	@Autowired
	public ProdutoDAO(JpaRepository<Produto, Integer> repo) {
		super(repo);
		produtoRepository = (ProdutoRepository) this.repositorio;
	}

	
	@Override
	@Transactional
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		Produto entidade = (Produto) entidadeDominio;
		try {
			if (repositorio.existsById(entidade.getId())) {
				produtoRepository.inativar(entidade.getId());
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (Exception e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
