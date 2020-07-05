package com.fatec.mogi.strategy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;

public class EncriptarSenha implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		try {
			Comprador comprador = (Comprador) entidade;
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			comprador.setSenha(bCryptPasswordEncoder.encode(comprador.getSenha()));

		} catch (Exception e) {
			sb.append(e.getMessage());

		}
		return sb.toString();
	}

}
