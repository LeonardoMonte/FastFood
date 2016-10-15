package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Produto;;

public class RepositorioProdutos {
	private static RepositorioProdutos instancia;
	private ArrayList<Produto> listaProdutos;

	private RepositorioProdutos() {
		this.listaProdutos = new ArrayList<>();
	}

	public static RepositorioProdutos getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioProdutos();
		}
		return instancia;
	}

	public void cadastrarProduto(Produto p) {

		this.listaProdutos.add(p);
	}

	public Produto buscarProduto(String codigo) {

		Produto resultado = new Produto();

		int i = this.procurarIndiceP(codigo);

		if (i >= 0) {
			resultado = this.listaProdutos.get(i);
		}

		return resultado;
	}

	public boolean removerProduto(String codigo) {

		boolean resultado = false;
		Produto rresultado = new Produto();
		int i = this.procurarIndiceP(codigo);

		if (i >= 0) {
			rresultado = this.listaProdutos.get(i);
			this.listaProdutos.remove(rresultado);
			resultado = true;
		}

		return resultado;
	}

	public void atualizarProdutos(Produto novoProduto) {

		if (buscarProduto(novoProduto.getCodigo()) != null) {

			for (Produto produto : listaProdutos) {

				if (produto.getCodigo().equals(novoProduto.getCodigo())) {

					produto = novoProduto;

				}
			}
		}
	}

	public boolean existeIndiceP(int ind) {
		// FUN��O PARA CHEGAR SE EXISTE ALGO NAQUELA POSI��O EXPECIFICA( MEIO
		// NOSENSE MAS TEM UTILIDADE)
		boolean resultado = false;

		if (this.listaProdutos.get(ind) != null) {
			resultado = true;
		}

		return resultado;
	}

	public boolean existeProduto(String codigo) {
		// FUN��O PARA CHECAR SE JA EXISTE UM PRODUTO COM ESSE CODIGO

		boolean resultado = false;

		for (Produto produto : listaProdutos) {
			if (produto.getCodigo().equals(codigo)) {
				resultado = true;
			}
		}

		return resultado;
	}

	public int procurarIndiceP(String codigo) {
		// Fun��o que procura indice especifico , enxugando os codigos de
		// remover e adicionar

		int cont = -1;

		for (int x = 0; x < this.listaProdutos.size(); x++) {
			if (this.listaProdutos.get(x).getCodigo().equals(codigo)) {
				cont = x;
			}
		}
		return cont;
	}

	public List<Produto> listarProdutos() {

		return this.listaProdutos;
	}
}