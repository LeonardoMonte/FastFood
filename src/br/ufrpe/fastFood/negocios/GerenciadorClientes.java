package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.interfaces.RepositorioClienteInterface;

public class GerenciadorClientes {

	private static GerenciadorClientes instancia;
	private RepositorioClienteInterface repositorio;

	public GerenciadorClientes() {
		this.repositorio = RepositorioClientes.getInstancia();
	}

	public static GerenciadorClientes getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorClientes();
		}
		
		return instancia;
	}
	
	
	public void cadastrar(Cliente a) {

			this.repositorio.cadastrarCliente(a);
	
	}

	public boolean remover(String id) {

		return this.repositorio.removerCliente(id);		

	}

	public Cliente procurar(String id) {
		return this.repositorio.buscarCliente(id);  

	}

	public boolean atualizarClienteendereco(String id, Endereco a) {

			return this.repositorio.atualizarClienteendereco(id, a); 
		
	}

	public List<Cliente> listarClientes() {
	
			return this.repositorio.listarClientes(); 

	}

	public boolean loginCliente(String id, String senha) {
		
		return this.repositorio.loginCliente(id, senha); // ultimo
	}

	public boolean alterarSenha(String id, String senhaold, String senhanew) {
		return this.repositorio.alterarsenha(id, senhaold, senhanew);

	}

	public String nomeCliente(String id) {
		return this.repositorio.getNomecliente(id);
	}

	public boolean existeC(String id) {
		return this.repositorio.existeCliente(id);
	}

}
