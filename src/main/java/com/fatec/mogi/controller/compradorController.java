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
import com.fatec.mogi.model.Comprador;

@RestController
@RequestMapping("/comprador")
public class compradorController {

	@Autowired
	CommandSalvar commandSalvar;
	@Autowired
	CommandBuscar commandBuscar;
	@Autowired
	CommandExcluir commandExcluir;
	@Autowired
	CommandAtualizar commandAtualizar;

	@PostMapping
	public ResponseEntity<EntidadeDominio> save(@RequestBody Comprador comprador) {
		return commandSalvar.execute(comprador);
	}

	@GetMapping
	public ResponseEntity<List<? extends EntidadeDominio>> find(@RequestBody(required = false) Comprador comprador) {
		if (comprador == null) {
			comprador = new Comprador();
		}
		return commandBuscar.execute(comprador);

	}

	@DeleteMapping
	public ResponseEntity<EntidadeDominio> delete(@RequestBody(required = true) Comprador comprador) {
		return commandExcluir.execute(comprador);

	}

	@PutMapping
	public ResponseEntity<EntidadeDominio> update(@RequestBody(required = true) Comprador comprador) {
		return commandAtualizar.execute(comprador);

	}

}
