package com.fatec.mogi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.repository.CompradorRepository;

@Service
public class CompradorDAO implements IDAO {

	@Autowired
	CompradorRepository compradorRepository;

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		Comprador comprador = (Comprador) entidadeDominio;
		return ResponseEntity.ok().body(compradorRepository.save(comprador));
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		compradorRepository.deleteById(entidadeDominio.getId());
		return  ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio) {
		Comprador comprador = (Comprador) entidadeDominio;
		List<Comprador> listaRetorno = new ArrayList<>();

		if (comprador.getId() != null) {

			Optional<Comprador> findById = compradorRepository.findById(comprador.getId());

			if (findById.isPresent()) {
				listaRetorno.add(findById.get());
				return ResponseEntity.ok().body(listaRetorno);
			} else {
				return new ResponseEntity<List<? extends EntidadeDominio>>(listaRetorno, HttpStatus.NOT_FOUND);

			}
		}
		if (comprador.getNome() != null) {
			listaRetorno.addAll(compradorRepository.findByNomeContaining(comprador.getNome()));
			return ResponseEntity.ok().body(listaRetorno);
		}

		listaRetorno.addAll(compradorRepository.findAll());

		return ResponseEntity.ok().body(listaRetorno);

	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		Comprador comprador = (Comprador) entidadeDominio;
		return ResponseEntity.ok().body(compradorRepository.save(comprador));
	}

}
