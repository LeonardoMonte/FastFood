package src.br.ufrpe.fastFood.interfaces;



import java.util.List;



import src.br.ufrpe.fastFood.beans.Combo;

import src.br.ufrpe.fastFood.beans.Produto;

import src.br.ufrpe.fastFood.exceptions.OJEException;

import src.br.ufrpe.fastFood.exceptions.ONFException;

import src.br.ufrpe.fastFood.exceptions.PNEException;



public interface RepositorioCombosInterface {



	

	void cadastrar(Combo p) throws OJEException;

	

	void removerCombo(String combo) throws ONFException;

	

	Combo buscarCombo(String codigo) throws ONFException;

	

	int procurarIndiceC(String codigo);

	public void atualizarCombo(String codigo , double valor) throws ONFException;

	

	List<Combo> listarCombos();

	
	
	void save();
	

	

}