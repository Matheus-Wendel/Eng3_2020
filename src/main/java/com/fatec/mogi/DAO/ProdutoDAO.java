package com.fatec.mogi.DAO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Produto;
import com.fatec.mogi.repository.FichaTecnicaProdutoRepository;
import com.fatec.mogi.repository.ProdutoRepository;
@Service
public class ProdutoDAO extends AbstractDAO<Produto> {

	@Autowired
	FichaTecnicaProdutoRepository fichaTecnicaProdutoRepository;
	
	ProdutoRepository  produtoRepository;
	
	@Autowired
	public ProdutoDAO(JpaRepository<Produto, Integer> repo) {
		super(repo);
		produtoRepository = (ProdutoRepository) this.repositorio;
	}

	
	@Override
	@Transactional
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		try {
			if (repositorio.existsById(produto.getId())) {
				produtoRepository.inativar(produto.getId());
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (Exception e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		
		if(produto.getFichaTecnica().getId()==null) {
			produto.setFichaTecnica(fichaTecnicaProdutoRepository.save(produto.getFichaTecnica()));
		}
		
		return super.save(entidadeDominio);
	}
	
	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		Produto produto = (Produto) entidadeDominio;
		if(produto.getFichaTecnica()!=null&&produto.getFichaTecnica().getId()!=null) {
			produto.setFichaTecnica(fichaTecnicaProdutoRepository.save(produto.getFichaTecnica()));
		}
		produto.setAtivo(true);
		return super.update(entidadeDominio);
	}
}
