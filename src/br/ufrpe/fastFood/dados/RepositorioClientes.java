package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;

public class RepositorioClientes {
	
	private static RepositorioClientes instancia;
	private ArrayList<Cliente> listaClientes;
	
	private RepositorioClientes(){
		
		listaClientes = new ArrayList<>();
	}
	
	public static RepositorioClientes getInstancia(){
		
		if(instancia == null){
			instancia = new RepositorioClientes();
		}
		
		return instancia;
	}
	
	public void cadastrarCliente(Cliente c){
				
			this.listaClientes.add(c);		
			
	}
	
	public Cliente buscarCliente(String id){
	
		Cliente resultado = new Cliente();
				
			int i = this.procurarIndice(id);

			if(i >= 0 )
			{		
				resultado = this.listaClientes.get(i);
			}
		
		return resultado;
	}
	
	public boolean removerCliente(String id){	
		
		boolean rresultado = false;
		Cliente resultado = new Cliente();
		int i = this.procurarIndice(id);
		
		if( i >= 0)
		{
			resultado = this.listaClientes.get(i);	
			this.listaClientes.remove(resultado);
			rresultado = true;
		}	
			
		return rresultado;
	}
	
	
	public void atualizarCliente(Cliente novoCliente){
		
		if(buscarCliente(novoCliente.getId()) != null){
		 
			for(Cliente cliente : listaClientes){
			
				if(cliente.equals(novoCliente)){
					
					cliente = novoCliente;
				}
			}
		}
	}
	
	public List<Cliente> listarClientes(){
			
			return this.listaClientes;
		}
	
	public boolean existeCliente(String id)
	{
		// FUNÇÃO PARA CHECAR SE JA EXISTE UM CLIENTE COM ESSE ID
		
		boolean resultado = false;
		
		for(Cliente cliente: listaClientes)
		{
			if( cliente.getId().equals(id))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean existeIndice(int ind)
	{
		boolean resultado = false;
		
		if( this.listaClientes.get(ind) != null)
		{
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public int procurarIndice(String id)
	{
		// Função que procura indice especifico , enxugando os codigos de remover e adicionar
		
		int cont = -1; 

		for( int x = 0 ; x < this.listaClientes.size() ; x++)
		{
			if( this.listaClientes.get(x).getId().equals(id))
			{
				cont = x;
			}
		}
		return cont;
	}
	
	public boolean loginCliente(String id , String senha)
	{	
		Cliente c = new Cliente();
		c = this.buscarCliente(id);
		boolean resultado = c.equalsSenhaCliente(id, senha);
		return resultado;
	}
	
	public boolean alterarsenha(String id , String senhaold , String senhanew)
	{
		Cliente c = new Cliente();
		c = this.buscarCliente(id);		
		boolean resultado = c.alterarSenha(senhaold, senhanew);
		return resultado;
	}
	
	public String getNomecliente(String id)
	{
		String resultado = "";
		Cliente c = new Cliente();
		c = this.buscarCliente(id);
		
		resultado += c.getNome();
		
		return resultado;
		
	}
}
