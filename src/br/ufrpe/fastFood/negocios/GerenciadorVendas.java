package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.dados.RepositorioVendas;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;

public class GerenciadorVendas {

	private RepositorioVendas repositorio;

	public GerenciadorVendas() {
		this.repositorio = RepositorioVendas.getInstancia();

	}

	public void cadastrar(Venda a) {
		if (a == null) {
			throw new ObjectNotFound("Impossivel fazer o cadastro de uma venda sem dados");

		} else if (this.repositorio.existeVenda(a.getIdVenda())) {
			throw new ObjectFound("Venda j� cadastrada no sistema");

		} else {
			this.repositorio.cadastrarVenda(a);
		}
	}

	public void remover(String idVenda) {
		Venda a = new Venda();
		a = this.procurar(idVenda);

		boolean Final = this.repositorio.removerVenda(a.getIdVenda());

		if (Final == false) {
			throw new ObjectNotFound("Cliente n�o cadastrado no sistema");
		}

	}

	public Venda procurar(String idVenda) {
		return this.repositorio.buscarVenda(idVenda);

	}


	public List<Venda> listarVendas() {
		if (this.repositorio.existeIndiceV(0) == false) {
			throw new ObjectNotFound("N�o existe nada a ser listado");

		} else {
			return this.repositorio.listarVendas();
		}
	}
	
	public void realizarPedido(){
		
	}
}
