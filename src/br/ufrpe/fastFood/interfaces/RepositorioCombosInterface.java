package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;

public interface RepositorioCombosInterface {

	
	void cadastrar(Combo p);
	
	void removerCombo(String combo) throws ONFException;
	
	Combo buscarCombo(String codigo) throws ONFException;
	
	int procurarIndiceC(String codigo);
	
	
	List<Combo> listarCombos();
	
	void AdicionarProduto(Produto p , String codigo) throws ONFException;
	
	void RemoverProduto(Produto p , String idproduto) throws ONFException, PNEException;
	
	
	
	
}
