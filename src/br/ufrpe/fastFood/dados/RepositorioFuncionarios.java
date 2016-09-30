package br.ufrpe.fastFood.dados;
import java.util.ArrayList;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;

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
		Funcionario resultado = null;
		int i = 0;
		boolean achou = false;

		if(id != null){
			
			while((!achou) && (i < this.listaFuncionarios.size())) {
				if (this.listaFuncionarios.get(i).getId().equals(id)){
					achou = true;
					
				}else{
					i++;
				}
			}
			
			if(i < this.listaFuncionarios.size()){
				resultado = this.listaFuncionarios.get(i);
				
			}
			
		}
		return resultado;
	}
	
	public void removerFuncionario(String id){
		Funcionario resultado;
		int i = 0;
		boolean achou = false;

		if(id != null){
			
			while((!achou) && (i < this.listaFuncionarios.size())) {
				if (this.listaFuncionarios.get(i).equals(id)){
					achou = true;
					
				}else{
					i++;
				}
			}
			resultado = this.listaFuncionarios.get(i);
			
			if(achou == true){
				this.listaFuncionarios.remove(resultado);
				
			}
		}
	}
}
