package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioCombos;
import br.ufrpe.fastFood.interfaces.RepositorioCombosInterface;

public class GerenciadorCombos {

	private static GerenciadorCombos instancia;
	private RepositorioCombosInterface repositorio;
	
	public GerenciadorCombos()
	{
		this.repositorio = RepositorioCombos.getInstance();
	}
	
	public static GerenciadorCombos getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorCombos();
		}
		
		return instancia;
	}
	
	public void cadastrarCombo(Combo a)
	{		
		
		this.repositorio.cadastrar(a);
					
	}
	
	public boolean removerCombo(String codigo)
	{
		return this.repositorio.removerCombo(codigo);
	}
	
	public List<Combo> listarCombos()
	{
		return this.repositorio.listarCombos();
	}
	
		
	public Combo procurarCombo(String codigo)
	{
		return this.repositorio.buscarCombo(codigo);
	}
	
	public boolean AdicionarProduto(Produto p ,String codigo)
	{

		return	this.repositorio.AdicionarProduto(p, codigo);

	}
	
	
	public boolean RemoverProduto(Produto p ,String codigo)
	{

		return this.repositorio.RemoverProduto(p, codigo);

	}
	
	public boolean Existecombo(String codigo)
	{
		return this.repositorio.existeCombo(codigo);
	}
	
	
	
}
