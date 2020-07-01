package com.fatec.mogi.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fatec.mogi.model.EntidadeDominio;

public interface Ifacade {
	
	ResponseEntity<EntidadeDominio> save(EntidadeDominio entidade);
	ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidade);
	ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidade);
	ResponseEntity<EntidadeDominio> update(EntidadeDominio entidade);
	

}
