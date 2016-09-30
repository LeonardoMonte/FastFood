package br.ufrpe.fastFood.beans;
import java.util.ArrayList;

public class Vendas{
	
	private Servicos servico;
	private ArrayList <Produto> listaProdutos;
	
	public Vendas(String nomeServico, String idServico){
		this.servico = new Servicos(nomeServico, idServico);
		
		
	}
	

}
