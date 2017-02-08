package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;

public class Fachada {
	
	private GerenciadorClientes gerencliente ;
	private GerenciadorFuncionarios gerenfunc; 
	private GerenciadorProdutos gerenprodutos; 
	private GerenciadorVendas gerenvendas;
	private GerenciadorCombos gerencombos ;
	private GerenciadorPromocoes gerenpromocoes ;
	
	public Fachada()
	{
		this.gerencliente = GerenciadorClientes.getInstancia();
		this.gerenfunc = GerenciadorFuncionarios.getInstancia();
		this.gerenprodutos = GerenciadorProdutos.getInstancia();
		this.gerenvendas = GerenciadorVendas.getInstancia();
		this.gerencombos = GerenciadorCombos.getInstancia();
		this.gerenpromocoes = GerenciadorPromocoes.getInstancia();	
		
	}
	
	// FUNCOES DO GERENCIADOR DE CLIENTE 
	
	public void cadastrarCliente(Cliente a)
	{
		this.gerencliente.cadastrar(a);
	}
	
	public boolean removerCliente(String id) {

		return this.gerencliente.remover(id);		

	}
	
	public Cliente procurarCliente(String id) {
		
		return this.gerencliente.procurar(id);

	}
	
	public boolean atualizarClienteendereco(String id, Endereco a) {

		return this.gerencliente.atualizarClienteendereco(id, a);
	
	}
	
	public List<Cliente> listarClientes() {
		
		return this.gerencliente.listarClientes();

	}
	
	public boolean loginCliente(String id, String senha) {
		
		return this.gerencliente.loginCliente(id, senha);
	}
	
	public boolean alterarSenhaCliente(String id, String senhaold, String senhanew) {
		
		return this.gerencliente.alterarSenha(id, senhaold, senhanew);

	}
	
	public String nomeCliente(String id) {
		
		return this.gerencliente.nomeCliente(id);
		
	}
	
	public boolean existeC(String id) {
		
		return this.gerencliente.existeC(id);
		
	}
	
	// INICIO DAS FUNCOES DE GERENCIAMENTO DE FUNC
	
	public void cadastrarFuncionario(Funcionario a) {

		this.gerenfunc.cadastrar(a);
		
	}
	
	public boolean removerFuncionario(String id) {
		
		return this.gerenfunc.remover(id);

	}
	
	public Funcionario procurarFuncionario(String id) {
		
		return this.gerenfunc.procurar(id);

	}
	
	public boolean atualizarFuncionario(String id, Endereco ende) {

		return this.gerenfunc.atualizarFuncionario(id, ende);
		
	}
	
	public List<Funcionario> listarFuncionarios() {
		
		return this.gerenfunc.listarFuncionarios();

	}
	
	public boolean loginFuncionario(String id, String senha) {
		
		return this.gerenfunc.loginFuncionario(id, senha);
		
	}
	
	public boolean existeFuncionario(String id) {
		
		return this.gerenfunc.existe(id);
	
	}
	
	public boolean alterarSenhaFuncionario(String id, String senhaold, String senhanew) {
		
		return this.gerenfunc.alterarSenha(id, senhaold, senhanew);

	}
	
	// INICIO DAS FUNCOES DE GERENCIAMENTO DE PRODUTOS
	
	public void cadastrarProduto(Produto a) {

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
	
	public boolean removerVenda(String idVenda) {
		
		return this.gerenvendas.remover(idVenda);

	}
	
	public Venda procurarVenda(String idVenda) {
		
		return this.gerenvendas.procurar(idVenda);

	}
	
	public List<Venda> listarVendas() {
		
		return this.gerenvendas.listarVendas();
	
	}
	
	// INICIO DAS FUNCOES DE GERENCIAMENTO DE COMBOS
	
	
	public void cadastrarCombo(Combo a)
	{		
		
		this.gerencombos.cadastrarCombo(a);
					
	}
	
	public void removerCombo(String codigo) throws ONFException
	{
		this.gerencombos.removerCombo(codigo);
	}
	
	public List<Combo> listarCombos()
	{
		return this.gerencombos.listarCombos();
	}
	
	public Combo procurarCombo(String codigo) throws ONFException
	{
		return this.gerencombos.procurarCombo(codigo);
		
	}
	
	public void AdicionarProdutoAoCombo(Produto p ,String codigo) throws ONFException
	{

		this.gerencombos.AdicionarProduto(p, codigo);

	}
	
	public void RemoverProduto(Produto p ,String codigo) throws ONFException, PNEException
	{

		this.gerencombos.RemoverProduto(p, codigo);

	}
		
	
	// INICIO DAS FUNCOES DE GERENCIAMENTO DE PROMOCOES
	
	
	public void cadastrarPromoCombo(PromocaoCombo a)
	{
		
		this.gerenpromocoes.cadastrarCombo(a);
		
	}
	
	public void cadastrarPromoProduto(PromocaoProduto a)
	{
		
			this.gerenpromocoes.cadastrarProduto(a);
		
	}
	
	public PromocaoProduto buscarPromocaoProduto( String idPromocao)
	{
		return this.gerenpromocoes.buscarPromocaoProduto(idPromocao);
	}
	
	public PromocaoCombo buscarPromocaoCombo(String idPromocao)
	{
		return this.gerenpromocoes.buscarPromocaoCombo(idPromocao);
		
	}
	
	public boolean removerPromoCombo(String idPromocao)
	{
		return this.gerenpromocoes.removerCombo(idPromocao);
	}
	
	public boolean removerPromoProduto(String idPromocao)
	{
		return this.gerenpromocoes.removerProduto(idPromocao);
	}
	
	public List<PromocaoCombo> listarCombosPromotion()
	{
		return this.gerenpromocoes.listarCombosPromotion();
		
	}
	
	public List<PromocaoProduto> listarProdutoPromotion()
	{
		return this.gerenpromocoes.listarProdutoPromotion();
	}
	
	public boolean alterarPrecoPromoCombo(double newprice , String idPromocao)
	{
		return this.gerenpromocoes.alterarPrecoPromoCombo(newprice, idPromocao);
	}
	
	public boolean alterarPrecoPromoProduto(double newprice , String idPromocao)
	{
		return this.gerenpromocoes.alterarPrecoPromoProduto(newprice, idPromocao);
		
	}
	
	public boolean Existepromocombo(String codigo)
	{
		return this.gerenpromocoes.Existepromocombo(codigo);
	}
	
	public boolean Existepromoproduto(String codigo)
	{
		return this.gerenpromocoes.Existepromoproduto(codigo);
	}
	
	
	// end da fachada
	
	
	
}
