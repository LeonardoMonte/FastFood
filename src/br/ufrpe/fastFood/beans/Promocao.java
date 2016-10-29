package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public abstract class Promocao  {
	
	private String idPromocao;
	private LocalDate DiaPromo;
	private double valor;
	
	public Promocao(String idPromocao, LocalDate diaPromo) {
		this.idPromocao = idPromocao;
		DiaPromo = diaPromo;
	}
	
	public Promocao() {
	
	}

	public String getIdPromocao() {
		return idPromocao;
	}
	
	public double getValor()
	{
		return this.valor;
	}
	
	public void setValor(double valor)
	{
		this.valor = valor;
	}
	
	
	public LocalDate getDiaPromo() {
		return DiaPromo;
	}
	
	public void setDiaPromo(LocalDate diaPromo) {
		DiaPromo = diaPromo;
	}
	
	public void setIdPromocao(String idPromocao)
	{
		this.idPromocao = idPromocao;
	}
	

	
	public boolean equals(Promocao otherPromo){
		boolean resultado = false;
		if (otherPromo != null){
			resultado = (this.idPromocao.equals(otherPromo.idPromocao)
					&& this.DiaPromo.equals(otherPromo.DiaPromo));
		}
		return resultado;
	}
	
//	public String toString(){
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("Promoçao: "+ this.getIdPromocao() +"\n");
//		buffer.append("Produto: " + this.produto.getNome() + "\n");
//		buffer.append("Valor" + this.produto.getValor());
//				
//		return buffer.toString();
//	}
}
