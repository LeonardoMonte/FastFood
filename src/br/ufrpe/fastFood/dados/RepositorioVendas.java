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

	public Venda buscarVenda(String id){
		Venda resultado = null;
		int i = 0;
		boolean achou = false;

		if(id != null){

			while((!achou) && (i < this.listaVendas.size())) {
				if (this.listaVendas.get(i).getIdVenda().equals(id)){
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

	public boolean deletarVenda(Venda v){
		boolean resultado = false;
		if (v != null){

			for (Venda venda : listaVendas) {
				if (v.equals(venda))
					resultado = listaVendas.remove(venda);
			}
		}
		return resultado;
	}

	public void atualizarVendas(Venda novaVenda){

		if(buscarVenda(novaVenda.getIdVenda()) != null){

			for(Venda venda : listaVendas){

				if(venda.equals(novaVenda)){					

					venda = novaVenda;

				}
			}

		}
	}

	public List<Venda> listarVendas(){

		return this.listaVendas;
	}
}
