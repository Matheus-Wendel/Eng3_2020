package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	List<Produto> findByNomeContaining(String nome);
	
	@Modifying(clearAutomatically = true)
	@Query("update Produto e set e.ativo=0 where e.id= :id")
	public void inativar(@Param(value = "id") Integer id); 

}
