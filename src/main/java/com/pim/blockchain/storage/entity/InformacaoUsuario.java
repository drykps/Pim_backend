package com.pim.blockchain.storage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InformacaoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private int cpf;
	private String razaoSocial;
	private int cnpj;
	private int telefone;
	private int telefoneCelular;
	private Date dataNascimento;
	@OneToOne(targetEntity = Usuario.class)
	private int idUsuario;
	
	public InformacaoUsuario() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(int telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
