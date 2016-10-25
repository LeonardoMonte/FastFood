package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public class PromocaoProduto extends Promocao{
	
	private Produto produto;
	
	public PromocaoProduto(String idPromocao , LocalDate diapromo , Produto p)
	{
		super(idPromocao , diapromo);
		this.produto = p;
	}
	
	public PromocaoProduto()
	{
		super();
	}
	
	public void AlterarPreçoProduto(double newprice)
	{
		this.produto.setValor(newprice);
	}
	
}
