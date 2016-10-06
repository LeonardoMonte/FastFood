package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;


public class TesteFuncionario {
	
	public static void main(String[] args){
		
		RepositorioFuncionarios repositorioFuncionarios = RepositorioFuncionarios.getInstancia();
		
		//Criando um Funcionario
		Endereco end1 = new Endereco("São sebastiao", "Piedade", "Jaboatão", "Pernambuco", 417, "(81) 5555-6666");
		Funcionario funcionario1 = new Funcionario("Pedro", "123456765", "28/11/1996", end1, "1234");
				
				
		//Imprimindo o Funcionario
		System.out.println(funcionario1); 
		
		//Adicionando Fencionario
		repositorioFuncionarios.cadastrarFuncionario(funcionario1);
				
		//Buscando Funcionario atraves do ID
		System.out.println(repositorioFuncionarios.buscarFuncionario(funcionario1.getId()));
				
		// Removendo Funcinario e buscando Funcionario que foi removido
		repositorioFuncionarios.removerFuncionario(funcionario1.getId());
		System.out.println( repositorioFuncionarios.buscarFuncionario(funcionario1.getId()));
		
		
	}

}
