package br.ufrpe.fastFood.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda{
	
	private String idVenda;
	private LocalDateTime dataHoraVenda;
	private double valorTotal;
	private ArrayList<PromocaoCombo> promocombos;
	private ArrayList<Combo> combos;
	private ArrayList<Produto> produtos;
	private ArrayList<PromocaoProduto> promoprodutos;
	private int contcombo = 0;
	private int contproduto = 0;
	private int contpromocombo = 0;
	private int contpromoproduto = 0;
	
	public Venda(int pegadomain){
		
		this.valorTotal = 0;
		this.dataHoraVenda = LocalDateTime.now();
		if(pegadomain >= 0 && pegadomain < 10)
		{
			this.idVenda = "000" + pegadomain;
		}
		
		else if(pegadomain >= 10 && pegadomain < 100)
		{
			this.idVenda = "00" + pegadomain;
		}
		
		else if(pegadomain >= 100 && pegadomain < 1000)
		{
			this.idVenda = "0" + pegadomain;
		}
		
		else if(pegadomain >= 1000 && pegadomain < 10000)
		{
			this.idVenda = "" + pegadomain;
		}	
			
	}
	
	public Venda()
	{
		
	}
	
	public LocalDateTime getDataHoraVenda(){
		return this.dataHoraVenda;
	}
	
	
	public double getValorTotal(){
		return this.valorTotal;
	}
	
	public String getIdVenda()
	{
		return this.idVenda;
	}
	
	
	public void setValorTotalAdicionar(double ValorTotal)
	{
		this.valorTotal += ValorTotal;
	}
	
	public void setValorTotalDiminuir(double ValorTotal)
	{
		this.valorTotal -= ValorTotal;
	}
	
	public void setValorTotal(double ValorTotal)
	{
		this.valorTotal = ValorTotal;
	}
	
	
	
	public void comprarCombo(Combo a)
	{
		if(this.contcombo == 0)
		{
			this.combos = new ArrayList<>();
			this.combos.add(a);
			this.setValorTotalAdicionar(a.getValor());
		}
		else
		{
			this.combos.add(a);
			this.setValorTotalAdicionar(a.getValor());
		}
		
		
	}
	
	public void comprarProduto(Produto p)
	{
		if(this.contproduto == 0)
		{
			this.produtos = new ArrayList<>();
			this.produtos.add(p);
			this.setValorTotalAdicionar(p.getValor());
		}
		else
		{
			this.produtos.add(p);
			this.setValorTotalAdicionar(p.getValor());
		}
	}
	
	public void comprarPromoCombo(PromocaoCombo p1)
	{
		if(this.contpromocombo == 0)
		{
			this.promocombos = new ArrayList<>();
			this.promocombos.add(p1);
			this.setValorTotalAdicionar(p1.getValor());
		}
		else
		{
			this.promocombos.add(p1);
			this.setValorTotalAdicionar(p1.getValor());
		}
		
		
	}
	
	public void comprarPromoProduto(PromocaoProduto p2)
	{
		if(this.contpromoproduto == 0)
		{
			this.promoprodutos = new ArrayList<>();
			this.promoprodutos.add(p2);
			this.setValorTotalAdicionar(p2.getValor());
		}
		else
		{
			this.promoprodutos.add(p2);
			this.setValorTotalAdicionar(p2.getValor());
		}
		
	}
	
	public Produto BuscarProduto(String codigo)
	{
		Produto a = new Produto();
		
		for( int x = 0 ; x < produtos.size() ; x++)
		{
			if(this.produtos.get(x).getCodigo().equals(codigo))
			{
				a = this.produtos.get(x);
			}
		}
		
		return a;
		
	}
	
	public Combo BuscarCombo(String codigo)
	{
		Combo a = new Combo();
		
		for( int x = 0 ; x < combos.size() ; x++)
		{
			if(this.combos.get(x).getCodigo().equals(codigo))
			{
				this.setValorTotalDiminuir(a.getValor());
				a = this.combos.get(x);
			}
		}
		
		return a;		
	}
	
	public PromocaoCombo BuscarPromoCombo(String idPromocao)
	{
		PromocaoCombo a = new PromocaoCombo();
		
		for( int x = 0 ; x < this.promocombos.size() ; x++)
		{
			if(this.promocombos.get(x).getIdPromocao().equals(idPromocao))
			{
				a = this.promocombos.get(x);
			}
		}
		
		return a;
		
	}
	
	public PromocaoProduto BuscarPromoProduto(String idPromocao)
	{
		PromocaoProduto a = new PromocaoProduto();
		
		for( int x = 0 ; x < this.promoprodutos.size() ; x++)
		{
			if(this.promoprodutos.get(x).getIdPromocao().equals(idPromocao))
			{
				a = this.promoprodutos.get(x);
			}
		}
		
		return a;
		
	}
	
	public void removerCombo(String codigo)
	{
		Combo a = new Combo();
		a = this.BuscarCombo(codigo);
		
		if( a != null)
		{
			this.setValorTotalDiminuir(a.getValor());
			this.combos.remove(a);
		}
	}
	
	public void removerProduto(String codigo)
	{
		Produto a = new Produto();
		a = this.BuscarProduto(codigo);
		
		if( a != null )
		{
			this.setValorTotalDiminuir(a.getValor());
			this.produtos.remove(a);
		}
	}
	
	public void removerPromoCombo(String idPromocao)
	{
		PromocaoCombo a = new PromocaoCombo();
		a = this.BuscarPromoCombo(idPromocao);
		
		if( a != null )
		{
			this.setValorTotalDiminuir(a.getValor());
			this.promocombos.remove(a);
		}
	}
	
	public void removerPromoProduto(String idPromocao)
	{
		PromocaoProduto a = new PromocaoProduto();
		a = this.BuscarPromoProduto(idPromocao);
		
		if( a != null )
		{
			this.setValorTotalDiminuir(a.getValor());
			this.promoprodutos.remove(a);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public boolean equals(Venda v){
//		boolean resultado = false;
//		if (v != null){
//			resultado = (this.idVenda.equals(v.idVenda) && 
//						this.dataHoraVenda.equals(v.dataHoraVenda) &&
//						this.valorTotal == v.valorTotal);
//		}
//		return resultado;
//	}
	
//	public String toString(){
//		StringBuffer buffer = new StringBuffer();
//		
//		buffer.append("Venda: " + this.getIdVenda() + "\n");
//		buffer.append("Produtos: " + this.listaProdutos.toString()+ "\n");
//		buffer.append("Total a pagar: " + this.getValorTotal());
//		
//		return buffer.toString();				
//	}
		

	
}
