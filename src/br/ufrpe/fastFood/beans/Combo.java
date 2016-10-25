package br.ufrpe.fastFood.beans;

import java.util.ArrayList;

public class Combo {
	
	private String nome;
	private double valor;
	private String codigo;
	private ArrayList<Produto> itens;
	
	public Combo(String nome, String codigo){
		this.nome = nome;
		this.codigo = codigo;
		this.valor = 0;
		this.itens = new ArrayList<Produto>();
	}
	
	public void addItens(Produto p){
		
					
			this.itens.add(p);
			this.valor += p.getValor();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor += valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
		
		public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Produto: " + this.getNome() + "\n");
		buffer.append("Codigo: " + this.getCodigo() + "\n");
		buffer.append("Itens: " + this.itens.toString() + "\n");
		buffer.append("Valor: " + this.getValor() + "\n");
		return buffer.toString();
	}
	
	
	
	
	
	

}
