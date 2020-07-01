package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Linha;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Integer> {

	List<Linha> findByNomeContaining(String nome);

}
