package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;


import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.interfaces.RepositorioPromocoesInterface;

public class RepositorioPromocoes implements RepositorioPromocoesInterface {
	
	private static RepositorioPromocoes instance;
	private ArrayList<PromocaoCombo> listapromocombos;
	private ArrayList<PromocaoProduto> listapromoprodutos;
	
	
	private RepositorioPromocoes()
	{
		this.listapromocombos = new ArrayList<>();
		this.listapromoprodutos = new ArrayList<>();
		
	}
	
	public static RepositorioPromocoes getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioPromocoes();
		}
		
		return instance;
	}
	
	
	public void cadastrarComboPromotion(PromocaoCombo a)
	{
		this.listapromocombos.add(a);
	}
	
	public void cadastrarProdutoPromotion(PromocaoProduto a)
	{
		this.listapromoprodutos.add(a);
	}
	
	
	public boolean removerComboPromotion(String idPromocao)
	{
		
		int remove = this.procurarIndiceComboPromotion(idPromocao);
		boolean resultado = false;
		
		if( remove >= 0)
		{
			this.listapromocombos.remove(remove);
			resultado = true;
		}
		
		return resultado;	
	}
	
	public boolean removerProdutoPromotion(String idPromocao)
	{
		
		int remove = this.procurarIndiceProdutoPromotion(idPromocao);
		boolean resultado = false;
		
		if( remove >= 0)
		{
			this.listapromoprodutos.remove(remove);
			resultado = true;
		}
		
		return resultado;
		
	}
	
		
	
	public PromocaoCombo buscarPromoCombo(String idPromocao)
	{
		PromocaoCombo a = new PromocaoCombo();
		
		int x = this.procurarIndiceComboPromotion(idPromocao);
		
		if( x >= 0)
		{
			a = this.listapromocombos.get(x);
		}
		
		return a;
		
	}
	
	
	public PromocaoProduto buscarPromoProduto(String idPromocao)
	{
		PromocaoProduto a = new PromocaoProduto();
		
		int x = this.procurarIndiceProdutoPromotion(idPromocao);
		
		if( x >= 0)
		{
			a = this.listapromoprodutos.get(x);
		}
		
		return a;
		
	}
	
	
	
	public int procurarIndiceComboPromotion(String idPromocao) {
		
		int cont = -1;

		for (int x = 0; x < this.listapromocombos.size(); x++) {
			if (this.listapromocombos.get(x).getIdPromocao().equals(idPromocao)) {
				cont = x;
			}
		}
		return cont;
	}
	
	public int procurarIndiceProdutoPromotion(String idPromocao) {
		
		int cont = -1;

		for (int x = 0; x < this.listapromoprodutos.size(); x++) {
			if (this.listapromoprodutos.get(x).getIdPromocao().equals(idPromocao)) {
				cont = x;
			}
		}
		return cont;
	}
	
	public boolean existePromoCombo(String idPromocao)
	{
		boolean resultado = false;
		PromocaoCombo a = new PromocaoCombo();
		
		a = this.buscarPromoCombo(idPromocao);
		
		if( a != null)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	public boolean existePromoProduto(String idPromocao)
	{
		boolean resultado = false;
		PromocaoProduto a = new PromocaoProduto();
		
		a = this.buscarPromoProduto(idPromocao);
		
		if( a != null)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	
	public List<PromocaoCombo> listarPromoCombos() {

		return this.listapromocombos;
		
	}
	
	public List<PromocaoProduto> listarPromoProduto() {

		return this.listapromoprodutos;
		
	}
	
	public void alterarPrecoComboPromo(double newprice, String idPromocao)
	{
		PromocaoCombo a = new PromocaoCombo();
		a = this.buscarPromoCombo(idPromocao);
		
		if( a != null )
		{
			a.setValor(newprice);
		}
	}
	
	public void alterarPrecoProdutoPromo(double newprice , String idPromocao)
	{
		PromocaoProduto a = new PromocaoProduto();
		a = this.buscarPromoProduto(idPromocao);
		
		if( a != null )
		{
			a.setValor(newprice);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
