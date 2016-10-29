package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public class PromocaoProduto extends Promocao{
	
	private Produto produto;
	
	public PromocaoProduto(String idPromocao , LocalDate diapromo , Produto p , double valor)
	{
		super(idPromocao , diapromo);
		this.produto = p;
		this.setValor(valor);
	}
	
	public PromocaoProduto()
	{
		super();
	}
	
	
	
}
