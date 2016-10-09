package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;

public class GerenciadorClientes {

	private RepositorioClientes repositorio;
	
	public GerenciadorClientes()
	{
		this.repositorio = RepositorioClientes.getInstancia();
	}
	
	public void cadastrar(Cliente a)
	{
		if(a == null)
		{
			throw new ObjectNotFound("Impossivel fazer o cadastro de um cliente sem dados");
		}
		else if(this.repositorio.existeCliente(a.getId()))
		{
			throw new ObjectFound("Cliente já cadastrado no sistema");
		}
		else
		{
			this.repositorio.cadastrarCliente(a);
		}
	}
	
	public void remover(String id)
	{
		Cliente a = this.repositorio.buscarCliente(id);
		boolean Final = this.repositorio.removerCliente(a.getId());
		
		if(Final == false)
		{
			throw new ObjectNotFound("Cliente não cadastrado no sistema");
		}	
		
	}
	
	public Cliente procurar(String id)
	{
		return this.repositorio.buscarCliente(id);
		
	}
	
	public void atualizarCliente(Cliente a)
	{
		if( a == null)
		{
			throw new ObjectNotFound("Impossivel fazer cadastro de cliente sem dados");
		}
		else if(this.repositorio.existeCliente(a.getId()) == false )
		{
			throw new ObjectNotFound("Cliente não encontrado no sistema");
		}
		else
		{
			this.repositorio.atualizarCliente(a);
		}
	}
	
	public List<Cliente> listarClientes()
	{	if(this.repositorio.existeIndice(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new ObjectNotFound("Não existe nada a ser listado");
		}
		
	else
		{
		return this.repositorio.listarClientes();
		}
		
	}
	
	public boolean loginCliente(String id , String senha)
	{
		boolean resultado = this.repositorio.loginCliente(id, senha);
		return resultado;
	}
	
	public boolean alterarSenha(String id, String senha)
	{
		return this.repositorio.alterarsenha(id, senha);
		
	}
	
	public String nomeCliente(String id)
	{
		return this.repositorio.getNomecliente(id);
	}
	
	
}
