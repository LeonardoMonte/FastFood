package br.ufrpe.fastFood.beans;

import java.time.LocalDate;

public class PromocaoCombo extends Promocao{
	
	private Combo combo;
	
	
	public PromocaoCombo(String idPromocao , LocalDate diapromo, Combo combo)
	{
		super(idPromocao , diapromo);
		this.combo = combo;
	}
	
	public PromocaoCombo() {
		super();
	}

	public void AlterarpreçoCombo(double newprice)
	{
		this.combo.setValorPromo(newprice);
	}

}
