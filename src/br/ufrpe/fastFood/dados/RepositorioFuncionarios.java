package br.ufrpe.fastFood.dados;
import java.util.ArrayList;

import Teste.Funcionario;

public class RepositorioFuncionarios {
	private static RepositorioFuncionarios instancia;
	private ArrayList <Funcionario> listaFuncionarios;
	
	private RepositorioFuncionarios(){
		this.listaFuncionarios = new ArrayList <>();
	}
	
	public static RepositorioFuncionarios getInstancia(){
		if(instancia == null){
			instancia = new RepositorioFuncionarios();
		}
		
		return instancia;
	}
	
	public void cadastrarFuncionario(Funcionario f){
		if(f != null){
			
			//verifica se o produto é não-nulo
			int cont = 0;
			//Percorre o array para verificar se há
			//algum produto identico na lista
			for (int i = 0; i < this.listaFuncionarios.size();i ++){ 
				if(this.listaFuncionarios.get(i).equals(f))  			
					cont+= 1;
			}//Adiciona produto
			if (cont == 0){ 
				this.listaFuncionarios.add(f);
			}
			//informa que produto já fora cadastrado
			else{ 		
				System.out.println("Produto já cadastrado!");
			}
			
		}
	}
	
	public Funcionario buscaFuncionario(String id){
		if(id != null){
			Funcionario f;
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (listaFuncionarios.get(i).)
			}
		}
	}

}
