package br.ufrpe.fastFood.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vendas{
	
	private String idVenda;
	private ArrayList <Produto> listaProdutos;
	private LocalDateTime dataHoraVenda;
	private double valorTotal;
	private long numVenda = 1;
	
	public Vendas(){
		this.idVenda = "" + this.numVenda;
		this.listaProdutos = new ArrayList<Produto>();
		this.valorTotal = 0;
		this.dataHoraVenda = LocalDateTime.now();
		this.numVenda++;
			
	}
	
	
	
	public LocalDateTime getDataHoraVenda(){
		return this.dataHoraVenda;
	}
	
	public String getIdVenda() {
		return idVenda;
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
	
	public boolean equals(Vendas v){
		boolean resultado = false;
		if (v != null){
			resultado = (this.idVenda.equals(v.idVenda) && 
						this.dataHoraVenda.equals(v.dataHoraVenda) &&
						this.valorTotal == v.valorTotal &&
						this.listaProdutos.equals(v.listaProdutos));
		}
		return resultado;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Venda: " + this.getIdVenda() + "\n");
		buffer.append("Produtos: " + this.listaProdutos.toString()+ "\n");
		buffer.append("Total a pagar: " + this.getValorTotal());
		
		return buffer.toString();				
	}
	
	
	

}
