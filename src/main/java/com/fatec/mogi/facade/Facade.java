package com.fatec.mogi.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.IDAO;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.strategy.IStrategy;
import com.fatec.mogi.strategy.StrategyUtil;

@Service
public class Facade implements Ifacade {

	private Map<String, IDAO> mapDAO;
	private Map<String, List<IStrategy>> mapStrategy;

	@Autowired
	public Facade(Map<String, IDAO> mapDAO) {
		this.mapDAO = mapDAO;
		StrategyUtil util = new StrategyUtil();

		mapStrategy = util.getStrategies();
		for (String chave : this.mapDAO.keySet()) {
			System.err.println(chave);
		}
	}

	private IDAO getDAO(EntidadeDominio entidade) {
		String nomeDAO = entidade.getClass().getSimpleName();
		nomeDAO = Character.toLowerCase(nomeDAO.charAt(0)) + nomeDAO.substring(1) + "DAO";
		return mapDAO.get(nomeDAO);
	}

	private List<IStrategy> getStrategies(EntidadeDominio entidade) {
		String nomeStrategy = entidade.getClass().getSimpleName().toLowerCase();
		return mapStrategy.get(nomeStrategy);

	};

	private String processarStrategies(List<IStrategy> strategies, EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		for (IStrategy iStrategy : strategies) {
			sb.append(iStrategy.processar(entidade));
		}
		return sb.toString();
	}

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidade) {
		String validacao = processarStrategies(getStrategies(entidade), entidade);
		if (validacao.isBlank()) {
			IDAO daoGenerico = getDAO(entidade);
			return daoGenerico.save(entidade);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
