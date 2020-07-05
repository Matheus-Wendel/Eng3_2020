package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Comprador;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {

	List<Comprador> findByNomeContaining(String nome);

	Comprador findByLogin(String login);
}
