package src.br.ufrpe.fastFood.negocios;

import java.util.List;

import src.br.ufrpe.fastFood.beans.Venda;
import src.br.ufrpe.fastFood.dados.RepositorioVendas;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.interfaces.RepositorioVendaInterface;

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
		this.repositorio.save();
		
	}

	public void remover(String idVenda) throws ONFException {
		
		this.repositorio.removerVenda(idVenda);
		this.repositorio.save();
		
	
	}

	public Venda procurar(String idVenda) throws ONFException {
		
		return this.repositorio.buscarVenda(idVenda);

	}


	public List<Venda> listarVendas() {
	
			return this.repositorio.listarVendas();
		
	}
	
}
