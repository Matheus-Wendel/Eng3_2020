package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.FichaTecnicaLinha;
@Service
public class FichaTecnicaLinhaDAO extends AbstractDAO<FichaTecnicaLinha> {
	
	
	
	@Autowired
	public FichaTecnicaLinhaDAO(JpaRepository<FichaTecnicaLinha, Integer> repo) {
		super(repo);
	}

}
