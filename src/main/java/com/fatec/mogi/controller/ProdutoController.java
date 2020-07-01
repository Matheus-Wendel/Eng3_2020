package com.fatec.mogi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mogi.command.CommandAtualizar;
import com.fatec.mogi.command.CommandBuscar;
import com.fatec.mogi.command.CommandExcluir;
import com.fatec.mogi.command.CommandSalvar;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	CommandSalvar commandSalvar;
	@Autowired
	CommandBuscar commandBuscar;
	@Autowired
	CommandExcluir commandExcluir;
	@Autowired
	CommandAtualizar commandAtualizar;

	@PostMapping
	public ResponseEntity<EntidadeDominio> save(@RequestBody Produto produto) {
		return commandSalvar.execute(produto);
	}

	@GetMapping
	public ResponseEntity<List<? extends EntidadeDominio>> find(
			@RequestBody(required = false) Produto produto) {
		if (produto == null) {
			produto = new Produto();
		}
		return commandBuscar.execute(produto);

	}

	@DeleteMapping
	public ResponseEntity<EntidadeDominio> delete(
			@RequestBody(required = true) Produto produto) {
		return commandExcluir.execute(produto);

	}

	@PutMapping
	public ResponseEntity<EntidadeDominio> update(
			@RequestBody(required = true) Produto produto) {
		return commandAtualizar.execute(produto);

	}
}
