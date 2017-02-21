package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;

public interface RepositorioClienteInterface {

	void cadastrarCliente(Cliente c) throws OJEException;

	Cliente buscarCliente(String id) throws ONFException;

	void removerCliente(String id) throws ONFException;

	void atualizarClienteendereco(String id, Endereco ende) throws ONFException;

	List<Cliente> listarClientes();

	int procurarIndice(String id);

	void alterarsenha(String id, String senhaold, String senhanew) throws ONFException, WPException;

	String getNomecliente(String id);
	
	public boolean loginCliente(String id , String senhanew) throws ONFException, WPException;
	
	void save();
}
