package com.mastermeals.mastermeals.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastermeals.mastermeals.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByCpf(String cpf);
	
}
