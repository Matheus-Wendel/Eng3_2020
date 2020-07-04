package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Acessorio;
@Service
public class AcessorioDAO extends AbstractDAO<Acessorio> {
	
	
	
	@Autowired
	public AcessorioDAO(JpaRepository<Acessorio, Integer> repo) {
		super(repo);
	}

}
