public class Cliente {

	private Pessoa cliente;
	private Endereco endere;
	private String senha;
	private String email;
	
	public Cliente(Pessoa cliente, Endereco endere, String senha, String email) {
		super();
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

	public String toString() {
		return "cliente = " + cliente + ", endere = " + endere + ", senha = " + senha + ", email = " + email;
	}
	
	
	
	
}
