package com.fatec.mogi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fatec.mogi.command.CommandAtualizar;
import com.fatec.mogi.command.CommandBuscar;
import com.fatec.mogi.command.CommandExcluir;
import com.fatec.mogi.command.CommandSalvar;
import com.fatec.mogi.model.EntidadeDominio;
@CrossOrigin
public abstract class AbstractController<T extends EntidadeDominio> {

	@Autowired
	CommandSalvar commandSalvar;
	@Autowired
	CommandBuscar commandBuscar;
	@Autowired
	CommandExcluir commandExcluir;
	@Autowired
	CommandAtualizar commandAtualizar;

	@PostMapping
	public ResponseEntity<EntidadeDominio> save(@RequestBody T entidade) {
		return commandSalvar.execute(entidade);
	}

	@GetMapping
	public ResponseEntity<List<? extends EntidadeDominio>> find(@NonNull T entidade) {
		return commandBuscar.execute(entidade);
	}

	@DeleteMapping
	public ResponseEntity<EntidadeDominio> delete(@RequestBody(required = true) T entidade) {
		return commandExcluir.execute(entidade);
	}

	@PutMapping
	public ResponseEntity<EntidadeDominio> update(@RequestBody(required = true) T entidade) {
		return commandAtualizar.execute(entidade);
	}
}
