package br.ufrpe.fastFood.exceptions;

public class OJEException extends Exception{

	private String idObjtjaexistente;
	
	public OJEException(String idObjtjaexistente)
	{
		super("Objeto ja existe");
		this.idObjtjaexistente = idObjtjaexistente;
		
	}
	
	public String getId()
	{
		return this.idObjtjaexistente;
	}
	
	public void setId(String id)
	{
		this.idObjtjaexistente = id;
	}
	
}
