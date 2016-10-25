package br.ufrpe.fastFood.negocios;


import java.util.List;

import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.dados.RepositorioPromocoes;

public class GerenciadorPromocoes {

	private RepositorioPromocoes repositorio;
	
	
	public GerenciadorPromocoes()
	{
		this.repositorio = RepositorioPromocoes.getInstance();
	}
	
	
	public void cadastrarCombo(PromocaoCombo a)
	{
		if( a != null)
		{
			this.repositorio.cadastrarComboPromotion(a);
		}
		
	}
	
	
	public void cadastrarProduto(PromocaoProduto a)
	{
		if( a != null)
		{
			this.repositorio.cadastrarProdutoPromotion(a);
		}
		
	}
	
	public boolean removerCombo(String idPromocao)
	{
		return this.repositorio.removerComboPromotion(idPromocao);
	}
	
	public boolean removerProduto(String idPromocao)
	{
		return this.repositorio.removerProdutoPromotion(idPromocao);
	}
	
	
	public List<PromocaoCombo> listarCombosPromotion()
	{
		return this.repositorio.listarPromoCombos();
	}
	
	public List<PromocaoProduto> listarProdutoPromotion()
	{
		return this.repositorio.listarPromoProduto();
	}
	
}
