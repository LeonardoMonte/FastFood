package src.br.ufrpe.fastFood.interfaces;

import java.util.List;

import src.br.ufrpe.fastFood.beans.Produto;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.exceptions.ONFException;

public interface RepositorioProdutoInterface {



		void cadastrarProduto(Produto p) throws OJEException;


		Produto buscarProduto(String codigo) throws ONFException;


		void removerProduto(String codigo) throws ONFException;

		
		void atualizarProdutos(Double newvalor, String codigo) throws ONFException;


		List<Produto> listarProdutos();


		boolean existeProduto(String codigo);


		int procurarIndiceP(String codigo);
		
		void save();

}
