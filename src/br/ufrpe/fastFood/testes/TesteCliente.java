package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;


public class TesteCliente {

	public static void main(String [] args){
		
		//Criando um cliente
		Endereco end1 = new Endereco("Marechal Deodoro Fosneca", "Afogados", "Recife", "Pernambuco", 123, "(81) 98877-6666");
		Cliente cliente1 = new Cliente("Ana", "12131424400", "18/10/1998", end1, "123456", "ana_f@ufrpe.br");
		
		
		//Imprimindo o cliente
		System.out.println(cliente1); 
		
		
		
		
		
		
	}
}
