package com.fatec.mogi.strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Acessorio;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.FichaTecnicaLinha;
import com.fatec.mogi.repository.AcessorioRepository;
@Service
public class ValidaFichaTecnicaLinha implements IStrategy {

	
	@Autowired
	AcessorioRepository acessorioRepository;
	@Override
	public String processar(EntidadeDominio entidade) {
		FichaTecnicaLinha fichaTecnicaLinha = (FichaTecnicaLinha ) entidade;
		StringBuilder sb = new StringBuilder();
		
		
		
		if(fichaTecnicaLinha.getNome().trim().isEmpty()) {
			sb.append("Nome não pode ser vazio");
		}
		if(fichaTecnicaLinha.getDescricao().trim().isEmpty()) {
			sb.append("Descricao não pode ser vazio");
		}
		List<Acessorio> acessorios = fichaTecnicaLinha.getAcessorios();
		
		for (Acessorio acessorio : acessorios) {
			Optional<Acessorio> findById = acessorioRepository.findById(acessorio.getId());
			if (!findById.isPresent()) {
				sb.append("Acessorio "+acessorio.getId()+" invalido");
			}
		}
		return sb.toString();
	}

}
