package br.ufrpe.fastFood.dados;
import java.util.ArrayList;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Produto;;

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
		if(p != null){ //verifica se o produto � n�o-nulo
			int cont = 0;
			//Percorre o array para verificar se h�
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
		Produto resultado = null;
		int i = 0;
		boolean achou = false;

		if(codigo != null){
			
			while((!achou) && (i < this.listaProdutos.size())) {
				if (this.listaProdutos.get(i).getCodigo().equals(codigo)){
					achou = true;
					
				}else{
					i++;
				}
			}
			
			if(i < this.listaProdutos.size()){
				resultado = this.listaProdutos.get(i);
				
			}
		}
		return resultado;
	}
	
	public void removerProduto(String codigo){
		Produto resultado = null;
		int i = 0;
		boolean achou = false;

		if(codigo != null){
			
			while((!achou) && (i < this.listaProdutos.size())) {
				if (this.listaProdutos.get(i).getCodigo().equals(codigo)){
					achou = true;
					
				}else{
					i++;
				}
			}
			resultado = this.listaProdutos.get(i);

			if(achou == true){
				this.listaProdutos.remove(resultado);
				
			}
		}
	}

	public void atualizarProdutos(Produto novoProduto){
			
			if(buscarProduto(novoProduto.getCodigo()) != null){
				 
				for(Produto produto : listaProdutos){
				
					if(produto.equals(novoProduto)){
						
						produto = novoProduto;
						
					}
				}
			}
		}
}