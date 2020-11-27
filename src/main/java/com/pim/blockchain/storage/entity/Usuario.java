package com.pim.blockchain.storage.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.pim.blockchain.storage.enums.TipoUsuarioEnum;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@NotBlank(message="O campo nome é obrigatório")
	@Column(nullable = false, unique = true)
	private String nome;
	
	@NotBlank(message="O cpf/cnpj é obrigatório")
	@Column(nullable = false, unique = true)
	private String documento;
	
    @NotBlank(message="Email é obrigatório")
    @Email(message="Email invalido")
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotBlank(message="Senha é obrigatória")
    @Size(min = 6)
    private String senha;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoUsuarioEnum tipoUsuario;
    
    private boolean ativo;
	private Date ultimoLogin;
    private Date dataCriacao;
    
    public Usuario(	String email, String senha, String nome, String documento) {
    	this(email, senha, TipoUsuarioEnum.ROLE_CLIENTEPF, nome , documento);
	}
    
    public Usuario(	@NotBlank(message = "Email é obrigatório") 
					@Email(message = "Email invalido") String email,
					@NotBlank(message = "Senha é obrigatória") @Size(min = 6) String senha,
					TipoUsuarioEnum tipoUsuario, String nome, String documento) {
    	super();
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.nome = nome;
		this.documento = documento;
	}
    
    public Usuario() {
    	this.dataCriacao = new Date();
    	this.ativo = true;
    }
    
	public int getId() {
		return id;
	}

	public Usuario setId(int id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Usuario setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Usuario setAtivo(boolean ativo) {
		this.ativo = ativo;
		return this;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public Usuario setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
		return this;
	}

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	public Usuario setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
		return this;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Usuario setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
