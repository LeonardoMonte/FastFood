package br.ufrpe.fastFood.beans;

import java.io.Serializable;

public class Admin extends Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2607499251767801515L;
	
	private String nome;
	private String id;
	private String senha;

	public Admin(String nome, String id, String dataDeNascimento, Endereco endere, String senha){
		
		super(nome, id,  dataDeNascimento,  endere, senha);
	}
	
	public Admin(String nome, String id, String senha){
		this.nome = nome;
		this.id = id;
		this.senha = senha;
	}

	public Admin()
	{
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
	

}
