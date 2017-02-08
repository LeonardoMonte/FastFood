package br.ufrpe.fastFood.interfaces;

import java.util.List;

import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;

public interface RepositorioPromocoesInterface {

		
	void cadastrarComboPromotion(PromocaoCombo a) throws OJEException;
	
	void cadastrarProdutoPromotion(PromocaoProduto a) throws OJEException;
	
	void removerComboPromotion(String idPromocao) throws ONFException;
	
	void removerProdutoPromotion(String idPromocao) throws ONFException;
	
	PromocaoCombo buscarPromoCombo(String idPromocao) throws ONFException;
	
	PromocaoProduto buscarPromoProduto(String idPromocao) throws ONFException;
	
	int procurarIndiceComboPromotion(String idPromocao);
	
	int procurarIndiceProdutoPromotion(String idPromocao);
	
	
	List<PromocaoCombo> listarPromoCombos();
	
	List<PromocaoProduto> listarPromoProduto();
	
	void alterarPrecoComboPromo(double newprice, String idPromocao) throws ONFException;
	
	void alterarPrecoProdutoPromo(double newprice , String idPromocao) throws ONFException;
	
	
}
