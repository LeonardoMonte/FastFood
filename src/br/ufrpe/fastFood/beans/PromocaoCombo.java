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



}
