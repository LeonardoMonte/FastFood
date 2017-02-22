package src.br.ufrpe.fastFood.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import src.br.ufrpe.fastFood.beans.Produto;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.interfaces.RepositorioProdutoInterface;;

public class RepositorioProdutos implements RepositorioProdutoInterface, Serializable {
	
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
	
	//AREA DE PERSISTENCIA DE DADOS

	private static RepositorioProdutos load(){
		RepositorioProdutos repProdutos =  null;

		File arquivoProduto = new File("RepositorioProdutos.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoProduto);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repProdutos = (RepositorioProdutos) o;

		}catch(Exception e){
			repProdutos = new RepositorioProdutos();
		}finally{
			if (oInput != null){
				try{
					oInput.close();
				}catch(IOException e){
					System.out.println("Não foi possível fechar o arquivo!");
					e.printStackTrace();
				}
			}
		}

		return repProdutos;
	}


	public void save(){
		if(instancia == null){
			return;
		}

		File arquivoProdutos = new File("RepositorioProdutos.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoProdutos.exists())
				arquivoProdutos.createNewFile();

			fOutput = new FileOutputStream(arquivoProdutos);
			oOutput = new ObjectOutputStream(fOutput);
			oOutput.writeObject(instancia);

		}catch(Exception e){
			e.printStackTrace();

		}finally{
			if(oOutput != null){
				try{

					oOutput.close();

				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}