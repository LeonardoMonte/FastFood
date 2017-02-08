package br.ufrpe.fastFood.dados;

import java.util.ArrayList;
import java.util.List;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.interfaces.RepositorioProdutoInterface;;

public class RepositorioProdutos implements RepositorioProdutoInterface {
	
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

	public void cadastrarProduto(Produto p) throws OJEException {

		int cont = 0;
		
		for(int x = 0 ; x < this.listaProdutos.size() ; x++)
		{
			if(this.listaProdutos.get(x).getCodigo().equals(p.getCodigo()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException(p.getCodigo());
		}
		else
		{
			this.listaProdutos.add(p);
		}
		
	}

	public Produto buscarProduto(String codigo) throws ONFException {

		Produto resultado = new Produto();

		int i = this.procurarIndiceP(codigo);

		if (i >= 0) {
			resultado = this.listaProdutos.get(i);
		}
		else
		{
			throw new ONFException(codigo);
		}

		return resultado;
	}

	public void removerProduto(String codigo) throws ONFException {

		Produto p = new Produto();
		p = this.buscarProduto(codigo);

		if (p.getCodigo() != null) {
			
			this.listaProdutos.remove(p);
		}

	}

	public void atualizarProdutos(Double newvalor, String codigo) throws ONFException {

		Produto p = new Produto();
		p = this.buscarProduto(codigo);

		if(p.getCodigo() != null)
		{
			p.setValor(newvalor);
		}
		
		
	}

	public boolean existeProduto(String codigo) {


		boolean resultado = false;

		for (Produto produto : listaProdutos) {
			if (produto.getCodigo().equals(codigo)) {
				resultado = true;
			}
		}

		return resultado;
	}

	public int procurarIndiceP(String codigo) {

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