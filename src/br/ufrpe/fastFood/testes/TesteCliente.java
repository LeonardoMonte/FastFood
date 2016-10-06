package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.dados.RepositorioClientes;


public class TesteCliente {

	public static void main(String [] args){
		
		RepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();
		
		
		//Criando um cliente
		Endereco end1 = new Endereco("Marechal Deodoro Fosneca", "Afogados", "Recife", "Pernambuco", 123, "(81) 98877-6666");
		Cliente cliente1 = new Cliente("Ana", "12131424400", "18/10/1998", end1, "123456", "ana_f@ufrpe.br");
		
		
		//Imprimindo o cliente
		System.out.println(cliente1); 
		
		//Adicionando Cliente
		repositorioClientes.cadastrarCliente(cliente1);
		
		//Buscando Cliente através do ID
		System.out.println(repositorioClientes.buscarCliente(cliente1.getId()));
		
		// Removendo cliente e buscando Cliente que fora removido
		repositorioClientes.removerCliente(cliente1.getId());
		System.out.println( repositorioClientes.buscarCliente(cliente1.getId()));
		
		
		
		
		
		
	}
}
