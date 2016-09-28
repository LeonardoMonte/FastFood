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
			
		}
	}
	
	public Produto buscarProduto(String codigo){
		if(codigo !=null){
			Produto p = 
			for(int i = 0; i < listaProdutos.size(); i++){
				if (listaProdutos.get(i).getCodigo().equals(codigo)){
					p = new Produto(listaProdutos.get(i));
				}
			}
		}
		return p;
	}
	
	public void atualizarProduto(){
				
	}
	
	public boolean deletarProduto( Produto p){
		boolean retorno = false;
		
		if(){
			
		}
		return retorno;
		
	}
	

}
