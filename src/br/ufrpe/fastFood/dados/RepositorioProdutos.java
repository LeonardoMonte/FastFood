package br.ufrpe.fastFood.dados;

import java.util.ArrayList;

import Teste.Produto;

public class RepositorioProdutos {
	private static RepositorioProdutos instancia;
	private ArrayList <Produto> listaProdutos;
	
	private RepositorioProdutos(){
		this.listaProdutos = new ArrayList <>(); 
	}
	
	public RepositorioProdutos getInstancia(){
		if(instancia == null){
			instancia = new RepositorioProdutos();
		}
		
		return instancia;
	}
	
	public void cadastrar(Produto p){
		if(p != null){ //verifica se o produto é não-nulo
			int cont = 0;
			//Percorre o array para verificar se há
			//algum produto identico na lista
			for (int i = 0; i < this.listaProdutos.size(); i ++){ 
				if(this.listaProdutos.get(i).equals(p))  			
					cont+= 1;
			}//Adiciona produto
			if (cont == 0){ 
				this.listaProdutos.add(p);
			}
			//informa que produto já fora cadastrado
			else{ 		
				System.out.println("Produto já cadastrado!");
			}
			
		}
	}
	
	public void buscarProduto(){
		
	}
	
	

}
