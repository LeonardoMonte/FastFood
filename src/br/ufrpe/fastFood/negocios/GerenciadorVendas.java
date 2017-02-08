package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.dados.RepositorioVendas;
import br.ufrpe.fastFood.interfaces.RepositorioVendaInterface;

public class GerenciadorVendas {
	
	private static GerenciadorVendas instancia;
	private RepositorioVendaInterface repositorio;

	public GerenciadorVendas() {
		this.repositorio = RepositorioVendas.getInstancia();

	}
	
	public static GerenciadorVendas getInstancia(){
		
		if(instancia == null){
			instancia = new GerenciadorVendas();
		}
		
		return instancia;
	}

	public void cadastrar(Venda a) {

		this.repositorio.cadastrarVenda(a);
		
	}

	public boolean remover(String idVenda) {
	
		return this.repositorio.removerVenda(idVenda);

	}

	public Venda procurar(String idVenda) {
		
		return this.repositorio.buscarVenda(idVenda);

	}


	public List<Venda> listarVendas() {
	
			return this.repositorio.listarVendas();
		
	}
	
}
