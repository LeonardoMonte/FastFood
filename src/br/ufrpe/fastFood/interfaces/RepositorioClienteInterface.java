package src.br.ufrpe.fastFood.interfaces;

import java.util.List;

import src.br.ufrpe.fastFood.beans.Cliente;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.exceptions.WPException;

public interface RepositorioClienteInterface {

	void cadastrarCliente(Cliente c) throws OJEException;

	Cliente buscarCliente(String id) throws ONFException;

	void removerCliente(String id) throws ONFException;

//	void atualizarClienteendereco(String id, Endereco ende) throws ONFException;

	List<Cliente> listarClientes();

	int procurarIndice(String id);

	void alterarsenha(String id, String senhaold, String senhanew) throws ONFException, WPException;

	String getNomecliente(String id);
	
	public boolean loginCliente(String id , String senhanew) throws ONFException, WPException;
	
	void save();
}
