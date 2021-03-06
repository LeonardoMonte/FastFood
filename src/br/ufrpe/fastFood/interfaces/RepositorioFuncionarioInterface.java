package src.br.ufrpe.fastFood.interfaces;

import java.util.List;

import src.br.ufrpe.fastFood.beans.Funcionario;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.exceptions.WPException;

public interface RepositorioFuncionarioInterface {


	void cadastrarFuncionario(Funcionario f) throws OJEException;

	Funcionario buscarFuncionario(String id) throws ONFException;


	void removerFuncionario(String id) throws ONFException;


//	void atualizarFuncionarioendereco(String id, Endereco ende) throws ONFException;

	List<Funcionario> listarFuncinario();


	int procurarIndiceF(String id);

	void alterarsenha(String id, String senhaold, String senhanew) throws ONFException, WPException;
	
	boolean loginFunc(String id, String senha) throws ONFException, WPException;
	
	void save();
	
	public boolean loginAdmin(String id, String senha) throws ONFException, WPException;

}
