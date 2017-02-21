package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
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

	public void cadastrar(Funcionario a) throws OJEException {

		this.repositorio.cadastrarFuncionario(a);
		this.repositorio.save();
	}

	public void remover(String id) throws ONFException {
		
		this.repositorio.removerFuncionario(id);
		this.repositorio.save();

	}

	public Funcionario procurar(String id) throws ONFException {
		
		return this.repositorio.buscarFuncionario(id);

	}

	public void atualizarFuncionario(String id, Endereco ende) throws ONFException {

		this.repositorio.atualizarFuncionarioendereco(id, ende);
		this.repositorio.save();
	}

	public List<Funcionario> listarFuncionarios() {
	
			return this.repositorio.listarFuncinario();

	}

	public boolean loginFuncionario(String id, String senha) throws ONFException, WPException {
		
		 return this.repositorio.loginFunc(id, senha);
		
	}
	
	public boolean loginAdmin(String id, String senha) throws ONFException, WPException
	{
		return this.repositorio.loginAdmin(id, senha);
	}


	public void alterarSenha(String id, String senhaold, String senhanew) throws ONFException, WPException {
		
		this.repositorio.alterarsenha(id, senhaold, senhanew);
		this.repositorio.save();

	}
}
