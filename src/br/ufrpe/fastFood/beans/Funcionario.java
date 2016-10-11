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

	private void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean alterarSenha(String oldsenha ,  String newsenha){
		boolean retorno =  false;
		if( this.senha.equals(oldsenha)){
			this.setSenha(newsenha);
			retorno =  true;
		}
		return retorno;
	}
	
	public boolean equals(Funcionario f){
		boolean retorno = false;
		if (f != null){
			retorno = (this.getId().equals(f.getId()));
		}
		return retorno;
	}
	
	public boolean equalsSenhaFunc(String id, String senha){
		
		boolean retorno = false;
		
		if(id != null && senha != null){
			if(id.equals(super.getId()) && senha.equals(this.senha)){
				
				retorno = true;
			}
		}
		
		return retorno;
	}

	@Override
	public String toString() {
		return "\n***************\nFuncinario\nNome:" + this.getNome() + "\n"
				+ "Id: " + this.getId();
	}

}
