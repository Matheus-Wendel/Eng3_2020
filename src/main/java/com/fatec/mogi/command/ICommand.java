package com.fatec.mogi.command;

import com.fatec.mogi.model.EntidadeDominio;

public interface ICommand {

	public Object execute(EntidadeDominio entidade);
}
