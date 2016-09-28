package Teste;

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
	
	public boolean equals(Produto p){
		boolean retorno = false;
		if (p != null){
			retorno = (this.codigo.equals(p.codigo) &&
						this.nome.equals(p.nome) && this.valor == p.valor);
		}
		return retorno;
	}

	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + ", codigo=" + codigo + "]";
	}
}
