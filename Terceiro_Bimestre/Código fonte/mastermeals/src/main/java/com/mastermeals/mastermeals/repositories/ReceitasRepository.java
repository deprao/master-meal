package com.mastermeals.mastermeals.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastermeals.mastermeals.models.Receita;

public interface ReceitasRepository extends CrudRepository<Receita, Integer>{
	List<Receita> findByNome(String nome);
}
