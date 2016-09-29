package br.ufrpe.fastFood.beans;

public class Servicos {
	private String nome;
	private String idServico;
	
	public Servico(String nome, String idServico){
		this.setNome(nome)
		this.setIdServico(idServico);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdServico() {
		return idServico;
	}
	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}
	
	
	
}
