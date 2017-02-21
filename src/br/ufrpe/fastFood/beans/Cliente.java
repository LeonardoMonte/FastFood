package br.ufrpe.fastFood.beans;

import java.io.Serializable;

import br.ufrpe.fastFood.exceptions.WPException;

public class Cliente extends Pessoa  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8333710358678744626L;
	private Endereco endere;
	private String senha;
	private String email;

	public Cliente(String nome, String id, String dataDeNascimento, Endereco endere, String senha, String email) {
		
		super(nome, id, dataDeNascimento);

		this.endere = endere;
		this.setSenha(senha);
		this.email = email;
	}
	
	public Cliente()
	{
		super();
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
	
	public void alterarSenha(String oldsenha ,  String newsenha) throws WPException{

		if( this.senha.equals(oldsenha)){
			this.setSenha(newsenha);
		}
		else
		{
			throw new WPException(oldsenha);
		}

	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean equalsSenhaCliente( String senha) throws WPException{
		
		boolean resultado = false;
		if( senha != null){
			if(senha.equals(this.senha)){
				resultado = true;
			}
			else
			{
				throw new WPException(senha);
			}
		}
	
		return resultado;

	}
	
	public boolean equalsSenhaOnly(String senha)
	{
		boolean resultado = false;
		
		if( senha != null )
		{
			resultado = senha.equals(this.senha);
		}
		
		return resultado;
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
