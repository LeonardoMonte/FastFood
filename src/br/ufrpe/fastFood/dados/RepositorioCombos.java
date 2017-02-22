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



import src.br.ufrpe.fastFood.beans.Combo;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.interfaces.RepositorioCombosInterface;



public class RepositorioCombos implements RepositorioCombosInterface, Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1601212855046938106L;

	private static RepositorioCombos instance;

	private ArrayList<Combo> listaCombos;

	

	private RepositorioCombos()

	{

		this.listaCombos = new ArrayList<>();

	}

	

	public static RepositorioCombos getInstance()

	{

		if(instance == null)

		{

			instance = new RepositorioCombos();

		}

		

		return instance;

	}

	

	

	public void cadastrar(Combo a) throws OJEException

	{

		int cont = 0;

		

		for(int x = 0 ; x <	this.listaCombos.size() ; x++)

		{

			if(this.listaCombos.get(x).getCodigo().equals(a.getCodigo()))

			{

				cont++;

			}

		}

		

		if(cont > 0)

		{

			throw new OJEException(a.getCodigo());

		}

		else

		{

			this.listaCombos.add(a);

		}

		

		

	}

	

	

	public void removerCombo(String codigo) throws ONFException
	{
		Combo c = new Combo();
		c = this.buscarCombo(codigo);
		this.listaCombos.remove(c);		

	}
	
	public void atualizarCombo(String codigo , double valor) throws ONFException
	{
		Combo c = new Combo();
		c = this.buscarCombo(codigo);
		if(c.getCodigo() != null)
		{
			c.setValor(valor);
		}
	}

	

	public Combo buscarCombo(String codigo) throws ONFException

	{

		Combo a = new Combo();

		

		int x = this.procurarIndiceC(codigo);

		

		if( x >= 0)

		{

			a = this.listaCombos.get(x);

		}

		else

		{

			throw new ONFException(codigo);

		}

		

		return a;

		

	}

	

	

	public int procurarIndiceC(String codigo) {

		

		int cont = -1;



		for (int x = 0; x < this.listaCombos.size(); x++) {

			if (this.listaCombos.get(x).getCodigo().equals(codigo)) {

				cont = x;

			}

		}

		return cont;

	}

	

	

	public List<Combo> listarCombos() {



		return this.listaCombos;

		

	}
	
	//AREA DE PERSISTENCIA DE DADOS

	private static RepositorioCombos load(){
		RepositorioCombos repCombos =  null;

		File arquivoCombo = new File("RepositorioCombos.dat");

		FileInputStream fInput = null;
		ObjectInputStream oInput = null;

		try{
			fInput = new FileInputStream(arquivoCombo);
			oInput = new ObjectInputStream(fInput);
			
			Object o = oInput.readObject();

			repCombos = (RepositorioCombos) o;

		}catch(Exception e){
			repCombos = new RepositorioCombos();
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

		return repCombos;
	}


	public void save(){
		if(instance == null){
			return;
		}

		File arquivoCombos = new File("RepositorioCombos.dat");
		FileOutputStream fOutput =  null;
		ObjectOutputStream oOutput = null;

		try{
			if(!arquivoCombos.exists())
				arquivoCombos.createNewFile();

			fOutput = new FileOutputStream(arquivoCombos);
			oOutput = new ObjectOutputStream(fOutput);
			oOutput.writeObject(instance);

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