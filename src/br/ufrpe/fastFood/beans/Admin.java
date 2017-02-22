package src.br.ufrpe.fastFood.beans;

import java.io.Serializable;

public class Admin extends Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2607499251767801515L;
	
	private String nome;
	private String id;
	private String senha;

	public Admin(String nome, String id, String dataDeNascimento,  String senha , String rua, String bairro, String cidade, String estado, int numero, String telefone){
		
		super(nome, id,  dataDeNascimento,  senha ,  rua, bairro, cidade, estado, numero, telefone);
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
