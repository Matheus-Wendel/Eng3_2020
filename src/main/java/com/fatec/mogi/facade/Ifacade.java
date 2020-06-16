package com.fatec.mogi.facade;

import java.util.List;

import com.fatec.mogi.model.EntidadeDominio;

public interface Ifacade {
	
	void save(EntidadeDominio entidade);
	void delete(EntidadeDominio entidade);
	List<EntidadeDominio> find(EntidadeDominio entidade);
	

}
