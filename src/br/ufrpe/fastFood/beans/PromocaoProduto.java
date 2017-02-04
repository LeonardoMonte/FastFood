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
	
	public String toString(){
	StringBuffer buffer = new StringBuffer();
	buffer.append("Promoçao: "+ this.getIdPromocao() +"\n");
	buffer.append("Produto: " + this.produto.getNome() + "\n");
	buffer.append("Valor" + this.getValor() + "\n");
	buffer.append("Data de criacao: " + this.getDiaPromo() );
			
	return buffer.toString();
}
	
	
}
