package br.ufrpe.fastFood.exceptions;

public class WPException extends Exception{

	private String senhaerrada;
	
	public WPException(String senhaerrada)
	{
		super("Senha incorreta");
		this.senhaerrada = senhaerrada;
	}
	
	public String getSenhaErrada()
	{
		return this.senhaerrada;
				
	}
	
	public void setSenhaErrada(String senhaerrada)
	{
		this.senhaerrada = senhaerrada;
	}
}
