package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
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
	
	
	public void cadastrar(Combo a)
	{
		this.listaCombos.add(a);
	}
	
	
	public boolean removerCombo(String codigo)
	{
		
		int remove = this.procurarIndiceC(codigo);
		boolean resultado = false;
		
		if( remove >= 0)
		{
			this.listaCombos.remove(remove);
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public Combo buscarCombo(String codigo)
	{
		Combo a = new Combo();
		
		int x = this.procurarIndiceC(codigo);
		
		if( x >= 0)
		{
			a = this.listaCombos.get(x);
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
	
	
	public boolean existeCombo(String codigo)
	{
		boolean resultado = false;
		Combo a = new Combo();
		
		a = this.buscarCombo(codigo);
		
		if( a != null)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	public List<Combo> listarCombos() {

		return this.listaCombos;
		
	}
	
	
	public boolean AdicionarProduto(Produto p , String codigo)
	{
		boolean resultado = false;
		Combo c = new Combo();		
		c = this.buscarCombo(codigo);
		
		if( c != null)
		{
			c.addItens(p);
			resultado = true;
		}
		
		return resultado;
		
		
	}
	
	public boolean RemoverProduto(Produto p , String codigo)
	{
		boolean resultado = false;
		Combo c = new Combo();
		c = this.buscarCombo(codigo);
		
		if( c != null)
		{
			c.removerProdutoNoCombo(p.getCodigo());
			resultado = true;
		}
		
		return resultado;
	}
	
	public void AlterarNomeCombo(String nome, String codigo)
	{
		Combo c = new Combo();
		c = this.buscarCombo(codigo);
		
		if( c != null)
		{
			c.setNome(nome);		
		}
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
