package com.fatec.mogi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;

@RestController
@RequestMapping("/comprador")
public class compradorController extends AbstractController<Comprador> {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ResponseEntity<EntidadeDominio> save(@RequestBody Comprador entidade) {
		entidade.setSenha(bCryptPasswordEncoder.encode(entidade.getSenha()));
		return super.save(entidade);
	}
}
