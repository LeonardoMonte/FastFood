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
	
	private GerenciadorCombos()
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
		this.repositorio.save();
					
	}
	
	public void atualizarCombo(String codigo , double valor) throws ONFException
	{
		this.repositorio.atualizarCombo(codigo, valor);
		this.repositorio.save();
	}
	
	public void removerCombo(String codigo) throws ONFException
	{
		this.repositorio.removerCombo(codigo);
		this.repositorio.save();
	}
	
	public List<Combo> listarCombos()
	{
		return this.repositorio.listarCombos();
	}
	
		
	public Combo procurarCombo(String codigo) throws ONFException
	{
		return this.repositorio.buscarCombo(codigo);
	}

	
}
