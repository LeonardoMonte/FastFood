package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Produto;

public interface RepositorioProdutoInterface {

		// Recebe um produto como argumento e cadastra
		// ele na lista de produtos do repositorio...

		void cadastrarProduto(Produto p);

		// Recebe uma string com o codigo do produto
		// e chama o metodo procuraIndiceP que retorna a posicao
		// do cliente caso esse esteja na lista ou retorna -1
		// caso ele nao exista.

		Produto buscarProduto(String codigo);

		// Recebe uma string e tambem chama o metodo procuraIndiceP
		// e caso seja retornado um valor diferente de -1 ele
		// remove o produto da lista no indice indicado....

		boolean removerProduto(String codigo);

		//
		
		void atualizarProdutos(Produto novoProduto);

		// Lista todos os produtos cadastrados....

		List<Produto> listarProdutos();

		// Metodo que recebe como parametro um codigo e verifica
		// se ja existe um produto com o mesmo codigo...

		boolean existeProduto(String codigo);

		// Metodo que recebe um indice como parametro e retorna
		// verdadeiro caso o indice esteja na lista de produtos...

		boolean existeIndiceP(int ind);

		// Metodo que recebe um codigo como parametro e retorna
		// o indice onde aquele codigo se encontra caso ele
		// exista ou -1 caso controu;

		int procurarIndiceP(String codigo);

}
