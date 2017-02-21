package br.ufrpe.fastFood.negocios;



import java.util.List;



import br.ufrpe.fastFood.beans.Cliente;

import br.ufrpe.fastFood.beans.Endereco;

import br.ufrpe.fastFood.dados.RepositorioClientes;

import br.ufrpe.fastFood.exceptions.OJEException;

import br.ufrpe.fastFood.exceptions.ONFException;

import br.ufrpe.fastFood.exceptions.WPException;

import br.ufrpe.fastFood.interfaces.RepositorioClienteInterface;



public class GerenciadorClientes {



	private static GerenciadorClientes instancia;

	private RepositorioClienteInterface repositorio;



	private GerenciadorClientes() {

		this.repositorio = RepositorioClientes.getInstancia();

	}



	public static GerenciadorClientes getInstancia(){

		

		if(instancia == null){

			instancia = new GerenciadorClientes();

		}

		

		return instancia;

	}

	

	

	public void cadastrar(Cliente a) throws OJEException {



			this.repositorio.cadastrarCliente(a);
			this.repositorio.save();

	}



	public void remover(String id) throws ONFException {



		this.repositorio.removerCliente(id);		
		this.repositorio.save();


	}



	public Cliente procurar(String id) throws ONFException {

		return this.repositorio.buscarCliente(id);  



	}



	public void atualizarClienteendereco(String id, Endereco a) throws ONFException {



			this.repositorio.atualizarClienteendereco(id, a);
			this.repositorio.save();

		

	}



	public List<Cliente> listarClientes() {

	

			return this.repositorio.listarClientes(); 



	}



	public boolean loginCliente(String id, String senha) throws ONFException, WPException {

		

		return this.repositorio.loginCliente(id, senha); 

	}



	public void alterarSenha(String id, String senhaold, String senhanew) throws ONFException, WPException {

		

		this.repositorio.alterarsenha(id, senhaold, senhanew);
		this.repositorio.save();



	}



	public String nomeCliente(String id)  {

		return this.repositorio.getNomecliente(id);

	}





}