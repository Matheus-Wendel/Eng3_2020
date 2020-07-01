package com.fatec.mogi.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fatec.mogi.model.EntidadeDominio;

public interface IDAO {

	public ResponseEntity<EntidadeDominio> save(EntidadeDominio EntidadeDominio);

	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio);
	
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio);
	
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio);
	

}
