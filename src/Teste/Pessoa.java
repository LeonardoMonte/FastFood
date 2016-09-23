package Teste;
public class Pessoa {

	private String nome;
	private String id;
	private String dataDeNAscimento;
	
	public Pessoa(String nome, String id, String dataDeNAscimento) {
		super();
		this.nome = nome;
		this.id = id;
		this.dataDeNAscimento = dataDeNAscimento;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "Nome = " + nome + ", ID = " + id;
	}	
}
