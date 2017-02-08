package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.interfaces.RepositorioProdutoInterface;

public class GerenciadorProdutos {

	private static GerenciadorProdutos instancia;
	private RepositorioProdutoInterface repositorio;

	public GerenciadorProdutos() {
		this.repositorio = RepositorioProdutos.getInstancia();
	}

	public static GerenciadorProdutos getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorProdutos();
		}
		
		return instancia;
	}
	
	public void cadastrar(Produto a) {

			this.repositorio.cadastrarProduto(a);
		
	}

	public void remover(String codigo) throws ONFException {

		this.repositorio.removerProduto(codigo);

	}

	public Produto procurar(String codigo) throws ONFException {
		
		return this.repositorio.buscarProduto(codigo);

	}

	public void atualizarProduto(Double newvalor, String produtoalterado) throws ONFException {
	
		this.repositorio.atualizarProdutos( newvalor, produtoalterado);
		
	}

	public List<Produto> listarProdutos() {
		
		return this.repositorio.listarProdutos();
		
	}
	
	public boolean existeProduto(String codigo)
	{
		return this.repositorio.existeProduto(codigo);
	}
}
