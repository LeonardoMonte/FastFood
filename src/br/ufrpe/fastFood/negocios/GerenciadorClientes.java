package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.exceptions.SemObjetosCadastrados;

public class GerenciadorClientes {

	private RepositorioClientes repositorio;
	
	public GerenciadorClientes()
	{
		this.repositorio = RepositorioClientes.getInstancia();
	}
	
	public void cadastrar(Cliente a)
	{
		if(a != null && this.repositorio.existeCliente(a.getId()))
		{
			this.repositorio.cadastrarCliente(a);
		}
	}
	
	public void remover(String id)
	{
		Cliente a = this.repositorio.buscarCliente(id);
		
		if( a != null )
		{
			this.repositorio.removerCliente(a.getId());
		}
		
	}
	
	public Cliente procurar(String id)
	{
		return this.repositorio.buscarCliente(id);
		
	}
	
	public void atualizarCliente(Cliente a)
	{
		if( a != null && this.repositorio.existeCliente(a.getId()))
		{
			this.repositorio.atualizarCliente(a);
		}
	}
	
	public List<Cliente> listarClientes()
	{	if(this.repositorio.existeIndice(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new SemObjetosCadastrados("Não existe nada a ser listado");
		}
		
	else
		{
		return this.repositorio.listarClientes();
		}
		
	}
		
	
}
