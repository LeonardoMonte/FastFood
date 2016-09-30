package br.ufrpe.fastFood.beans;

public class Cliente extends Pessoa {

	private Pessoa cliente;
	private Endereco endere;
	private String senha;
	private String email;

	public Cliente(String nome, String id, String dataDeNascimento, Pessoa cliente, Endereco endere, String senha, String email) {
		
		super(nome, id, dataDeNascimento);

		this.cliente = cliente;
		this.endere = endere;
		this.senha = senha;
		this.email = email;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
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

	public String getEmail() {
		return email;
	}
	
	public boolean equals(Cliente c){
		boolean retorno =  false;
		
		if (c != null){
			retorno = (this.cliente.equals(c.cliente));
		}
		
		return retorno;
	}
	
	@Override
	public String toString() {
		return "cliente = " + cliente + ", endere = " + endere + ", senha = " + senha + ", email = " + email;
	}

}
