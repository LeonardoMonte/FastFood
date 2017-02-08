package br.ufrpe.fastFood.exceptions;

public class ONFException extends Exception{

	private String idObjeto;
	
	public ONFException(String idObjeto)
	{
		super("Objeto nao encontrado");
		this.idObjeto = idObjeto;
	}
	
	public String getidObjeto()
	{
		return this.idObjeto;
	}
	
	public void setidObjeto(String idObjeto)
	{
		this.idObjeto = idObjeto;
	}
	
	
	
	
}
