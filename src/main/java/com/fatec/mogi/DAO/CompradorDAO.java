package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;

@Service
public class CompradorDAO extends AbstractDAO<Comprador> {
	
	@Autowired
	public CompradorDAO(JpaRepository<Comprador, Integer> repo) {
		super(repo);
	}

}
