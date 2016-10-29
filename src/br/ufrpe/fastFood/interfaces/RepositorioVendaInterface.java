package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.Venda;

public interface RepositorioVendaInterface {
	
	
	void cadastrarVenda(Venda v);
	
	Venda buscarVenda(String idVenda);
	
	boolean removerVenda(String idVenda);
	
	List<Venda> listarVendas();
	
	int procurarIndiceV(String idVenda);
	
	boolean existeVenda(String idVenda);
	
	boolean existeIndiceV(int ind);
	
	
	

}
