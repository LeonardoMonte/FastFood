package br.ufrpe.fastFood.testes;


import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.dados.RepositorioVendas;

public class TesteVenda {
	public static void main(String [] args){
		
		RepositorioVendas repositorio = RepositorioVendas.getInstancia();
		
		Venda venda = new Venda();
		Venda venda1 = new Venda();
		Venda venda2 = new Venda();
		
	
		//venda
	/*	venda.addProduto(hamburguer1);
		venda.addProduto(bebida1);
		venda.calculaValorTotal();
		
		//segunda venda
		venda1.addProduto(hamburguer);
		venda1.addProduto(bebida);
		venda1.calculaValorTotal();
		
		//terceira venda
		venda2.addProduto(hamburguer);
		venda2.addProduto(hamburguer1);
		venda2.addProduto(bebida);
		venda2.addProduto(bebida1);
		venda2.calculaValorTotal();
		
		//imprimindo todas vendas
		System.out.println(venda);
		System.out.println(venda1);
		System.out.println(venda2);
		
		//cadastrando vendas no repositorio
		repositorio.cadastrarVenda(venda);
		repositorio.cadastrarVenda(venda1);
		repositorio.cadastrarVenda(venda2);
		*/
		
	}
}
