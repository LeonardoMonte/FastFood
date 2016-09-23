public class Produto {
	
	private String nome;
	private double valor;
	private String codigo;
	
	public Produto(String nome, double valor, String codigo) {
		
		this.nome = nome;
		this.valor = valor;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + ", codigo=" + codigo + "]";
	}
}
