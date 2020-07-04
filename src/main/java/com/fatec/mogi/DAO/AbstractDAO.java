package com.fatec.mogi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fatec.mogi.model.EntidadeDominio;

public class AbstractDAO<T extends EntidadeDominio> implements IDAO {

	private JpaRepository<T, Integer> repositorio;

	public AbstractDAO(JpaRepository<T, Integer> repo) {
		this.repositorio = repo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<EntidadeDominio> save(EntidadeDominio entidadeDominio) {
		T entidade = (T) entidadeDominio;
		try {
			T entidadeSalva = repositorio.save(entidade);
			return ResponseEntity.ok().body(entidadeSalva);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<EntidadeDominio> delete(EntidadeDominio entidadeDominio) {
		T entidade = (T) entidadeDominio;
		try {
			if (repositorio.existsById(entidade.getId())) {
				repositorio.deleteById(entidade.getId());
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<List<? extends EntidadeDominio>> find(EntidadeDominio entidadeDominio) {
		T entidade = (T) entidadeDominio;
		List<T> listaRetorno = new ArrayList<>();

		try {
			if (entidade.getId() != null) {

				Optional<T> findById = repositorio.findById(entidade.getId());

				if (findById.isPresent()) {
					listaRetorno.add(findById.get());
					return ResponseEntity.ok().body(listaRetorno);
				} else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

				}
			}

			listaRetorno.addAll(repositorio.findAll());

			return ResponseEntity.ok().body(listaRetorno);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<EntidadeDominio> update(EntidadeDominio entidadeDominio) {
		T entidade = (T) entidadeDominio;
		try {
			T entidadeSalva = repositorio.save(entidade);
			if (repositorio.existsById(entidade.getId())) {
				return ResponseEntity.ok().body(entidadeSalva);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
