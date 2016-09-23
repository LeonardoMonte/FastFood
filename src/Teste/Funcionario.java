package Teste;
public class Funcionario {

	private Pessoa funcionario;
	private Endereco endere;
	private String senha;
	
	
	public Funcionario(String nome, String id, String rua, int numero, String bairro, String cidade, String estado, String telefone, String senha) {

		this.funcionario.setNome(nome);
		this.funcionario.setId(id);
		this.endere.setRua(rua);
		this.endere.setNumero(numero);
		this.endere.setBairro(bairro);
		this.endere.setCidade(cidade);
		this.endere.setEstado(estado);
		this.endere.setTelefone(telefone);
		this.senha = senha;
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

	@Override
	public String toString() {
		return "Funcionario [funcionario=" + funcionario + ", endere=" + endere + ", senha=" + senha + "]";
	}


	
}
