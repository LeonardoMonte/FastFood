package br.ufrpe.fastFood.beans;

public class Cliente extends Pessoa {

	private Endereco endere;
	private String senha;
	private String email;

	public Cliente(String nome, String id, String dataDeNascimento, Endereco endere, String senha, String email) {
		
		super(nome, id, dataDeNascimento);

		this.endere = endere;
		this.senha = senha;
		this.email = email;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean equals(Cliente c){
		boolean retorno =  false;
		
		if (c != null){
			retorno = (this.getId().equals(c.getId()) &&
					this.getNome().equals(c.getNome()) &&
					this.getEmail().equals(c.getEmail()) &&
					this.getDataDeNascimento().equals(c.getDataDeNascimento()));
		}
		
		return retorno;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n============================\n");
		buffer.append("Nome: " + "\n");
		buffer.append(this.getNome());
		buffer.append("\nCPF: " + this.getId());
		buffer.append("\nEmail: " + this.getEmail());
		buffer.append(this.endere.toString());
		
		
		return buffer.toString();
	}

}
