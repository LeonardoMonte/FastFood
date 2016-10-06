package br.ufrpe.fastFood.beans;

import java.util.ArrayList;

public class Combo extends Produto{
	
	private ArrayList<Produto> itens;
	
	public Combo(String nome, double valor, String codigo){
		super(nome, valor, codigo);
		this.itens = new ArrayList<Produto>();
	}
	
	public void addItens(Produto p){
		if(p != null){
			
			this.itens.add(p);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Produto: " + this.getNome() + "\n");
		buffer.append("Codigo: " + this.getCodigo() + "\n");
		buffer.append("Itens: " + this.itens.toString() + "\n");
		buffer.append("Valor: " + this.getValor() + "\n");
		return buffer.toString();
	}
	
	
	
	
	
	

}
