package br.ufrpe.fastFood.beans;

import java.io.Serializable;

import br.ufrpe.fastFood.exceptions.WPException;

public class Funcionario extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1247262337104349358L;
	private Endereco endere;
	private String senha;

	public Funcionario(String nome, String id, String dataDeNascimento, Endereco endere, String senha) {

		super(nome, id, dataDeNascimento);
		this.endere = endere;
		this.setSenha(senha);
	}
	
	public Funcionario(){
		super();
	}
	

	public Endereco getEndere() {
		return endere;
	}

	public void setEndere(Endereco endere) {
		this.endere = endere;
	}

	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void alterarSenha(String oldsenha ,  String newsenha) throws WPException{
		
		if( this.senha.equals(oldsenha)){
			this.setSenha(newsenha);
		}
		else
		{
			throw new WPException(oldsenha);
		}
	}
	
	public boolean equals(Funcionario f){
		boolean retorno = false;
		if (f != null){
			retorno = (this.getId().equals(f.getId()));
		}
		return retorno;
	}
	
	public boolean equalsSenhaFunc( String senha) throws WPException{
		
		boolean retorno = false;
		
		if(senha != null){
			if(senha.equals(this.senha)){
				
				retorno = true;
			}
			else
			{
				throw new WPException(senha);
			}
		}
		
		return retorno;
	}

	@Override
	public String toString() {
		return "\n***************\nFuncinario\nNome:" + this.getNome() + "\n"
				+ "Id: " + this.getId();
	}

}
