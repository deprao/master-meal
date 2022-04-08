package com.mastermeals.mastermeals.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastermeals.mastermeals.models.Receita;

public interface ReceitaRepository extends CrudRepository<Receita, Integer>{
	Receita findByNome(String nome);
}
