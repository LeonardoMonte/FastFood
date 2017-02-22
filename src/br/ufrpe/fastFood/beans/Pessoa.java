package src.br.ufrpe.fastFood.beans;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8703396761104806750L;
	private String nome;
	private String id;
	private String dataDeNascimento;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private int numero;
	private String telefone;

	public Pessoa(String nome, String id, String dataDeNascimento, String rua, String bairro, String cidade, String estado, int numero, String telefone) {
		this.nome = nome;
		this.id = id;
		this.dataDeNascimento = dataDeNascimento;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
