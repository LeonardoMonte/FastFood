package br.ufrpe.fastFood.beans;

import java.util.ArrayList;

public class Combo {
	

	private ArrayList<Produto> itens;
	private String nome;
	private double valor;
	private String codigo;
	

	public Combo(String nome,  String codigo){
		this.nome = nome;
		this.codigo = codigo;
	}

	
	
	public Combo() {
		// TODO Auto-generated constructor stub
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


	public void setValorAumentar(double valor) {
		this.valor += valor;
	}
	
	public void setValorDiminuir(double valor)
	{
		this.valor -= valor;
	}
	
	public void setValorPromo(double valor)
	{
		this.valor = valor;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void addItens(Produto p){

			this.itens.add(p);

			this.setValorAumentar(p.getValor());
			
	}
	
	public Produto buscarProdutoNoCombo(String codigo)
	{
		Produto p = new Produto();
		
		for(Produto produto: itens)
		{
			if(produto.getCodigo().equals(codigo))
			{
				p = produto;
			}
		}
		
		return p;
	}
	
	public boolean removerProdutoNoCombo(String codigo)
	{
		boolean resultado = false;
		Produto p = new Produto();
		p = this.buscarProdutoNoCombo(codigo);
		
		if ( p != null )
		{
			this.itens.remove(p);
			this.setValorDiminuir(p.getValor());
			resultado = true;
		}
		
		return resultado;
	}
	
	public int procurarIndice(String codigo)
	{
		int cont = -1;
		
		for(int x = 0 ; x < itens.size() ; x++)
		{
			if(this.itens.get(x).getCodigo().equals(codigo))
			{
				cont = x;
			}
		}
		
		return cont;

	}
			
		public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Combo: " + this.getNome() + "\n");
		buffer.append("Codigo: " + this.getCodigo() + "\n");
		buffer.append("Itens: " + this.itens.toString() + "\n");
		buffer.append("Valor: " + this.getValor() + "\n");
		return buffer.toString();
	}
			
	

}
