package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioProdutos;

public class TesteProduto {
	
	public static void main(String[] args){
	
		RepositorioProdutos repositorio = RepositorioProdutos.getInstancia();
		
	//criando um novo produto do tipo hamburger
		Produto hamburguer = new Hamburguer("", 12.00, "0001H");
	
	//Imprimindo produto
		System.out.println(hamburguer); 
			
	//Adicionando produto
		repositorio.cadastrar(hamburguer);
			
	//Buscando produto
		System.out.println(repositorio.buscarProduto(hamburguer.getCodigo()));
			
	// Removendo cliente e buscando Cliente que fora removido
		repositorio.removerProduto(hamburguer.getCodigo());
		System.out.println( repositorio.buscarProduto(hamburguer.getCodigo()));
	}
	
	
	
	
	
}
