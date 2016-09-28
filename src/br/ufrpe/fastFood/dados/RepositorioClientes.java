package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import Teste.Cliente;

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
		
		if(c != null){	//verifica se o Cliente é não-nulo

			int cont = 0;
			
			for (int i = 0; i < this.listaClientes.size();i ++){ 	//Percorre o array para verificar se tem algum cliente identico
				if(this.listaClientes.get(i).equals(c))  			
					cont++;
			}
			
			if (cont == 0){ 
				this.listaClientes.add(c);		//Adiciona produto
			}
		}
	}
	
	public Cliente buscarCliente(){
		
		
		return null;
	}
}
