package br.ufrpe.fastFood.beans;

public class Cliente extends Pessoa {

	private Endereco endere;
	private String senha;
	private String email;

	public Cliente(String nome, String id, String dataDeNascimento, Endereco endere, String senha, String email) {
		
		super(nome, id, dataDeNascimento);

		this.endere = endere;
		this.setSenha(senha);
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

	private void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean alterarSenha(String senha){
		boolean retorno =  false;
		if(senha == this.getSenha()){
			this.setSenha(senha);
			retorno =  true;
		}
		return retorno;
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
					this.getDataDeNascimento().equals(c.getDataDeNascimento()) && 
					this.getSenha().equals(c.getSenha()));
		}
		
		return retorno;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n============================\n");
		buffer.append("Nome: " +this.getNome()+ "\n");
		buffer.append("\nCPF: " + this.getId());
		buffer.append("\nData de Nasc.: " + this.getDataDeNascimento());
		buffer.append("\nEmail: " + this.getEmail());
		buffer.append("\n" + this.endere.toString());
		
		
		return buffer.toString();
	}

}
