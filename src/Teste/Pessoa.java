package Teste;

public class Pessoa {

	private String nome;
	private String id;
	private String dataDeNascimento;

	public Pessoa(String nome, String id, String dataDeNascimento) {
		super();
		this.nome = nome;
		this.id = id;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(Pessoa p){
		boolean retorno = false;
		if (p != null){
			
			retorno = (this.nome.equalsIgnoreCase(p.nome) && this.id.equals(p.id) 
						&& this.dataDeNascimento.equals(p.dataDeNascimento));
		}
		return retorno;		
	}

	public String toString() {
		return "Nome = " + nome + ", ID = " + id;
	}
}
