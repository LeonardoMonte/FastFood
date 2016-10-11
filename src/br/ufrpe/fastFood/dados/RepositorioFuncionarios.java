package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Venda;

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
				
			this.listaFuncionarios.add(f);	
	}
	
	public Funcionario buscarFuncionario(String id){
		
		Funcionario resultado = null;
		
		int i = this.procurarIndiceF(id);

		if(i >= 0 )
		{		
			resultado = this.listaFuncionarios.get(i);
		}
	
		return resultado;
		
	}
	
	public boolean atualizarFuncionarioendereço(String id , Endereco ende){	
		
		boolean resultado = false;
		if(this.existeFuncionario(id) == true){

			for(Funcionario func : listaFuncionarios){
				if(func.getId().equals(id)){					
				
					func.setEndere(ende);
					resultado = true;
				}
			}

		}
		return resultado;
	} 
	
	public boolean removerFuncionario(String id){		
			
		
		Funcionario resultado = new Funcionario();
		int i = this.procurarIndiceF(id);
		boolean result = false;
		
			if( i >= 0)
			{
				resultado = this.listaFuncionarios.get(i);	
				this.listaFuncionarios.remove(resultado);
				result = true;
			}	
			
			return result;
			
			
		
	}
	

	public List<Funcionario> listarFuncinario(){

		return this.listaFuncionarios;
	}
	
	public boolean existeFuncionario(String id)
	{
		// FUNÇÃO PARA CHECAR SE JA EXISTE UM FUNCIONARIO COM ESSE ID
		
		boolean resultado = false;
		
		for(Funcionario funcionario:listaFuncionarios)
		{
			if( funcionario.getId().equals(id))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean existeIndiceF(int ind)
	{
		boolean resultado = false;
		
		if( this.listaFuncionarios.get(ind) != null)
		{
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public int procurarIndiceF(String id)
	{
		// Função que procura indice especifico , enxugando os codigos de remover e adicionar
		
		int cont = -1; 

		for( int x = 0 ; x < this.listaFuncionarios.size() ; x++)
		{
			if( this.listaFuncionarios.get(x).getId().equals(id))
			{
				cont = x;
			}
		}
		return cont;
	}
	
	public boolean loginFunc(String id , String senha)
	{	
		Funcionario c = new Funcionario();
		c =	this.buscarFuncionario(id);
		boolean resultado = c.equalsSenhaFunc(id, senha);
		
		return resultado;
		
	}
	
	public boolean alterarsenha(String id , String senhaold , String senhanew)
	{
		Funcionario c = new Funcionario();
		c = this.buscarFuncionario(id);		
		boolean resultado = c.alterarSenha(senhaold, senhanew);
		return resultado;
	}
}
