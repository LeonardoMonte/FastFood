package br.ufrpe.fastFood.beans;

import java.io.Serializable;

public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1769724232777567108L;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private int numero;
	private String telefone;

	public Endereco(String rua, String bairro, String cidade, String estado, int numero, String telefone) {

		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.telefone = telefone;
	}

	public Endereco() {
		
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
	
	public boolean equals(Endereco e){
		boolean retorno  = false;
		if(e != null){
			retorno = (this.rua.equals(e.rua) && this.numero == e.numero
						&& this.bairro.equals(e.bairro) && this.cidade.equals(e.cidade)
						 && this.telefone.equals(e.telefone));
		}
		return retorno;
	}

	public String toString() {
		StringBuffer buffer =  new StringBuffer();
		
		
		buffer.append("\n       ENDEREÇO      \n");
		buffer.append("Rua: " + this.getRua() + ", nº " + this.getNumero());
		buffer.append("\nBairro: " + this.getBairro());
		buffer.append("\nCidade: " + this.getCidade());
		buffer.append("\nEstado: " + this.getEstado());
		buffer.append("\nFone: " + this.getTelefone());
		
		buffer.append("\n============================\n");
		
		return buffer.toString();
	}



}
