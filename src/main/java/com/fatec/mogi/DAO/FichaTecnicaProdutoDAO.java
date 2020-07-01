package com.fatec.mogi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.EntidadeDominio;
import com.fatec.mogi.model.FichaTecnicaProduto;
import com.fatec.mogi.repository.FichaTecnicaProdutoRepository;
@Service
public class FichaTecnicaProdutoDAO implements IDAO {
	@Autowired
	FichaTecnicaProdutoRepository fichaTecnicaRepository;

	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		FichaTecnicaProduto fichaTecnicaProduto = (FichaTecnicaProduto) entidadeDominio;
		return ResponseEntity.ok().body(fichaTecnicaRepository.save(fichaTecnicaProduto));
	}

	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		FichaTecnicaProduto fichaTecnicaProduto = (FichaTecnicaProduto) entidadeDominio;
		fichaTecnicaRepository.deleteById(fichaTecnicaProduto.getId());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio) {
		FichaTecnicaProduto fichaTecnicaProduto = (FichaTecnicaProduto) entidadeDominio;
		List<FichaTecnicaProduto> listaRetorno = new ArrayList<>();

		if (fichaTecnicaProduto.getId() != null) {

			Optional<FichaTecnicaProduto> findById = fichaTecnicaRepository.findById(fichaTecnicaProduto.getId());

			if (findById.isPresent()) {
				listaRetorno.add(findById.get());
				return ResponseEntity.ok().body(listaRetorno);
			} else {
				return new ResponseEntity<List<? extends EntidadeDominio>>(listaRetorno, HttpStatus.NOT_FOUND);

			}
		}
		if (fichaTecnicaProduto.getNome() != null) {
			listaRetorno.addAll(fichaTecnicaRepository.findByNomeContaining(fichaTecnicaProduto.getNome()));
			return ResponseEntity.ok().body(listaRetorno);
		}

		listaRetorno.addAll(fichaTecnicaRepository.findAll());

		return ResponseEntity.ok().body(listaRetorno);
	}

	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		FichaTecnicaProduto fichaTecnicaProduto = (FichaTecnicaProduto) entidadeDominio;
		fichaTecnicaRepository.save(fichaTecnicaProduto);
		return ResponseEntity.ok().build();
	}

}
