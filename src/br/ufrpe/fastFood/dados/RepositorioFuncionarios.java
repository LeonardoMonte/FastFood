package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.interfaces.RepositorioFuncionarioInterface;

public class RepositorioFuncionarios implements RepositorioFuncionarioInterface {
	private static RepositorioFuncionarios instancia;
	private ArrayList<Funcionario> listaFuncionarios;

	private RepositorioFuncionarios() {
		this.listaFuncionarios = new ArrayList<>();
	}

	public static RepositorioFuncionarios getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioFuncionarios();
		}

		return instancia;
	}

	public void cadastrarFuncionario(Funcionario f) throws OJEException {

		int cont = 0;
		
		for(int x = 0 ; x < this.listaFuncionarios.size() ; x++)
		{
			if(this.listaFuncionarios.get(x).getId().equals(f.getId()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException( f.getId());
		}
		else
		{
			this.listaFuncionarios.add(f);
		}
				
		
		
	}

	public Funcionario buscarFuncionario(String id) throws ONFException {

		Funcionario resultado = null;

		int i = this.procurarIndiceF(id);

		if (i >= 0) {
			resultado = this.listaFuncionarios.get(i);
		}
		else
		{
			throw new ONFException(id);
		}

		return resultado;

	}

	public void atualizarFuncionarioendereco(String id, Endereco ende) throws ONFException {

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		
		if( f.getId() != null)
		{
			f.setEndere(ende);
			
		}
		
	
	}

	public void removerFuncionario(String id) throws ONFException{

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		
		if( f.getId() != null)
		{
			this.listaFuncionarios.remove(f);
			
		}
	}

	public List<Funcionario> listarFuncinario() {

		return this.listaFuncionarios;
	}


	public int procurarIndiceF(String id) {

		int cont = -1;

		for (int x = 0; x < this.listaFuncionarios.size(); x++) {
			if (this.listaFuncionarios.get(x).getId().equals(id)) {
				cont = x;
			}
		}
		return cont;
	}

	public boolean loginFunc(String id, String senha) throws ONFException, WPException{

		boolean b = false;
		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);		
		if(f.getId() != null)
		{

			b = f.equalsSenhaFunc(senha);

		}
		return b;
	}


	public void alterarsenha(String id, String senhaold, String senhanew) throws ONFException, WPException {

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		if(f.getId() != null)
		{
			f.alterarSenha(senhaold, senhanew);
		}
	}
}
