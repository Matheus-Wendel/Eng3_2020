package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.mogi.model.FichaTecnicaProduto;

public interface FichaTecnicaProdutoRepository extends JpaRepository<FichaTecnicaProduto, Integer> {

	
	List<FichaTecnicaProduto> findByNomeContaining(String nome);
	
	
}
