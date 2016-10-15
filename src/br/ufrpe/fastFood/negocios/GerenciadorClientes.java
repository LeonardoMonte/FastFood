package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
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
			throw new ObjectFound("Cliente j� cadastrado no sistema");
		}
		else
		{
			this.repositorio.cadastrarCliente(a);
		}
	}
	
	public boolean remover(String id)
	{

		boolean Final = this.repositorio.removerCliente(id);
		
//		if(Final == false)
//		{
//			throw new ObjectNotFound("Cliente n�o cadastrado no sistema");
//		}	
		
		return Final;
		
	}
	
	public Cliente procurar(String id)
	{
		return this.repositorio.buscarCliente(id);
		
	}
	
	public boolean atualizarClienteendereco(String id , Endereco a)
	{
		boolean resultado = false;
		if( a == null)
		{
			throw new ObjectNotFound("Impossivel fazer cadastro de cliente sem dados");
		}
//		else if(this.repositorio.existeCliente(a.getId()) == false )
//		{
//			throw new ObjectNotFound("Cliente n�o encontrado no sistema");
//		}
		
		else
		{
			resultado = this.repositorio.atualizarClienteendereco(id , a);
		}
		
		return resultado;
	}
	
	public List<Cliente> listarClientes()
	{	if(this.repositorio.existeIndice(0) == false) // TENTATIVA DE EXCEPTION
		{
			throw new ObjectNotFound("N�o existe nada a ser listado");
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
	
	public boolean alterarSenha(String id, String senhaold , String senhanew)
	{
		return this.repositorio.alterarsenha(id, senhaold , senhanew);
		
	}
	
	public String nomeCliente(String id)
	{
		return this.repositorio.getNomecliente(id);
	}
	
	public boolean existeC(String id)
	{
		return this.repositorio.existeCliente(id);
	}
	
	
	
}
