package com.fatec.mogi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Linha;
@Repository
public interface LinhaDAO extends IDAO, JpaRepository<Linha, Integer> {

}
