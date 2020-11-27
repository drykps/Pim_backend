package com.pim.blockchain.storage.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotBlank(message="Nome é obrigatório")
    private String nome;
    private String descricao;
    private boolean ativo;
    private LocalDate dataCriacao;
    
    public Categoria(String nome, String descricao) {
    	this();
    	this.nome = nome;
    	this.descricao = descricao;
    };
    
    public Categoria() {
    	this.ativo = true;
    	this.dataCriacao = LocalDate.now();
    }

	public Categoria(int id) {
		
	}

	public int getId() {
		return id;
	}

	public Categoria setId(int id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Categoria setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Categoria setAtivo(boolean ativo) {
		this.ativo = ativo;
		return this;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public Categoria setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
		return this;
	}
    

}
