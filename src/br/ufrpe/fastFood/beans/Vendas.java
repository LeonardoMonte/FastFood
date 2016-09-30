package br.ufrpe.fastFood.beans;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Vendas{
	
	private ArrayList <Produto> listaProdutos;
	private LocalDateTime dataHoraVenda;
	private double valorTotal;
	
	
	public Vendas(){
		this.listaProdutos = new ArrayList<>();
		this.valorTotal = 0;
		this.dataHoraVenda = LocalDateTime.now();
			
	}
	
	public LocalDateTime getDataHoraVenda(){
		return this.dataHoraVenda;
	}
	
	public void addProduto(Produto p){
		if(p != null){
			listaProdutos.add(p);
		}
	}
	
	public double calculaValorTotal(){
		this.valorTotal = 0;
		for (Produto produto : listaProdutos) {
			this.valorTotal += produto.getValor();
		}
		
		return this.valorTotal;
	}
	
	public double getValorTotal(){
		return this.valorTotal;
	}
	
	public String toString(){
		return "Produtos: " + (Produto[]) listaProdutos.toArray(new Produto[listaProdutos.size()]) + "\n"
				+ "Total a pagar: " + this.getValorTotal();
	}
	
	
	

}
