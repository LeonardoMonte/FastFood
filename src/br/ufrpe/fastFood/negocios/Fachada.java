package br.ufrpe.fastFood.negocios;

public class Fachada {
	
	private GerenciadorClientes gerencliente = new GerenciadorClientes();
	private GerenciadorFuncionarios gerenfunc = new GerenciadorFuncionarios();
	private GerenciadorProdutos gerenprodutos = new GerenciadorProdutos();
	private GerenciadorVendas gerenvendas = new GerenciadorVendas();
	private GerenciadorCombos gerencombos = new GerenciadorCombos();
	private GerenciadorPromocoes gerenpromocoes  = new GerenciadorPromocoes();
	
	public Fachada()
	{
		this.gerencliente = new GerenciadorClientes();
		this.gerenfunc = new GerenciadorFuncionarios();
		this.gerenprodutos = new GerenciadorProdutos();
		this.gerenvendas = new GerenciadorVendas();
		
		
	}
	
	
	
}
