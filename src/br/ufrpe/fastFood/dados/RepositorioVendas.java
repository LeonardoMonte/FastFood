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
		if( v != null)
		{
			this.listaVendas.add(v);
		}
		
	}
	
	public Venda buscarVenda(String idVenda)
	{
		
		Venda resultado = new Venda();
		
		int i = this.procurarIndiceV(idVenda);

		if( i >= 0 )
		{		
			resultado = this.listaVendas.get(i);
		}
	
		return resultado;
	}

	public boolean removerVenda(String idVenda)
	{
		
		boolean resultado = false;
		Venda rresultado = new Venda();
		int i = this.procurarIndiceV(idVenda);
		
			if( i >= 0)
			{
				rresultado = this.listaVendas.get(i);	
				this.listaVendas.remove(rresultado);
				resultado = true;
			}	
			
		return resultado;
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
	
	public boolean existeVenda(String idVenda)
	{
		// FUNÇÃO PARA CHECAR SE JA EXISTE UMA VENDA COM ESSE CODIGO
		
		boolean resultado = false;
		
		for(Venda venda:listaVendas)
		{
			if( venda.getIdVenda().equals(idVenda))
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean existeIndiceV(int ind)
	{
		// FUNÇÃO PARA CHEGAR SE EXISTE ALGO NAQUELA POSIÇÃO EXPECIFICA( MEIO NOSENSE MAS TEM UMA UTILIDADE)
		boolean resultado = false;
		
		if( this.listaVendas.get(ind) != null)
		{
			resultado = true;
		}
		
		return resultado;
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
