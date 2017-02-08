package br.ufrpe.fastFood.exceptions;

public class ClienteJaExiste extends Exception {

	private String idCliente;

	public ClienteJaExiste(String idCliente){
		super("Cliente já cadastrado no sistema.");
		this.idCliente = idCliente;
	}

	public String getIdCliente(){
		return this.idCliente;
	}
	
	public void setIdCliente(String idCliente)
	{
		this.idCliente = idCliente;
	}

}
