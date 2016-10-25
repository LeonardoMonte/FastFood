package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;

public interface RepositorioPromocoesInterface {

		
	void cadastrarComboPromotion(PromocaoCombo a);
	
	void cadastrarProdutoPromotion(PromocaoProduto a);
	
	boolean removerComboPromotion(String idPromocao);
	
	boolean removerProdutoPromotion(String idPromocao);
	
	PromocaoCombo buscarPromoCombo(String idPromocao);
	
	PromocaoProduto buscarPromoProduto(String idPromocao);
	
	int procurarIndiceComboPromotion(String idPromocao);
	
	int procurarIndiceProdutoPromotion(String idPromocao);
	
	boolean existePromoCombo(String idPromocao);
	
	boolean existePromoProduto(String idPromocao);
	
	List<PromocaoCombo> listarPromoCombos();
	
	List<PromocaoProduto> listarPromoProduto();
	
}
