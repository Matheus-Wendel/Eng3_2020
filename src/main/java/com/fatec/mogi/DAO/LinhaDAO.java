package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Linha;

@Service
public class LinhaDAO extends AbstractDAO<Linha> {

	@Autowired
	public LinhaDAO(JpaRepository<Linha, Integer> repo) {
		super(repo);
	}

}
