package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.dados.RepositorioClientes;


public class TesteCliente {

	public static void main(String [] args){
				
		RepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();
		
		
		//Criando um cliente
		Endereco end1 = new Endereco("Marechal Deodoro Fosneca", "Afogados", "Recife", "Pernambuco", 123, "(81) 98877-6666");
		Cliente cliente1 = new Cliente("Ana Maria de Azevedo", "12131424400", "18/10/1998", end1, "123456", "ana_f@ufrpe.br");
		
		
		Endereco end2 = new Endereco("Luiz Guimares Filho", "Jardim Piedade", "Jaboatao", "Pernambuco", 5009, "(81) 98954-2429");
		Cliente cliente2 = new Cliente("Felipe Figueiredo Souza", "12345678900", "15/07/1989", end2, "654321", "ffsouza@ufrpe.br");
		
		Endereco end3 = new Endereco("Av. Paulista ", "Centro", "Sao Paulo", "Sao Paulo", 1233, "(11) 97304-9099");
		Cliente cliente3 = new Cliente("Gustavo Firmino de Cerqueira", "00987654321", "13/02/1973", end3, "gust123", "gfc@pascal.us");
		
		//Adicionando Cliente
		repositorioClientes.cadastrarCliente(cliente1);
		repositorioClientes.cadastrarCliente(cliente2);
		repositorioClientes.cadastrarCliente(cliente3);
		
		//Imprimindo lista de  clientes
		System.out.println("IMPRIMINDO LISTA DO REPOSITORIO\n\n" + repositorioClientes.listarClientes()); 
		
		//Buscando Cliente atravï¿½s do ID
		System.out.println("\n\nBUSCANDO USUARIO ATRAVÉS DO ID NO REPOSITORIO\n\n" + repositorioClientes.buscarCliente(cliente1.getId()));
		
		// Removendo cliente1
		repositorioClientes.removerCliente(cliente1.getId());
		
		// buscando Cliente que fora removido
		System.out.println( "\n\nBUSCANDO USUARIO DELETADO NO REPOSITORIO\n\n" + repositorioClientes.buscarCliente(cliente1.getId()));

		//Imprimindo lista de  clientes
		System.out.println("\n\nIMPRIMINDO LISTA DO REPOSITORIO\n\n" + repositorioClientes.listarClientes()); 
		
		
	}
}
