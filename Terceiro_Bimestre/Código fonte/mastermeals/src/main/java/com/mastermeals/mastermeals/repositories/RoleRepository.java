package com.mastermeals.mastermeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastermeals.mastermeals.models.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r WHERE r.nome = ?1")
	public Role findByNome(String nome);
}
