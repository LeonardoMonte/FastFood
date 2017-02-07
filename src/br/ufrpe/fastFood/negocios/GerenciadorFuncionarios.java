package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;
import br.ufrpe.fastFood.interfaces.RepositorioFuncionarioInterface;

public class GerenciadorFuncionarios {

	private static GerenciadorFuncionarios instancia;
	private RepositorioFuncionarioInterface repositorio;

	public GerenciadorFuncionarios() {
		this.repositorio = RepositorioFuncionarios.getInstancia();
	}
	
	public static GerenciadorFuncionarios getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorFuncionarios();
		}
		
		return instancia;
	}

	public void cadastrar(Funcionario a) {

		this.repositorio.cadastrarFuncionario(a);
		
	}

	public boolean remover(String id) {
		
		return this.repositorio.removerFuncionario(id);	

	}

	public Funcionario procurar(String id) {
		return this.repositorio.buscarFuncionario(id);

	}

	public boolean atualizarFuncionario(String id, Endereco ende) {

		return  this.repositorio.atualizarFuncionarioendereco(id, ende);
		
	}

	public List<Funcionario> listarFuncionarios() {
	
			return this.repositorio.listarFuncinario();

	}

	public boolean loginFuncionario(String id, String senha) {
		
		return this.repositorio.loginFunc(id, senha);
		
	}

	public boolean existe(String id) {
		return this.repositorio.existeFuncionario(id);
	}

	public boolean alterarSenha(String id, String senhaold, String senhanew) {
		return this.repositorio.alterarsenha(id, senhaold, senhanew);

	}
}
