package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;

public interface RepositorioCombosInterface {

	
	void cadastrar(Combo p);
	
	boolean removerCombo(String combo);
	
	Combo buscarCombo(String codigo);
	
	int procurarIndiceC(String codigo);
	
	boolean existeCombo(String codigo);
	
	List<Combo> listarCombos();
	
	boolean AdicionarProduto(Produto p , String codigo);
	
	boolean RemoverProduto(Produto p , String codigo);
	
	void AlterarNomeCombo(String nome , String codigo);
	
	
	
}
