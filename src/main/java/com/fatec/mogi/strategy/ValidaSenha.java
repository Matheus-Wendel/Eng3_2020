package com.fatec.mogi.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;

public class ValidaSenha implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		try {
			Comprador comprador = (Comprador) entidade;
			
			  Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
			  
		      Matcher matcher = pattern.matcher(comprador.getSenha());
		 
		      if (matcher.matches()) {
		    	  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		    	  comprador.setSenha(bCryptPasswordEncoder.encode(comprador.getSenha()));
		    	  return sb.toString();
		      } else {
		    	  sb.append("Senha invalida");
		      }

		} catch (Exception e) {
			sb.append(e.getMessage());

		}
		return sb.toString();
	}

}
