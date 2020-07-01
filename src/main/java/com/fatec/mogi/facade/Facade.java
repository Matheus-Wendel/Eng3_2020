package com.fatec.mogi.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.IDAO;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class Facade implements Ifacade {


	private Map<String, IDAO> mapDAO;
	
	
	@Autowired
	public Facade(Map<String, IDAO> mapDAO) {
		this.mapDAO = mapDAO;		
	}
	
	private IDAO getDAO(EntidadeDominio entidade) {
		String nomeDAO = entidade.getClass().getSimpleName();
		nomeDAO = Character.toLowerCase(nomeDAO.charAt(0)) + nomeDAO.substring(1)+"DAO";
		return mapDAO.get(nomeDAO);
	}
	
	
	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		return daoGenerico.save(entidade);
	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		return daoGenerico.update(entidade);
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		return daoGenerico.delete(entidade);
		
	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		return daoGenerico.find(entidade);
		
	}


	

}
