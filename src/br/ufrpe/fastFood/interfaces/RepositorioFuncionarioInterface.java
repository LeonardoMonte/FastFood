package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;

public interface RepositorioFuncionarioInterface {

	// Recebe um funcionario como argumento e cadastra
	// ele na lista de funcionarios do repositorio...

	void cadastrarFuncionario(Funcionario f);

	// Recebe uma string (que é um atributo de tipo pessoa)
	// e chama o metodo procuraIndice que retorna a posicao
	// do funcionario caso esse esteja na lista ou retorna -1
	// caso ele nao exista.

	Funcionario buscarFuncionario(String id);

	// Recebe uma string e tambem chama o metodo procuraIndice
	// e caso seja retornado um valor diferente de -1 ele
	// remove o funcionario da lista no indice indicado....

	boolean removerFuncionario(String id);

	// Recebe um id para fazer a busca pelo funcionario e
	// o endereco para modificaçao, caso o cliente seja
	// achado ele modifica o endereco.

	boolean atualizarFuncionarioendereco(String id, Endereco ende);

	// Lista todos os funcionarios cadastrados....

	List<Funcionario> listarFuncinario();

	// Metodo que recebe como parametro um id e verifica
	// se ja existe um funcionario com o mesmo id...

	boolean existeFuncionario(String id);

	// Metodo que recebe um id como parametro e retorna
	// verdadeiro caso o indice esteja na lista de funcionarios...

	boolean existeIndiceF(int ind);

	// Metodo que recebe um id como parametro e retorna
	// o indice onde aquele id se encontra caso ele
	// exista ou -1 caso controu;

	int procurarIndiceF(String id);

	// Recebe um id, a senha antiga e a nova senha do funcionario
	// e procura o funcionario na lista de funcionario cadastrados,
	// caso ele seja encontrado a senha antiga é substituida
	// pela a nova.

	boolean alterarsenha(String id, String senhaold, String senhanew);
	
	public boolean loginFunc(String id, String senha);

}
