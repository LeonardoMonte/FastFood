package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public class Promocao  {
	
	private String idPromocao;
	private Produto produto;
	private LocalDate DiaPromo;
	public Promocao(String idPromocao, Produto produto, LocalDate diaPromo) {
		this.idPromocao = idPromocao;
		this.produto = produto;
		DiaPromo = diaPromo;
	}
	
	public String getIdPromocao() {
		return idPromocao;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public LocalDate getDiaPromo() {
		return DiaPromo;
	}
	
	public void setDiaPromo(LocalDate diaPromo) {
		DiaPromo = diaPromo;
	}
	
	public void alterarPreco(double novoPreco){
		this.produto.setValor(novoPreco);
	}
	
	public boolean equals(Promocao otherPromo){
		boolean resultado = false;
		if (otherPromo != null){
			resultado = this.idPromocao.equals(otherPromo.idPromocao)
					&& this.produto.equals(otherPromo.produto);
		}
		return resultado;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Promoçao: "+ this.getIdPromocao() +"\n");
		buffer.append("Produto: " + this.produto.getNome() + "\n");
		buffer.append("Valor" + this.produto.getValor());
				
		return buffer.toString();
	}
}
