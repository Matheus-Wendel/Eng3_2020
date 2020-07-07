package com.fatec.mogi.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.IDAO;
import com.fatec.mogi.log.GeraLog;
import com.fatec.mogi.log.OperacaoEnum;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.strategy.IStrategy;
import com.fatec.mogi.strategy.StrategyUtil;

@Service
public class Facade implements Ifacade {

	private Map<String, IDAO> mapDAO;
	private Map<String, List<IStrategy>> mapStrategy;
	private GeraLog log;

	@Autowired
	public Facade(Map<String, IDAO> mapDAO, GeraLog geralog) {
		this.mapDAO = mapDAO;
		StrategyUtil util = new StrategyUtil();
		this.log = geralog;
		mapStrategy = util.getStrategies();
	}

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidade) {
		String validacao = processarStrategies(getStrategies(entidade), entidade);
		if (validacao.isBlank()) {
			IDAO daoGenerico = getDAO(entidade);
			ResponseEntity<EntidadeDominio> entidadeSalva = daoGenerico.save(entidade);
			log.GerarLog(entidade, OperacaoEnum.SALVAR);
			return entidadeSalva;
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		ResponseEntity<EntidadeDominio> entidadeAtualizada = daoGenerico.update(entidade);
		log.GerarLog(entidade, OperacaoEnum.ATUALIZAR);
		return entidadeAtualizada;
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		ResponseEntity<EntidadeDominio> entidadeDeletada = daoGenerico.delete(entidade);
		log.GerarLog(entidade, OperacaoEnum.EXCLUIR);
		return entidadeDeletada;

	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidade) {
		IDAO daoGenerico = getDAO(entidade);
		return daoGenerico.find(entidade);

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
		if (strategies == null || strategies.isEmpty()) {
			return sb.toString();
		}
		for (IStrategy iStrategy : strategies) {
			sb.append(iStrategy.processar(entidade));
		}
		return sb.toString();
	}
}
