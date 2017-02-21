package br.ufrpe.fastFood.beans;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8703396761104806750L;
	private String nome;
	private String id;
	private String dataDeNascimento;

	public Pessoa(String nome, String id, String dataDeNascimento) {
		this.nome = nome;
		this.id = id;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Pessoa(){
		
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataDeNascimento(){
		return this.dataDeNascimento;
	}
	
	public void setDataDeNascimento(String data){
		this.dataDeNascimento = data;
	}
	
	public boolean equals(Pessoa p){
		boolean retorno = false;
		if (p != null){
			
			retorno = (this.nome.equalsIgnoreCase(p.nome) && this.id.equals(p.id));
		}
		return retorno;		
	}

	public String toString() {
		return "Nome = " + nome + ", ID = " + id;
	}
}
