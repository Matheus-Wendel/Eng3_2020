package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.FichaTecnicaProduto;
@Service
public class FichaTecnicaProdutoDAO extends AbstractDAO<FichaTecnicaProduto>{

	@Autowired
	public FichaTecnicaProdutoDAO(JpaRepository<FichaTecnicaProduto, Integer> repo) {
		super(repo);
	}
	
}
