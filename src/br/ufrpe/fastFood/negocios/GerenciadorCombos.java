package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioCombos;

public class GerenciadorCombos {

	private RepositorioCombos repositorio;
	
	public GerenciadorCombos()
	{
		this.repositorio = RepositorioCombos.getInstance();
	}
	
	public void cadastrarCombo(Combo a)
	{
		if( a != null)
		{
			this.repositorio.cadastrar(a);
			
		}
	}
	
	public boolean removerCombo(String codigo)
	{
		return this.repositorio.removerCombo(codigo);
	}
	
	public List<Combo> listarCombos()
	{
		return this.repositorio.listarCombos();
	}
	
	
	public void alterarNome(String nome , String codigo)
	{
		this.repositorio.AlterarNomeCombo(nome, codigo);
	}
	
	
	public Combo procurarCombo(String codigo)
	{
		return this.repositorio.buscarCombo(codigo);
	}
	
	public boolean AdicionarProduto(Produto p ,String codigo)
	{
		boolean resultado = false;
		
		if( p != null)
		{
			this.repositorio.AdicionarProduto(p, codigo);
			resultado = true;
		}
		
		return resultado;
	}
	
	
	public boolean RemoverProduto(Produto p ,String codigo)
	{
		boolean resultado = false;
		
		if( p != null)
		{
			this.repositorio.RemoverProduto(p, codigo);
			resultado = true;
		}
		
		return resultado;
	}
	
	
	
	
}
