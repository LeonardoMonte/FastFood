package br.ufrpe.fastFood.testes;

import br.ufrpe.fastFood.beans.Hamburguer;
import br.ufrpe.fastFood.beans.Vendas;

public class TesteVenda {
	public static void main(String [] args){
		
		Vendas venda1 = new Vendas();
		
		//necessario fazer cast para usar os metodos
				Hamburguer hamburguer1 = (Hamburguer) hamburguer;
			
			//adicionando ingredientes ao hamburger(testando os metodos de hamburger);
				hamburguer1.addIngrediente("cebola");
				hamburguer1.addIngrediente("tomate");
				hamburguer1.removerIngredientes("cebola");
		
	}
}
