package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.beans.Bebida;

public class TesteProduto {
	
	public static void main(String[] args){
	
		RepositorioProdutos repositorio = RepositorioProdutos.getInstancia();
		
	//criando novos produtos do tipo hamburger
		Produto hamburguer1 = new Hamburguer("McDonald", 12.00, "0001H");
		Produto hamburguer2 = new Hamburguer("BurgerGrill", 12.00, "0002H");
		Produto bebida1 = new Bebida("Refrigerante", 5.00, "0001T", "cola");
		Produto bebida2 = new Bebida("Suco", 5.00, "0002T", "maracuja");
	
	
			
	//Adicionando produto
		repositorio.cadastrar(hamburguer1);
		repositorio.cadastrar(hamburguer2);
		repositorio.cadastrar(bebida1);
		repositorio.cadastrar(bebida2);
			
	//Buscando produto
		System.out.println(repositorio.buscarProduto(hamburguer1.getCodigo()));
		System.out.println(repositorio.buscarProduto(bebida1.getCodigo()));
		System.out.println(repositorio.buscarProduto(hamburguer2.getCodigo()));
		System.out.println(repositorio.buscarProduto(bebida2.getCodigo()));
			
	// Removendo Produto
		repositorio.removerProduto(hamburguer1.getCodigo());
		repositorio.removerProduto(bebida1.getCodigo());
		
	//Buscando produtos removidos
		System.out.println( repositorio.buscarProduto(hamburguer1.getCodigo()));
		System.out.println( repositorio.buscarProduto(bebida1.getCodigo()));
		
	//Imprimindo Produtos do repositorio
		
	}
	
	
	
	
	
	
}
