package com.fatec.mogi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.Linha;
import com.fatec.mogi.repository.LinhaRepository;
@Service
public class LinhaDAO implements IDAO {

	@Autowired
	LinhaRepository linhaRepository;

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		return ResponseEntity.ok().body(linhaRepository.save(linha));
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		linhaRepository.deleteById(linha.getId());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		List<Linha> listaRetorno = new ArrayList<>();

		if (linha.getId() != null) {

			Optional<Linha> findById = linhaRepository.findById(linha.getId());

			if (findById.isPresent()) {
				listaRetorno.add(findById.get());
				return ResponseEntity.ok().body(listaRetorno);
			} else {
				return new ResponseEntity<List<? extends EntidadeDominio>>(listaRetorno, HttpStatus.NOT_FOUND);

			}
		}
		if (linha.getNome() != null) {
			listaRetorno.addAll(linhaRepository.findByNomeContaining(linha.getNome()));
			return ResponseEntity.ok().body(listaRetorno);
		}

		listaRetorno.addAll(linhaRepository.findAll());

		return ResponseEntity.ok().body(listaRetorno);
	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		Linha linha = (Linha) entidadeDominio;
		return ResponseEntity.ok().body(linhaRepository.save(linha));
	}


}
