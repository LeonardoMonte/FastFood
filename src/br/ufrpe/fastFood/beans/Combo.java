package br.ufrpe.fastFood.beans;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.PNEException;

public class Combo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3598850666530445744L;
	private Produto p1;
	private Produto p2;
	private Produto p3;
	private String nome;
	private double valor;
	private String codigo;
	

	public Combo(String nome,  String codigo, Produto p1 , Produto p2 , Produto p3){
		this.nome = nome;
		this.codigo = codigo;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.valor = p1.getValor() + p2.getValor() + p3.getValor();
		
	}

	
	
	public Produto getP1() {
		return p1;
	}



	public void setP1(Produto p1) {
		this.p1 = p1;
	}



	public Produto getP2() {
		return p2;
	}



	public void setP2(Produto p2) {
		this.p2 = p2;
	}



	public Produto getP3() {
		return p3;
	}



	public void setP3(Produto p3) {
		this.p3 = p3;
	}



	public Combo() {
		// TODO Auto-generated constructor stub
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


	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

			
		public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Combo: " + this.getNome() + "\n");
		buffer.append("Codigo: " + this.getCodigo() + "\n");
		buffer.append("Valor: " + this.getValor() + "\n");
		return buffer.toString();
	}
			
	

}
