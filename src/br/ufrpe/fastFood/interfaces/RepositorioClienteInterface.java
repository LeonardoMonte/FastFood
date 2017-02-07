package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;

public interface RepositorioClienteInterface {

	// Recebe um cliente como argumento e cadastra
	// ele na lista de clientesdo repositorio...

	void cadastrarCliente(Cliente c);

	// Recebe uma string (que é um atributo de tipo pessoa)
	// e chama o metodo procuraIndice que retorna a posicao
	// do cliente caso esse esteja na lista ou retorna -1
	// caso ele nao exista.

	Cliente buscarCliente(String id);

	// Recebe uma string e tambem chama o metodo procuraIndice
	// e caso seja retornado um valor diferente de -1 ele
	// remove o cliente da lista no indice indicado....

	boolean removerCliente(String id);

	// Recebe um id para fazer a busca pelo cliente e
	// o endereco para modificaçao, caso o cliente seja
	// achado ele modifica o endereco.

	boolean atualizarClienteendereco(String id, Endereco ende);

	// Lista todos os clientes cadastrados....

	List<Cliente> listarClientes();

	// Metodo que recebe como parametro um id e verifica
	// se ja existe um cliente com o mesmo id...

	boolean existeCliente(String id);

	// Metodo que recebe um id como parametro e retorna
	// verdadeiro caso o indice esteja na lista de clientes...

	boolean existeIndice(int ind);

	// Metodo que recebe um id como parametro e retorna
	// o indice onde aquele id se encontra caso ele
	// exista ou -1 caso controu;

	int procurarIndice(String id);

	// Recebe um id, a senha antiga e a nova senha do cliente
	// e procura o cliente na lista de clientes cadastrados,
	// caso o cliente seja encontrado a senha antiga é substituida
	// pela a nova.

	boolean alterarsenha(String id, String senhaold, String senhanew);

	String getNomecliente(String id);
	
	public boolean loginCliente(String id , String senha);
}
