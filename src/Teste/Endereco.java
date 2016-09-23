package Teste;
public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private int numero;
	private String telefone;
	
	
	public Endereco(String rua, String bairro, String cidade, String estado, int numero, String telefone) {

		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.telefone = telefone;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String toString() {
		return "rua = " + rua + ", bairro = " + bairro + ", cidade = " + cidade + ", estado = " + estado + ", numero = "
				+ numero + ", telefone = " + telefone;
	}
	
	//teste github2
	
}
