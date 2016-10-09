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
			throw new ObjectFound("Cliente j� cadastrado no sistema");
		}
		else
		{
			this.repositorio.cadastrarProduto(a);
		}
	}
	
	public void remover(String codigo)
	{
		Produto a = this.repositorio.buscarProduto(codigo);
		boolean Final = this.repositorio.removerProduto(a.getCodigo());
		
		if(Final == false)
		{
			throw new ObjectNotFound("Cliente n�o cadastrado no sistema");
		}	
		
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
			throw new ObjectNotFound("Cliente n�o encontrado no sistema");
		}
		else
		{
			this.repositorio.atualizarProdutos(a);
		}
	}
	
	public List<Produto> listarProdutos()
	{	if(this.repositorio.existeIndiceP(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new ObjectNotFound("N�o existe nada a ser listado");
		}
		
	else
		{
		return this.repositorio.listarProdutos();
		}
		
	}
}
