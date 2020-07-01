package com.fatec.mogi.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.EntidadeDominio;
@Service
public class CommandAtualizar implements ICommand {
	@Autowired
	Facade fachada;

	@Override
	public ResponseEntity<EntidadeDominio> execute(EntidadeDominio entidade) {

		return fachada.update(entidade);
	}

}
