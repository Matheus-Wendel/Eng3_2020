package com.fatec.mogi.strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Acessorio;
import com.fatec.mogi.model.Componente;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.FichaTecnicaProduto;
import com.fatec.mogi.repository.AcessorioRepository;
import com.fatec.mogi.repository.ComponenteRepository;
@Service
public class ValidaFichaTecnicaProduto implements IStrategy {

	@Autowired
	AcessorioRepository acessorioRepository;
	
	@Autowired
	ComponenteRepository componenteRepository;
	@Override
	public String processar(EntidadeDominio entidade) {
		FichaTecnicaProduto fichaTecnicaProduto = (FichaTecnicaProduto) entidade;
		StringBuilder sb = new StringBuilder();
		
		
		
		if(fichaTecnicaProduto.getNome().trim().isBlank()) {
			sb.append("Nome invalido");
		}
		if(fichaTecnicaProduto.getDescricao().trim().isBlank()) {
			sb.append("Descricao invalido");
		}
		if (fichaTecnicaProduto.getCategoria()==null||fichaTecnicaProduto.getCategoria().trim().isBlank()) {
			sb.append("categoria invalida");
		}
		if (fichaTecnicaProduto.getSubcategoria()==null || fichaTecnicaProduto.getSubcategoria().trim().isEmpty()) {
			sb.append("subcategoria invalida");
		}
		
		List<Acessorio> acessorios = fichaTecnicaProduto.getAcessorios();
		
		for (Acessorio acessorio : acessorios) {
			Optional<Acessorio> findById = acessorioRepository.findById(acessorio.getId());
			if (!findById.isPresent()) {
				sb.append("Acessorio "+acessorio.getId()+" invalido");
			}
		}

		Optional<Componente> componente = componenteRepository.findById(fichaTecnicaProduto.getComponenteBasico().getId());
		if (!componente.isPresent()) {
			sb.append("Componente "+fichaTecnicaProduto.getComponenteBasico().getId()+" invalido");
		}
		componente = componenteRepository.findById(fichaTecnicaProduto.getComponentePrimario().getId());
		if (!componente.isPresent()) {
			sb.append("Componente "+fichaTecnicaProduto.getComponentePrimario().getId()+" invalido");
		}
		componente = componenteRepository.findById(fichaTecnicaProduto.getComponenteSecundario().getId());
		if (!componente.isPresent()) {
			sb.append("Componente "+fichaTecnicaProduto.getComponenteSecundario().getId()+" invalido");
		}
		
		return sb.toString();
	}


}
