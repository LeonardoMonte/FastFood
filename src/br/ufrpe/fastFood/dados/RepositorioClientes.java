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
	
	

}
