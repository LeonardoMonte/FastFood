package br.ufrpe.fastFood.beans;

public class Admin {
	private String nome;
	private String id;
	private String codigoAdmin;
	private String senha;
	
	public Admin(String nome, String id, String codAdmin, String senha){
		
		this.nome = nome;
		this.id = id;
		this.codigoAdmin = codAdmin;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoAdmin() {
		return codigoAdmin;
	}

	public void setCodigoAdmin(String codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}
	
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equalsSenhaAdmin(String id, String senha){
		
		boolean retorno = false;
		
		if(id != null && senha != null){
			if(id.equals(this.id) && senha.equals(this.senha)){
				
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("\n      ADMIN\n\n");
		buffer.append("Nome: " + this.getNome() + "\n");
		buffer.append("CPF: " + this.getId() + "\n");
		buffer.append("Codigo Administrador: " + this.getCodigoAdmin() + "\n");
				
		return buffer.toString();
	}
	

}
