package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Bebida;
import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.Vendas;
import br.ufrpe.fastFood.dados.RepositorioVendas;

public class TesteVenda {
	public static void main(String [] args){
		
		RepositorioVendas repositorio = RepositorioVendas.getInstancia();
		
		Vendas venda = new Vendas();
		Vendas venda1 = new Vendas();
		Vendas venda2 = new Vendas();
		
		Produto hamburguer = new Hamburguer("McDonald", 12.00, "0001H");
		Produto hamburguer1 = new Hamburguer("BurgerGrill", 12.00, "0002H");
		Produto bebida = new Bebida("refrigerante", 5.00, "0001T", "cola");
		Produto bebida1 = new Bebida("suco", 5.00, "0002T", "maracuja");
		
		//venda
		venda.addProduto(hamburguer1);
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
		
		
	}
}
