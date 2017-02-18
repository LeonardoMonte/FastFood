package br.ufrpe.fastFood.beans;

public class Admin extends Funcionario {
	
	public Admin(String nome, String id, String dataDeNascimento, Endereco endere, String senha){
		
		super(nome, id,  dataDeNascimento,  endere, senha);
	}

	public Admin()
	{
		super();
	}
	

	
	

}
