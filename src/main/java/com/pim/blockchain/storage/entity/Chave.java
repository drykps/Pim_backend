package com.pim.blockchain.storage.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Chave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	@NotBlank(message="O nome é obrigatório")
    @Column(nullable = false, unique = true)
    private String nomeChave;
	
	@NotBlank(message="A chave é obrigatória")
    private String valorChave;
    private int idCategoria;
    private LocalDate dataCriacao;

    public Chave() {
    	this.dataCriacao = LocalDate.now();
    }
    
    public Chave(String nomeChave, String valorChave, int idCategoria) {
    	this();
    	this.nomeChave = nomeChave;
    	this.valorChave = valorChave;
    	this.setIdCategoria(idCategoria);
    }

	public int getId() {
		return id;
	}

	public Chave setId(int id) {
		this.id = id;
		return this;
	}

	public String getNomeChave() {
		return nomeChave;
	}

	public Chave setNomeChave(String nomeChave) {
		this.nomeChave = nomeChave;
		return this;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public Chave setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
		return this;
	}

	public String getValorChave() {
		return valorChave;
	}

	public Chave setValorChave(String valorChave) {
		this.valorChave = valorChave;
		return this;
	}

		public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
    
}
