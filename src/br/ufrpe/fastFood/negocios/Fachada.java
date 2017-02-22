	package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;

import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;
import br.ufrpe.fastFood.exceptions.WPException;

public class Fachada {

	private static Fachada instancia;

	private GerenciadorClientes gerencliente ;
	private GerenciadorFuncionarios gerenfunc; 
	private GerenciadorProdutos gerenprodutos; 
	private GerenciadorVendas gerenvendas;
	private GerenciadorCombos gerencombos ;


	private Fachada()
	{
		this.gerencliente = GerenciadorClientes.getInstancia();
		this.gerenfunc = GerenciadorFuncionarios.getInstancia();
		this.gerenprodutos = GerenciadorProdutos.getInstancia();
		this.gerenvendas = GerenciadorVendas.getInstancia();
		this.gerencombos = GerenciadorCombos.getInstancia();

	}

	public static Fachada getInstancia(){
		if (instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}


	// FUNCOES DO GERENCIADOR DE CLIENTE 
	
	public RepositorioProdutos getProdutos()
	{
		return RepositorioProdutos.getInstancia();
		
	}
	
	public void cadastrarCliente(Cliente a) throws OJEException
	{
		this.gerencliente.cadastrar(a);
	}

	public void removerCliente(String id) throws ONFException {

		this.gerencliente.remover(id);		

	}

	public Cliente procurarCliente(String id) throws ONFException {

		return this.gerencliente.procurar(id);

	}

	public void atualizarClienteendereco(String id, Endereco a) throws ONFException {

		this.gerencliente.atualizarClienteendereco(id, a);

	}

	public List<Cliente> listarClientes() {

		return this.gerencliente.listarClientes();

	}

	public boolean loginCliente(String id, String senha) throws ONFException, WPException {

		return this.gerencliente.loginCliente(id, senha);
	}

	public void alterarSenhaCliente(String id, String senhaold, String senhanew) throws ONFException, WPException {

		this.gerencliente.alterarSenha(id, senhaold, senhanew);

	}

	public String nomeCliente(String id){

		return this.gerencliente.nomeCliente(id);

	}


	// INICIO DAS FUNCOES DE GERENCIAMENTO DE FUNC

	public void cadastrarFuncionario(Funcionario a) throws OJEException {

		this.gerenfunc.cadastrar(a);

	}

	public void removerFuncionario(String id) throws ONFException {

		this.gerenfunc.remover(id);

	}

	public Funcionario procurarFuncionario(String id) throws ONFException {

		return this.gerenfunc.procurar(id);

	}

	public void atualizarFuncionario(String id, Endereco ende) throws ONFException {

		 this.gerenfunc.atualizarFuncionario(id, ende);

	}

	public List<Funcionario> listarFuncionarios() {

		return this.gerenfunc.listarFuncionarios();

	}

	public boolean loginFuncionario(String id, String senha) throws ONFException, WPException {

		return this.gerenfunc.loginFuncionario(id, senha);

	}



	public void alterarSenhaFuncionario(String id, String senhaold, String senhanew) throws ONFException, WPException {

		this.gerenfunc.alterarSenha(id, senhaold, senhanew);

	}
	
	public boolean loginAdmin(String id, String senha) throws ONFException, WPException
	{
		return this.gerenfunc.loginAdmin(id, senha);
	}

	// INICIO DAS FUNCOES DE GERENCIAMENTO DE PRODUTOS

	public void cadastrarProduto(Produto a) throws OJEException {

		this.gerenprodutos.cadastrar(a);

	}

	public void removerProduto(String codigo) throws ONFException{

		this.gerenprodutos.remover(codigo);

	}

	public Produto procurarProduto(String codigo) throws ONFException {

		return this.gerenprodutos.procurar(codigo);

	}

	public void atualizarProduto(Double newvalor, String produtoalterado) throws ONFException {

		this.gerenprodutos.atualizarProduto(newvalor, produtoalterado);

	}

	public List<Produto> listarProdutos() {

		return this.gerenprodutos.listarProdutos();

	}

	public boolean existeProduto(String codigo)
	{
		return this.gerenprodutos.existeProduto(codigo);
	}

	// INICIO DAS FUNCOES DE GERENCIAMENTO DE VENDAS

	public void cadastrarVenda(Venda a) {

		this.gerenvendas.cadastrar(a);

	}

	public void removerVenda(String idVenda) throws ONFException {

		this.gerenvendas.remover(idVenda);

	}

	public Venda procurarVenda(String idVenda) throws ONFException {

		return this.gerenvendas.procurar(idVenda);

	}

	public List<Venda> listarVendas() {

		return this.gerenvendas.listarVendas();

	}

	// INICIO DAS FUNCOES DE GERENCIAMENTO DE COMBOS


	public void cadastrarCombo(Combo a) throws OJEException
	{		

		this.gerencombos.cadastrarCombo(a);

	}

	public void removerCombo(String codigo) throws ONFException
	{
		this.gerencombos.removerCombo(codigo);
	}
	
	public void atualizarCombo(String codigo , double valor) throws ONFException
	{
		this.gerencombos.atualizarCombo(codigo, valor);
	}

	public List<Combo> listarCombos()
	{
		return this.gerencombos.listarCombos();
	}

	public Combo procurarCombo(String codigo) throws ONFException
	{
		return this.gerencombos.procurarCombo(codigo);

	}




	// end da fachada



}
