package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Produto;
@Service
public class ProdutoDAO extends AbstractDAO<Produto> {

	@Autowired
	public ProdutoDAO(JpaRepository<Produto, Integer> repo) {
		super(repo);
	}

	
}
