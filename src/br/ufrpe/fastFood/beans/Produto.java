package br.ufrpe.fastFood.beans;

import java.io.Serializable;

public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6094923781947475193L;
	private String nome;
	private double valor;
	private String codigo;

	public Produto(String nome, double valor, String codigo) {

		this.nome = nome;
		this.valor = valor;
		this.codigo = codigo;
	}
	
	public Produto(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public boolean equals(Produto p){
		boolean retorno = false;
		if (p != null){
			retorno = (this.codigo.equals(p.codigo) &&
						this.nome.equals(p.nome) && this.valor == p.valor);
		}
		return retorno;
	}

	public String toString() {
		StringBuffer buffer =  new StringBuffer();
		buffer.append(this.getNome());		
		return buffer.toString();
	}
}
