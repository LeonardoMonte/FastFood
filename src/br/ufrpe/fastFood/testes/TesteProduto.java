package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.beans.Bebida;

public class TesteProduto {
	
	public static void main(String[] args){
	
		RepositorioProdutos repositorio = RepositorioProdutos.getInstancia();
		
	//criando novos produtos do tipo hamburger
		Produto hamburguer = new Hamburguer("McDonald", 12.00, "0001H");
		Produto hamburguer1 = new Hamburguer("BurgerGrill", 12.00, "0002H");
		Produto bebida = new Bebida("refrigerante", 5.00, "0001T", "cola");
		Produto bebida1 = new Bebida("suco", 5.00, "0002T", "maracuja");
	
	//Imprimindo produtos
		System.out.println(hamburguer); 
		System.out.println(hamburguer1);
		System.out.println(bebida);
		System.out.println(bebida1);
			
	//Adicionando produto
		repositorio.cadastrar(hamburguer);
		repositorio.cadastrar(hamburguer1);
		repositorio.cadastrar(bebida);
		repositorio.cadastrar(bebida1);
			
	//Buscando produto
		System.out.println(repositorio.buscarProduto(hamburguer.getCodigo()));
		System.out.println(repositorio.buscarProduto(bebida.getCodigo()));
		System.out.println(repositorio.buscarProduto(hamburguer1.getCodigo()));
		System.out.println(repositorio.buscarProduto(bebida1.getCodigo()));
			
	// Removendo cliente e buscando Cliente que fora removido
		repositorio.removerProduto(hamburguer.getCodigo());
		repositorio.removerProduto(bebida.getCodigo());
		System.out.println( repositorio.buscarProduto(hamburguer.getCodigo()));
		System.out.println( repositorio.buscarProduto(bebida.getCodigo()));
		
	}
	
	
	
	
	
	
}
