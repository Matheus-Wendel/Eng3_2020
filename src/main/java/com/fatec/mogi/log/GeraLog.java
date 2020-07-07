package com.fatec.mogi.log;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.repository.CompradorRepository;

@Service
public class GeraLog {
	@Autowired
	private LogRepository logrepository;

	@Autowired
	private CompradorRepository compradorRepository;

	public void GerarLog(EntidadeDominio entidade, OperacaoEnum operacao) {
		Log log = new Log();

		log.setOperacao(operacao);
		// CADASTRO DE COMPRADOR
		// NAO EH FEITO POR NENHUM OUTRO COMPRADOR
		// SALVA COMO O PROPRIO
		if (entidade.getClass() == Comprador.class && operacao == OperacaoEnum.SALVAR) {
			Comprador comprador = (Comprador) entidade;
			log.setComprador(comprador);
		} else {
			log.setComprador(getCompradorLogado());
		}
		log.setEntidade(entidade.getClass().getSimpleName());
		log.setIdEntidade(entidade.getId());
		log.setDataOperacao(new Date());
		logrepository.save(log);

		System.err.println(log.getComprador().getLogin());
	}

	private Comprador getCompradorLogado() {
		String loginComprador = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Comprador compradorLogado = compradorRepository.findByLogin(loginComprador);
		return compradorLogado;
	}

}
