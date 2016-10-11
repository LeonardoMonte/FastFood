package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.dados.RepositorioVendas;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;

public class GerenciadorVendas {

	private RepositorioVendas repositorio;
	private GerenciadorProdutos produtos;
	
	public GerenciadorVendas()
	{
		this.repositorio = RepositorioVendas.getInstancia();

	}
	
	public void cadastrar(Venda a)
	{
		if(a == null)
		{
			throw new ObjectNotFound("Impossivel fazer o cadastro de uma venda sem dados");
		}
		else if(this.repositorio.existeVenda(a.getIdVenda()))
		{
			throw new ObjectFound("Venda já cadastrada no sistema");
		}
		else
		{
			this.repositorio.cadastrarVenda(a);
		}
	}
	
	public void remover(String idVenda)
	{
		Venda a = new Venda();
		a = this.procurar(idVenda);
		
		boolean Final = this.repositorio.removerVenda(a.getIdVenda());
		
		if(Final == false)
		{
			throw new ObjectNotFound("Cliente não cadastrado no sistema");
		}	
		
	}
	
	public Venda procurar(String idVenda)
	{
		return this.repositorio.buscarVenda(idVenda);
		
	}
	
	public void atualizarProduto(Venda a)
	{
		if( a == null)
		{
			throw new ObjectNotFound("Impossivel fazer cadastro de cliente sem dados");
		}
//		else if(this.repositorio.existeVenda(a.getIdVenda()) == false )
//		{
//			throw new ObjectNotFound("Cliente não encontrado no sistema");
//		}
		else
		{
			this.repositorio.atualizarVendas(a);
		}
	}
	
	public List<Venda> listarProdutos()
	{	if(this.repositorio.existeIndiceV(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new ObjectNotFound("Não existe nada a ser listado");
		}
		
	else
		{
		return this.repositorio.listarVendas();
		}
		
	}
}
