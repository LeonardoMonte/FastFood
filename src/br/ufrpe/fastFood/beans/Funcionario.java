package br.ufrpe.fastFood.beans;

public class Funcionario extends Pessoa {

	private Endereco endere;
	private String senha;

	public Funcionario(String nome, String id, String dataDeNascimento, Endereco endere, String senha) {

		super(nome, id, dataDeNascimento);
		this.endere = endere;
		this.setSenha(senha);
	}
	
	public Funcionario(){
		super();
	}
	

	public Endereco getEndere() {
		return endere;
	}

	public void setEndere(Endereco endere) {
		this.endere = endere;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean equals(Funcionario f){
		boolean retorno = false;
		if (f != null){
			retorno = (this.getId().equals(f.getId()));
		}
		return retorno;
	}

	@Override
	public String toString() {
		return "\n***************\nFuncinario\nNome:" + this.getNome() + "\n"
				+ "Id: " + this.getId();
	}

}
