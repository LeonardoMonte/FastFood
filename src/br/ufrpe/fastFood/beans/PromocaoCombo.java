package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public class PromocaoCombo extends Promocao{
	
	private Combo combo;
	
	
	public PromocaoCombo(String idPromocao , LocalDate diapromo, Combo combo, double valor)
	{
		super(idPromocao , diapromo);
		this.combo = combo;
		this.setValor(valor);
		
	}
	
	public PromocaoCombo() {
		super();
	}

	public String toString(){
	StringBuffer buffer = new StringBuffer();
	buffer.append("Promoçao: "+ this.getIdPromocao() +"\n");
	buffer.append("Combo: " + this.combo.getNome() + "\n");
	buffer.append("Valor" + this.getValor() + "\n");
	buffer.append("Data de criacao: " + this.getDiaPromo() );
			
	return buffer.toString();
}


}
