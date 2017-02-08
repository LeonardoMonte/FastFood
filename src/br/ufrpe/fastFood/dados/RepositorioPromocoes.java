package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
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
	
	
	public void cadastrarComboPromotion(PromocaoCombo a) throws OJEException
	{
		int cont = 0;
		
		for(int x = 0 ; x < this.listapromocombos.size() ; x++)
		{
			if(this.listapromocombos.get(x).getIdPromocao().equals(a.getIdPromocao()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException(a.getIdPromocao());
		}
		else
		{
			this.listapromocombos.add(a);
		}
		
	}
	
	public void cadastrarProdutoPromotion(PromocaoProduto a) throws OJEException
	{
		int cont = 0;
		
		for(int x = 0 ; x < this.listapromoprodutos.size() ; x++)
		{
			if(this.listapromoprodutos.get(x).getIdPromocao().equals(a.getIdPromocao()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException(a.getIdPromocao());
		}
		else
		{
			this.listapromoprodutos.add(a);
		}
		
	}
	
	
	public void removerComboPromotion(String idPromocao) throws ONFException
	{
		
		PromocaoCombo p = new PromocaoCombo();
		p = this.buscarPromoCombo(idPromocao);

		if (p.getIdPromocao() != null) {
			
			this.listapromocombos.remove(p);
		}

	}
	
	public void removerProdutoPromotion(String idPromocao) throws ONFException
	{
		
		PromocaoProduto p = new PromocaoProduto();
		p = this.buscarPromoProduto(idPromocao);

		if (p.getIdPromocao() != null) {
			
			this.listapromoprodutos.remove(p);
		}
		
	}
	
		
	
	public PromocaoCombo buscarPromoCombo(String idPromocao) throws ONFException
	{
		PromocaoCombo a = new PromocaoCombo();
		
		int x = this.procurarIndiceComboPromotion(idPromocao);
		
		if( x >= 0)
		{
			a = this.listapromocombos.get(x);
		}
		else
		{
			throw new ONFException(idPromocao);
		}
		
		return a;
		
	}
	
	
	public PromocaoProduto buscarPromoProduto(String idPromocao) throws ONFException
	{
		PromocaoProduto a = new PromocaoProduto();
		
		int x = this.procurarIndiceProdutoPromotion(idPromocao);
		
		if( x >= 0)
		{
			a = this.listapromoprodutos.get(x);
		}
		else
		{
			throw new ONFException(idPromocao);
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
	
	
	
	public List<PromocaoCombo> listarPromoCombos() {

		return this.listapromocombos;
		
	}
	
	public List<PromocaoProduto> listarPromoProduto() {

		return this.listapromoprodutos;
		
	}
	
	public void alterarPrecoComboPromo(double newprice, String idPromocao) throws ONFException
	{
		PromocaoCombo p = new PromocaoCombo();
		p = this.buscarPromoCombo(idPromocao);
		
		if(p.getIdPromocao() != null)
		{
			p.setValor(newprice);
		}
					
	
	}
	
	public void alterarPrecoProdutoPromo(double newprice , String idPromocao) throws ONFException
	{
		PromocaoProduto p = new PromocaoProduto();
		p = this.buscarPromoProduto(idPromocao);
		
		if(p.getIdPromocao() != null)
		{
			p.setValor(newprice);
		}
			
	}
	

	
	

}
