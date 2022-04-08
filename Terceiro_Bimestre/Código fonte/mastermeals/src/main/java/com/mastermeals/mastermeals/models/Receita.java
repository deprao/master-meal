package com.mastermeals.mastermeals.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receitas")
public class Receita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String nome;
	
	private String imagem;
	private String tempo_preparo;
	private String porcoes;
	private String modo_preparo;
	private String ingredientes;
	private float avaliacao;
	private float valor;
	
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTempo_preparo() {
		return tempo_preparo;
	}
	public void setTempo_preparo(String tempo_preparo) {
		this.tempo_preparo = tempo_preparo;
	}
	public float getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getModo_preparo() {
		return modo_preparo;
	}
	public void setModo_preparo(String modo_preparo) {
		this.modo_preparo = modo_preparo;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getPorcoes() {
		return porcoes;
	}
	public void setPorcoes(String porcoes) {
		this.porcoes = porcoes;
	}
	
}
