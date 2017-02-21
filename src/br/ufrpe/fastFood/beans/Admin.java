package br.ufrpe.fastFood.beans;

import java.io.Serializable;

public class Admin extends Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2607499251767801515L;

	public Admin(String nome, String id, String dataDeNascimento, Endereco endere, String senha){
		
		super(nome, id,  dataDeNascimento,  endere, senha);
	}

	public Admin()
	{
		super();
	}
	

	
	

}
