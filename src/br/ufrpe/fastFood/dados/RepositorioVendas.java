package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.Venda;

public class RepositorioVendas {

	private static RepositorioVendas instancia;
	private ArrayList <Venda> listaVendas;

	private RepositorioVendas(){
		this.listaVendas = new ArrayList <>();
	}
	//Criando instancia unica para repositorio
	public static RepositorioVendas getInstancia(){
		if(instancia == null){
			instancia = new RepositorioVendas();
		}
		return instancia;
	}

	public void cadastrarVenda(Venda v){
	
		this.listaVendas.add(v);
	}

	public Venda buscarVenda(String idVenda){
		
		Venda resultado = new Venda();
		
		int i = this.procurarIndiceV(idVenda);

		if( i >= 0 )
		{		
			resultado = this.listaVendas.get(i);
		}
	
		return resultado;
	}

	public boolean removerVenda(String idVenda){
		
		boolean resultado = false;
		Venda rresultado = new Venda();
		int i = this.procurarIndiceV(idVenda);
		
			if( i >= 0)
			{
				rresultado = this.listaVendas.get(i);	
				this.listaVendas.remove(rresultado);
				resultado = true;
			}	
			
		return resultado;
	}

	public void atualizarVendas(Venda novaVenda){

		if(buscarVenda(novaVenda.getIdVenda()) != null){

			for(Venda venda : listaVendas){
				if(venda.getIdVenda().equals(novaVenda.getIdVenda())){					

					venda = novaVenda;
				}
			}

		}
	}

	public List<Venda> listarVendas(){

		return this.listaVendas;
	}
	
	public int procurarIndiceV(String idVenda)
	{
		// Função que procura indice especifico , enxugando os codigos de remover e adicionar
		
		int cont = -1; 

		for( int x = 0 ; x < this.listaVendas.size() ; x++)
		{
			if( this.listaVendas.get(x).getIdVenda().equals(idVenda))
			{
				cont = x;
			}
		}
		return cont;
	}
	
	public boolean existeVenda(String idVenda)
	{
		// FUNÇÃO PARA CHECAR SE JA EXISTE UMA VENDA COM ESSE CODIGO
		
		boolean resultado = false;
		
		for(Venda venda:listaVendas)
		{
			if( venda.getIdVenda().equals(idVenda))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean existeIndiceV(int ind)
	{
		// FUNÇÃO PARA CHEGAR SE EXISTE ALGO NAQUELA POSIÇÃO EXPECIFICA( MEIO NOSENSE MAS TEM UMA UTILIDADE)
		boolean resultado = false;
		
		if( this.listaVendas.get(ind) != null)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	
}
