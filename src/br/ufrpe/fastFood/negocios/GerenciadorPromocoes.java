package br.ufrpe.fastFood.negocios;


import java.util.List;

import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.dados.RepositorioPromocoes;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.interfaces.RepositorioPromocoesInterface;

public class GerenciadorPromocoes {

	
	private static GerenciadorPromocoes instancia;
	private RepositorioPromocoesInterface repositorio;
	
	
	public GerenciadorPromocoes()
	{
		this.repositorio = RepositorioPromocoes.getInstance();
	}
	
	public static GerenciadorPromocoes getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorPromocoes();
		}
		
		return instancia;
	}
	
	
	public void cadastrarCombo(PromocaoCombo a) throws OJEException
	{
		
		this.repositorio.cadastrarComboPromotion(a);
		
	}
	
	
	public void cadastrarProduto(PromocaoProduto a) throws OJEException
	{
		
			this.repositorio.cadastrarProdutoPromotion(a);
		
	}
	
	public PromocaoProduto buscarPromocaoProduto( String idPromocao) throws ONFException
	{
		return this.repositorio.buscarPromoProduto(idPromocao);
	}
	
	public PromocaoCombo buscarPromocaoCombo(String idPromocao) throws ONFException
	{
		return this.repositorio.buscarPromoCombo(idPromocao);
		
	}
	
	public void removerCombo(String idPromocao) throws ONFException
	{
		this.repositorio.removerComboPromotion(idPromocao);
	}
	
	public void removerProduto(String idPromocao) throws ONFException
	{
		this.repositorio.removerProdutoPromotion(idPromocao);
	}
	
	
	public List<PromocaoCombo> listarCombosPromotion()
	{
		return this.repositorio.listarPromoCombos();
	}
	
	public List<PromocaoProduto> listarProdutoPromotion()
	{
		return this.repositorio.listarPromoProduto();
	}
	
	public void alterarPrecoPromoCombo(double newprice , String idPromocao) throws ONFException
	{
		this.repositorio.alterarPrecoComboPromo(newprice, idPromocao);
	}
	
	public void alterarPrecoPromoProduto(double newprice , String idPromocao) throws ONFException
	{
		this.repositorio.alterarPrecoProdutoPromo(newprice, idPromocao);
		
	}
	
	
}
