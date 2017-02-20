package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioCombos;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;
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
	
	public void cadastrarCombo(Combo a) throws OJEException
	{		
		
		this.repositorio.cadastrar(a);
					
	}
	
	public void removerCombo(String codigo) throws ONFException
	{
		this.repositorio.removerCombo(codigo);
	}
	
	public List<Combo> listarCombos()
	{
		return this.repositorio.listarCombos();
	}
	
		
	public Combo procurarCombo(String codigo) throws ONFException
	{
		return this.repositorio.buscarCombo(codigo);
	}

	public void AdicionarProduto(Produto p ,String codigo) throws ONFException,  OJEException

	{



		this.repositorio.AdicionarProduto(p, codigo);



	}

	

	

	public void RemoverProduto(Produto p ,String codigo) throws ONFException, PNEException

	{



		this.repositorio.RemoverProduto(p, codigo);



	}
	
}
