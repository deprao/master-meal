package com.mastermeals.mastermeals.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 45)
	private String nome;
	
	@ManyToMany
	private List<Usuario> usuarios;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeRole) {
		this.nome = nomeRole;
	}
	
	public Role() { }
	
	public Role(String nome) {
		this.nome = nome;
	}
	
	public Role(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Role(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
	