package com.fatec.mogi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.mogi.model.Comprador;
@Repository
public interface CompradorDAO extends IDAO,JpaRepository<Comprador, Integer>  {

}
