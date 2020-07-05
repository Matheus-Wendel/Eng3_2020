package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Componente;
@Service
public class ComponenteDAO extends AbstractDAO<Componente> {
	
	
	
	@Autowired
	public ComponenteDAO(JpaRepository<Componente, Integer> repo) {
		super(repo);
	}

}
