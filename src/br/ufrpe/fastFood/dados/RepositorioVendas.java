package br.ufrpe.fastFood.dados;
import java.util.ArrayList;
import br.ufrpe.fastFood.beans.Vendas;

public class RepositorioVendas {
	
	private static RepositorioVendas instancia;
	private ArrayList <Vendas> listaVendas;
	
	private RepositorioVendas(){
		this.listaVendas = new ArrayList <>();
	}
	
	public static RepositorioVendas getInstancia(){
		if(instancia == null){
			instancia = new RepositorioVendas();
		}
		return instancia;
	}
	
	public void cadastrarVenda(Vendas v){
		if(v != null){	//verifica se o funcionario é não-nulo

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
		Vendas resultado = null;
		int i = 0;
		boolean achou = false;

		if(id != null){
			
			while((!achou) && (i < this.listaVendas.size())) {
				if (this.listaVendas.get(i).getId().equals(id)){
					achou = true;
					
				}else{
					i++;
				}
			}
			
			if(i < this.listaVendas.size()){
				resultado = this.listaVendas.get(i);
				
			}
			
		}
		return resultado;
	}
	

}
