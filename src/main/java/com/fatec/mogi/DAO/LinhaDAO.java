package com.fatec.mogi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Linha;
import com.fatec.mogi.repository.FichaTecnicaLinhaRepository;
import com.fatec.mogi.repository.LinhaRepository;

@Service
public class LinhaDAO extends AbstractDAO<Linha> {

	@Autowired
	FichaTecnicaLinhaRepository fichaTecnicaLinhaRepository;
	
	LinhaRepository linhaRepository;
	
	@Autowired
	public LinhaDAO(JpaRepository<Linha, Integer> repo) {
		super(repo);
		this.linhaRepository = (LinhaRepository) this.repositorio;
	}

	
	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		//CADASTRANDO A FICHA JUNTO
		if(linha.getFichaTecnica()==null||linha.getFichaTecnica().getId()==null) {
			linha.setFichaTecnica(fichaTecnicaLinhaRepository.save(linha.getFichaTecnica()));
		}
		return super.save(entidadeDominio);
	}
	
	
	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		//CADASTRANDO A FICHA JUNTO
		if(linha.getFichaTecnica().getId()!=null) {
			linha.setFichaTecnica(fichaTecnicaLinhaRepository.save(linha.getFichaTecnica()));
		}
		return super.update(entidadeDominio);
	}
}
