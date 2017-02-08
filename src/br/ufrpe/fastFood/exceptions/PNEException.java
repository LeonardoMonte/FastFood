package br.ufrpe.fastFood.exceptions;

public class PNEException extends Exception {

	private String idProduto;
	
	public PNEException(String idProduto)
	{
		super("Produto nao encontrado no combo");
		this.idProduto = idProduto;
	}
	
	public String getidObjeto()
	{
		return this.idProduto;
	}
	
	public void setidObjeto(String idObjeto)
	{
		this.idProduto = idObjeto;
	}
}
