package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
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
	
		if(f != null)
		{				// O gerenciador chama a função existe para checar se ja existe um cliente cm 
						// aquele id			
			this.listaFuncionarios.add(f);	
		}
	}
	
	public Funcionario buscarFuncionario(String id){
		
		Funcionario resultado = null;
		
		int i = this.procurarIndiceF(id);

		if(i > 0 )
		{		
			resultado = this.listaFuncionarios.get(i);
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
	
	public boolean removerFuncionario(String id){		
			
		boolean resultado = false;
		Funcionario rresultado = null;
		int i = this.procurarIndiceF(id);
		
			if( i > 0)
			{
				rresultado = this.listaFuncionarios.get(i);	
				this.listaFuncionarios.remove(rresultado);
				resultado = true;
			}	
			
		return resultado;
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
		Funcionario c = this.buscarFuncionario(id);	
		boolean resultado = c.equalsSenhaFunc(id, senha);
		return resultado;
		
	}
}
