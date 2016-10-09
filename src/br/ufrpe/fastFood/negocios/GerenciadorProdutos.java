package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;

public class GerenciadorProdutos {

	private RepositorioProdutos repositorio;
	
	public GerenciadorProdutos()
	{
		this.repositorio = RepositorioProdutos.getInstancia();
	}
	
	public void cadastrar(Produto a)
	{
		if(a == null)
		{
			throw new ObjectNotFound("Impossivel fazer o cadastro de um cliente sem dados");
		}
		else if(this.repositorio.existeProduto(a.getCodigo()))
		{
			throw new ObjectFound("Cliente já cadastrado no sistema");
		}
		else
		{
			this.repositorio.cadastrarProduto(a);
		}
	}
	
	public boolean remover(String codigo)
	{
		
		boolean Final = this.repositorio.removerProduto(codigo);
		
//		if(Final == false)
//		{
//			throw new ObjectNotFound("Produto não cadastrado no sistema");
//		}	
		
		return Final;
		
	}
	
	public Produto procurar(String codigo)
	{
		return this.repositorio.buscarProduto(codigo);
		
	}
	
	public void atualizarProduto(Produto a)
	{
		if( a == null)
		{
			throw new ObjectNotFound("Impossivel fazer cadastro de cliente sem dados");
		}
		else if(this.repositorio.existeProduto(a.getCodigo()) == false )
		{
			throw new ObjectNotFound("Cliente não encontrado no sistema");
		}
		else
		{
			this.repositorio.atualizarProdutos(a);
		}
	}
	
	public List<Produto> listarProdutos()
	{	if(this.repositorio.existeIndiceP(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new ObjectNotFound("Não existe nada a ser listado");
		}
		
	else
		{
		return this.repositorio.listarProdutos();
		}
		
	}
	

	
	
}
