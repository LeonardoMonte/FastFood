package br.ufrpe.fastFood.beans;

import java.util.ArrayList;

public class Hamburguer extends Produto {

	private ArrayList<String> ingredientes;
	private int qtdeIngredientes;
	
	public Hamburguer(String nome, double valor, String codigo){
		super(nome, valor, codigo);
		this.ingredientes =  new ArrayList <>();
		this.qtdeIngredientes = 0;
	}
	
	public void addIngrediente(String ingrediente){
		if(this.qtdeIngredientes < 11 && ingrediente != null){
			this.ingredientes.add(ingrediente);
		}
	}
	
	public void removerIngredientes(String ingrediente){
		if(this.qtdeIngredientes > 0 && ingrediente != null){
			this.ingredientes.remove(ingrediente);
		}
	}
}
