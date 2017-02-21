package br.ufrpe.fastFood.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.interfaces.RepositorioVendaInterface;

public class RepositorioVendas implements RepositorioVendaInterface{

	private static RepositorioVendas instancia;
	private ArrayList <Venda> listaVendas;
	
	private RepositorioVendas()
	{
		this.listaVendas = new ArrayList<>();
	}
	
	public static RepositorioVendas getInstancia(){
		if(instancia == null){
			instancia = new RepositorioVendas();
		}
		return instancia;
	}

	
	public void cadastrarVenda(Venda v)
	{
		if( v.getIdVenda() != null)
		{
			this.listaVendas.add(v);
		}
		
	}
	
	public Venda buscarVenda(String idVenda) throws ONFException
	{
		
		Venda v = new Venda();
		
		int i = this.procurarIndiceV(idVenda);

		if( i >= 0 )
		{		
			v = this.listaVendas.get(i);
		}
		else
		{
			throw new ONFException(idVenda);
		}
	
		return v;
	}

	public void removerVenda(String idVenda) throws ONFException
	{
		
		Venda v = new Venda();
		v = this.buscarVenda(idVenda);
		
		if(v.getIdVenda() != null)
		{
			this.listaVendas.remove(v);
		}
			
	}


	public List<Venda> listarVendas()
	{

		return this.listaVendas;
	}
	
	public int procurarIndiceV(String idVenda)
	{
		// Função que procura indice especifico , enxugando os codigos de remover e adicionar
		
		int cont = -1; 

		for( int x = 0 ; x < this.listaVendas.size() ; x++)
		{
			if( this.listaVendas.get(x).getIdVenda().equals(idVenda))
			{
				cont = x;
			}
		}
		return cont;
	}
	
	
	
	//AREA DE PERSISTENCIA DE DADOS

	private static RepositorioVendas load(){
		RepositorioVendas repVendas =  null;

		File arquivoVenda = new File("RepositorioVendas.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoVenda);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repVendas = (RepositorioVendas) o;

		}catch(Exception e){
			repVendas = new RepositorioVendas();
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

		return repVendas;
	}


	public void save(){
		if(instancia == null){
			return;
		}

		File arquivoVendas = new File("RepositorioVendas.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoVendas.exists())
				arquivoVendas.createNewFile();

			fOutput = new FileOutputStream(arquivoVendas);
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
