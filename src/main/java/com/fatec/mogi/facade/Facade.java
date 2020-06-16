package com.fatec.mogi.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.IDAO;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class Facade implements Ifacade {


	private Map<String, IDAO> mapDAO;
	
	
	@Autowired
	public Facade(Map<String, IDAO> mapDAO) {
		this.mapDAO = mapDAO;
		
	

			for (String s : mapDAO.keySet()) {
				System.err.println(s);
			}
		
	}
	
	private IDAO getDAO(EntidadeDominio entidade) {
		return mapDAO.get(entidade.getClass().getSimpleName().toLowerCase() + "DAO");
	}
	
	
	@Override
	public void save(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		daoGenerico.save(entidade);
	}

	@Override
	public void delete(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		daoGenerico.save(entidade);
		
	}

	@Override
	public List<EntidadeDominio> find(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		daoGenerico.save(entidade);
		return null;
	}

	

}
