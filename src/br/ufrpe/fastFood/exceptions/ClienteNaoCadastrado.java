package br.ufrpe.fastFood.exceptions;

public class ClienteNaoCadastrado extends Exception{

	private String login;

	public ClienteNaoCadastrado(String id){
		super("Cliente de Login " + id + "não encontrado.");
		this.login = id;
	} 

	public String getLogin(){
		return this.login;
	}
}
