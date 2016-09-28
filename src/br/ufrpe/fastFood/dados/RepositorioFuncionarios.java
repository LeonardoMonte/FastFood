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
		if(f != null){	//verifica se o funcionario é não-nulo

			int cont = 0;

			for (int i = 0; i < this.listaFuncionarios.size();i ++){ 	//Percorre o array para verificar se tem algum funcionario igual na lista
				if(this.listaFuncionarios.get(i).equals(f))  			
					cont+= 1;
			}
			
			if (cont == 0){ //Adiciona produto
				this.listaFuncionarios.add(f);
			}
		}
	}
	
	public Funcionario buscarFuncionario(String id){
		if(id != null){
			Funcionario f;
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (this.listaFuncionarios.get(i).getId().equals(id)){
					f = listaFuncionarios.get(i);
				}
			}
			return f;
		}
	}

}
