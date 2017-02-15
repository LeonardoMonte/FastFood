package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.interfaces.RepositorioClienteInterface;

public class RepositorioClientes implements RepositorioClienteInterface {
	
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
	
	public void cadastrarCliente(Cliente c) throws OJEException {
		int cont = 0;
		
		for(int x = 0 ; x < this.listaClientes.size() ; x++)
		{
			if(this.listaClientes.get(x).getId().equals(c.getId()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException( c.getId());
		}
		else
		{
			this.listaClientes.add(c);
		}
					
			
	}
	
	public Cliente buscarCliente(String id) throws ONFException{
	
		Cliente resultado = new Cliente();
				
			int i = this.procurarIndice(id);

			if(i >= 0 ){	
				
				resultado = this.listaClientes.get(i);
			}
			else
			{
				throw new ONFException(id);
			}
		
		return resultado;
	}
	
	public void removerCliente(String id) throws ONFException{	
		
		Cliente c = new Cliente();
		c = this.buscarCliente(id);

		if (c.getId() != null) {
			
			this.listaClientes.remove(c);
		}
	}
	
	
	public void atualizarClienteendereco(String id , Endereco ende) throws ONFException{	
		
		Cliente c = new Cliente();
		c = this.buscarCliente(id);
		
		if(c.getId() != null)
		{
			c.setEndere(ende);
		}
	} 
	
	public List<Cliente> listarClientes(){
			
			return this.listaClientes;
		}
	

	
	public int procurarIndice(String id){
				
		int cont = -1; 

		for( int x = 0 ; x < this.listaClientes.size() ; x++){
			
			if( this.listaClientes.get(x).getId().equals(id)){
				
				cont = x;
			}
		}
		return cont;
	}
	
	public boolean loginCliente(String id , String senhanew) throws  ONFException, WPException{	
	
		boolean b = false;
		Cliente c = new Cliente();
		c = this.buscarCliente(id);		
		if(c.getId() != null)
		{

			b = c.equalsSenhaCliente(senhanew);		

		}
		return b;
	}
	
	public void alterarsenha(String id , String senhaold , String senhanew) throws ONFException , WPException{
		
		Cliente c = new Cliente();
		c = this.buscarCliente(id);		
		if(c.getId() != null)
		{
			c.alterarSenha(senhaold, senhanew);
		}
		
		
	}
	
	public String getNomecliente(String id){
		
		Cliente c = new Cliente();
		int x = this.procurarIndice(id);
		c = this.listaClientes.get(x);
		
		return c.getNome();
	}
	
}
