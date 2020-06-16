package com.fatec.mogi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Produto;
@Repository
public interface ProdutoDAO extends IDAO,JpaRepository<Produto, Integer> {

}
