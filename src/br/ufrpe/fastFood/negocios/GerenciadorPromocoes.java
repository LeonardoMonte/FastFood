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
	
	public PromocaoProduto buscarPromocaoProduto( String idPromocao)
	{
		return this.repositorio.buscarPromoProduto(idPromocao);
	}
	
	public PromocaoCombo buscarPromocaoCombo(String idPromocao)
	{
		return this.repositorio.buscarPromoCombo(idPromocao);
		
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
	
	public boolean alterarPrecoPromoCombo(double newprice , String idPromocao)
	{
		return this.repositorio.alterarPrecoComboPromo(newprice, idPromocao);
	}
	
	public boolean alterarPrecoPromoProduto(double newprice , String idPromocao)
	{
		return this.repositorio.alterarPrecoProdutoPromo(newprice, idPromocao);
		
	}
	
	public boolean Existepromocombo(String codigo)
	{
		return this.Existepromocombo(codigo);
	}
	
	public boolean Existepromoproduto(String codigo)
	{
		return this.Existepromoproduto(codigo);
	}
	
}
