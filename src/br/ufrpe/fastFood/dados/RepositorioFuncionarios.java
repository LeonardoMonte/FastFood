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

import br.ufrpe.fastFood.beans.Admin;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.interfaces.RepositorioFuncionarioInterface;

public class RepositorioFuncionarios implements RepositorioFuncionarioInterface, Serializable  {
	private static RepositorioFuncionarios instancia;
	private ArrayList<Funcionario> listaFuncionarios;

	private RepositorioFuncionarios() {
		this.listaFuncionarios = new ArrayList<>();
	}

	public static RepositorioFuncionarios getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioFuncionarios();
		}

		return instancia;
	}

	public void cadastrarFuncionario(Funcionario f) throws OJEException {

		int cont = 0;
		
		for(int x = 0 ; x < this.listaFuncionarios.size() ; x++)
		{
			if(this.listaFuncionarios.get(x).getId().equals(f.getId()))
			{
				cont++;
			}
		}
		
		if(cont > 0)
		{
			throw new OJEException( f.getId());
		}
		else
		{
			this.listaFuncionarios.add(f);
		}
				
		
		
	}

	public Funcionario buscarFuncionario(String id) throws ONFException {

		Funcionario resultado = null;

		int i = this.procurarIndiceF(id);

		if (i >= 0) {
			resultado = this.listaFuncionarios.get(i);
		}
		else
		{
			throw new ONFException(id);
		}

		return resultado;

	}

	public void atualizarFuncionarioendereco(String id, Endereco ende) throws ONFException {

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		
		if( f.getId() != null)
		{
			f.setEndere(ende);
			
		}
		
	
	}

	public void removerFuncionario(String id) throws ONFException{

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		
		if( f.getId() != null)
		{
			this.listaFuncionarios.remove(f);
			
		}
	}

	public List<Funcionario> listarFuncinario() {

		return this.listaFuncionarios;
	}


	public int procurarIndiceF(String id) {

		int cont = -1;

		for (int x = 0; x < this.listaFuncionarios.size(); x++) {
			if (this.listaFuncionarios.get(x).getId().equals(id)) {
				cont = x;
			}
		}
		return cont;
	}

	public boolean loginFunc(String id, String senha) throws ONFException, WPException{

		boolean b = false;
		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);		
		if(f.getId() != null)
		{

			b = f.equalsSenhaFunc(senha);

		}
		return b;
	}
	
	public boolean loginAdmin(String id, String senha) throws ONFException, WPException{

		boolean b = false;
		Admin a = new Admin();
		a = (Admin) this.buscarFuncionario(id);		
		if(a.getId() != null)
		{

			b = a.equalsSenhaFunc(senha);

		}
		return b;
	}


	public void alterarsenha(String id, String senhaold, String senhanew) throws ONFException, WPException {

		Funcionario f = new Funcionario();
		f = this.buscarFuncionario(id);
		if(f.getId() != null)
		{
			f.alterarSenha(senhaold, senhanew);
		}
	}
	
	//AREA DE PERSISTENCIA DE DADOS

	private static RepositorioFuncionarios load(){
		RepositorioFuncionarios repFuncionarios =  null;

		File arquivoFuncionario = new File("RepositorioFuncionarios.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoFuncionario);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repFuncionarios = (RepositorioFuncionarios) o;

		}catch(Exception e){
			repFuncionarios = new RepositorioFuncionarios();
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

		return repFuncionarios;
	}


	public void save(){
		if(instancia == null){
			return;
		}

		File arquivoFuncionario = new File("RepositorioFuncionarios.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoFuncionario.exists())
				arquivoFuncionario.createNewFile();

			fOutput = new FileOutputStream(arquivoFuncionario);
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
