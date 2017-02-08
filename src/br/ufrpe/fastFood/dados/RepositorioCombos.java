package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;
import br.ufrpe.fastFood.interfaces.RepositorioCombosInterface;

public class RepositorioCombos implements RepositorioCombosInterface {
	
	private static RepositorioCombos instance;
	private ArrayList<Combo> listaCombos;
	
	private RepositorioCombos()
	{
		this.listaCombos = new ArrayList<>();
	}
	
	public static RepositorioCombos getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioCombos();
		}
		
		return instance;
	}
	
	
	public void cadastrar(Combo a) throws OJEException
	{
		int cont = 0;
		
		for(int x = 0 ; x <	this.listaCombos.size() ; x++)
		{
			if(this.listaCombos.get(x).getCodigo().equals(a.getCodigo()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException(a.getCodigo());
		}
		else
		{
			this.listaCombos.add(a);
		}
		
		
	}
	
	
	public void removerCombo(String codigo) throws ONFException
	{
		Combo c = new Combo();
		c = this.buscarCombo(codigo);
		
		this.listaCombos.remove(c);		
		
	}
	
	public Combo buscarCombo(String codigo) throws ONFException
	{
		Combo a = new Combo();
		
		int x = this.procurarIndiceC(codigo);
		
		if( x >= 0)
		{
			a = this.listaCombos.get(x);
		}
		else
		{
			throw new ONFException(codigo);
		}
		
		return a;
		
	}
	
	
	public int procurarIndiceC(String codigo) {
		
		int cont = -1;

		for (int x = 0; x < this.listaCombos.size(); x++) {
			if (this.listaCombos.get(x).getCodigo().equals(codigo)) {
				cont = x;
			}
		}
		return cont;
	}
	
	
	public List<Combo> listarCombos() {

		return this.listaCombos;
		
	}
	
	
	public void AdicionarProduto(Produto p , String idcodigo) throws ONFException, OJEException
	{
		Combo c = new Combo();
		c = this.buscarCombo(idcodigo);
		
		c.addItens(p);

		
		
	}
	
	public void RemoverProduto(Produto p , String idproduto) throws ONFException, PNEException
	{
		Combo c = new Combo();
		c = this.buscarCombo(idproduto);
		
		c.removerProdutoNoCombo(p.getCodigo());
	}
	
	
	
}
