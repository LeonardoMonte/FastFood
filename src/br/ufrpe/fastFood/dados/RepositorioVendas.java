package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import br.ufrpe.fastFood.beans.Vendas;

public class RepositorioVendas {
	
	private static RepositorioVendas instancia;
	private ArrayList <Vendas> listaVendas;
	
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
	
	public void cadastrarVenda(Vendas v){
		if(v != null){	//verifica se o objeto eh diferente de nulo

			int cont = 0;

			for (int i = 0; i < this.listaVendas.size();i ++){ 	//Percorre o array para verificar se tem algum funcionario igual na lista
				if(this.listaVendas.get(i).equals(v))  			
					cont+= 1;
			}
			
			if (cont == 0){ //Adiciona produto
				this.listaVendas.add(v);
			}
		}
	}
	
	public Vendas buscarVenda(String id){
		Vendas resultado;
		
		return resultado;
	}
	
	public boolean deletarVenda(Vendas v){
		boolean resultado = false;
		if (v != null){
			
			for (Vendas vendas : listaVendas) {
				if (v.equals(vendas))
					resultado = listaVendas.remove(vendas);
			}
		}
		return resultado;
	}
	

}
