package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Vendas;

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
		Funcionario resultado = new Funcionario();
		resultado.setId(id); 
		for (Funcionario funcionario : listaFuncionarios) {
			if(resultado.getId().equals(funcionario.getId())){
				resultado = funcionario;
			}
		}		
		return resultado;
	}
	
	public void atualizarFuncionario(Funcionario novoFuncionario){
		if(novoFuncionario != null){
			for (Funcionario funcionario : listaFuncionarios) {
				if (funcionario.getId().equals(novoFuncionario.getId())){
					funcionario = novoFuncionario;
				}
			}
		}
	}
	
	public void removerFuncionario(String id){
		Funcionario f = new Funcionario();
		f.setId(id);
		if(id != null){
			for (Funcionario funcionario : listaFuncionarios) {
				if(funcionario.equals(f.getId())){
					listaFuncionarios.remove(funcionario);
				}
			}			
		}
	}
	public List<Funcionario> listarFuncinario(){

		return this.listaFuncionarios;
	}
}
