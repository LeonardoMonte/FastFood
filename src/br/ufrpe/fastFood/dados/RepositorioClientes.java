package br.ufrpe.fastFood.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.interfaces.RepositorioClienteInterface;

public class RepositorioClientes implements RepositorioClienteInterface, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9194850249791978238L;
	private static RepositorioClientes instancia;
	private ArrayList<Cliente> listaClientes;

	private RepositorioClientes(){

		listaClientes = new ArrayList<>();
	}

	public static RepositorioClientes getInstancia(){

		if(instancia == null){
			instancia = RepositorioClientes.load();
		}

		return instancia;
	}

	public void cadastrarCliente(Cliente c) throws OJEException {
		int cont = 0;

		for(int x = 0 ; x < this.listaClientes.size() ; x++)
		{
			if(this.listaClientes.get(x).getId().equals(c.getId()))
			{
				cont++;
			}
		}

		if(cont > 0)
		{
			throw new OJEException( c.getId());
		}
		else
		{
			this.listaClientes.add(c);
		}


	}

	public Cliente buscarCliente(String id) throws ONFException{

		Cliente resultado = new Cliente();

		int i = this.procurarIndice(id);

		if(i >= 0 ){	

			resultado = this.listaClientes.get(i);
		}
		else
		{
			throw new ONFException(id);
		}

		return resultado;
	}

	public void removerCliente(String id) throws ONFException{	

		Cliente c = new Cliente();
		c = this.buscarCliente(id);

		if (c.getId() != null) {

			this.listaClientes.remove(c);
		}
	}


	public void atualizarClienteendereco(String id , Endereco ende) throws ONFException{	

		Cliente c = new Cliente();
		c = this.buscarCliente(id);

		if(c.getId() != null)
		{
			c.setEndere(ende);
		}
	} 

	public List<Cliente> listarClientes(){

		return this.listaClientes;
	}



	public int procurarIndice(String id){

		int cont = -1; 

		for( int x = 0 ; x < this.listaClientes.size() ; x++){

			if( this.listaClientes.get(x).getId().equals(id)){

				cont = x;
			}
		}
		return cont;
	}

	public boolean loginCliente(String id , String senhanew) throws  ONFException, WPException{	

		boolean b = false;
		Cliente c = new Cliente();
		c = this.buscarCliente(id);		
		if(c.getId() != null)
		{

			b = c.equalsSenhaCliente(senhanew);		

		}
		return b;
	}

	public void alterarsenha(String id , String senhaold , String senhanew) throws ONFException , WPException{

		Cliente c = new Cliente();
		c = this.buscarCliente(id);		
		if(c.getId() != null)
		{
			c.alterarSenha(senhaold, senhanew);
		}


	}

	public String getNomecliente(String id){

		Cliente c = new Cliente();
		int x = this.procurarIndice(id);
		c = this.listaClientes.get(x);

		return c.getNome();
	}


	//AREA DE PERSISTENCIA DE DADOS

	private static RepositorioClientes load(){
		RepositorioClientes repClientes =  null;

		File arquivoCliente = new File("RepositorioClientes.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoCliente);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repClientes = (RepositorioClientes) o;

		}catch(Exception e){
			repClientes = new RepositorioClientes();
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

		return repClientes;
	}


	public void save(){
		if(instancia == null){
			return;
		}

		File arquivoClientes = new File("RepositorioClientes.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoClientes.exists())
				arquivoClientes.createNewFile();

			fOutput = new FileOutputStream(arquivoClientes);
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
