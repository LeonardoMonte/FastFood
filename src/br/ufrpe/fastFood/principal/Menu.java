
package br.ufrpe.fastFood.principal;
import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.Scanner;
import br.ufrpe.fastFood.beans.Admin;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.beans.PromocaoCombo;
import br.ufrpe.fastFood.beans.PromocaoProduto;
import br.ufrpe.fastFood.beans.Venda;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.PNEException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.negocios.Fachada;

public class Menu {

	public static void main(String[] args) {

		char opcao;
		int contFunc = 0, contCliente = 0, contProduto = 0, contVenda = 0 , contCombo = 0 , contPromoCombo = 0 , contPromoProduto = 0;

		String senha1 = "admin";
		String login = "admin";
		Admin admin = new Admin(null, login, null, null, senha1);
		try {
			Fachada.getInstancia().cadastrarFuncionario(admin);
		} catch (OJEException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out.println("-----------Seja Bem-vindo------------\n");
			System.out.println("1 - Auto Atendimento;");
			System.out.println("2 - Caixa;");
			System.out.println("3 - Encerrar.\n");
			System.out.print("Digite sua opcao: ");

			opcao = in.next().charAt(0);
			in.nextLine();

			switch (opcao) {

			case '1':

				int aux2 = 0;

				while (aux2 != 3) {

					System.out.println("-----------Auto Atendimento----------\n");
					System.out.println("1 - Cadastro;");
					System.out.println("2 - Login;");
					System.out.println("3 - Voltar;\n");
					System.out.print("Digite sua opcao: ");

					opcao = in.next().charAt(0);
					in.nextLine();

					switch (opcao) {

					case '1':

						System.out.print("------------Cadastro Cliente---------- \n");

						System.out.print("Nome: ");
						String nome = in.nextLine();

						System.out.print("CPF: ");
						String id = in.nextLine();

						System.out.print("Nascimento: ");
						String nascimento = in.nextLine();

						System.out.print("Rua: ");
						String rua = in.nextLine();

						System.out.print("Numero: ");
						int numero = in.nextInt();
						in.nextLine();

						System.out.print("Bairro: ");
						String bairro = in.nextLine();

						System.out.print("Cidade: ");
						String cidade = in.nextLine();

						System.out.print("Estado: ");
						String estado = in.nextLine();

						System.out.print("Telefone: ");
						String telefone = in.nextLine();

						System.out.print("Email: ");
						String email = in.nextLine();

						String senha;
						String senha2;

						do {

							System.out.print("Senha: ");
							senha = in.nextLine();

							System.out.print("Confime a Senha: ");
							senha2 = in.nextLine();

						} while ((senha.equals(senha2) != true));

						Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
						Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
						try {
							Fachada.getInstancia().cadastrarCliente(cliente1);
							contCliente++;
							
						} catch (OJEException e) {
							System.out.println(e.getMessage());
						}
						
						break;

					case '2':

						if (contCliente > 0) {
							boolean resultado1 = false;
							String tempId, tempSenha;

							do {
								System.out.println("------------Login Cliente------------\n");

								System.out.print("Digite seu ID: ");
								tempId = in.nextLine();

								System.out.print("Digite sua senha: ");
								tempSenha = in.nextLine();
								
								try
								{
									resultado1 = Fachada.getInstancia().loginCliente(tempId, tempSenha);

								}

								catch(ONFException exc1)
								{
									System.out.println(exc1.getMessage());
									System.out.println(exc1.getidObjeto());
								}
								catch(WPException exc)
								{
									System.out.println(exc.getMessage());
									System.out.println("senha incorreta: " + exc.getSenhaErrada());
									
								}


							} while (resultado1 != true);

							int aux30 = 0;
							while (aux30 != 3) {
								System.out.printf("-------Seja Bem-Vindo %s------- \n",
										Fachada.getInstancia().nomeCliente(tempId));
								System.out.println("1 - Fazer um pedido");
								System.out.println("2 - Alterar senha");
								System.out.println("3 - Sair");
								System.out.print("\nDigite sua opcao: ");

								opcao = in.next().charAt(0);
								in.nextLine();

								switch (opcao) {

								case '1':
									
									if( contCombo > 0 || contProduto > 0 || contPromoCombo > 0 || contPromoProduto > 0)
									{
									int aux40 = 0;
									int somethingcomprado = 0;
								
									
									contVenda++;
									Venda venda = new Venda(contVenda, tempId);
									
									while( aux40 != 6)
									{
										
									
									System.out.println("===========Compra==============");
									System.out.println("1 - Produto");
									System.out.println("2 - Combo");
									System.out.println("3 - Promocao de Produto");
									System.out.println("4 - Promocao de Combo");
									System.out.println("5 - Finalizar Compra");
									System.out.println("6 - Remover item do carrinho");
									System.out.println("7 - Listar pedidos ja feitos");
									System.out.println("8 - Cancelar Compra");
									System.out.println("\nDigite sua opcao:");
									
									opcao = in.next().charAt(0);
									in.nextLine();
									
									
									switch(opcao)
									{
										// COMPRAR PRODUTOOOOOO
									
										case '1':
											
											if (contProduto > 0) {
												System.out.println(
														"----------Produtos----------\n" + Fachada.getInstancia().listarProdutos());
												
												
												try
												{
												System.out.println("\nDigite o codigo do Produto que voce deseja");
												String codigo = in.nextLine();
												
												Produto p = new Produto();
												
												p = Fachada.getInstancia().procurarProduto(codigo);
												
												venda.comprarProduto(p);
												somethingcomprado++;
												System.out.println("Pedido adicionado ao carrinho com sucesso");
												
												}	
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println(exc.getidObjeto());
												}
					
												
												

											} else {
												System.out.println("Nenhum produto cadastrado no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA PRODUTO
											
											
										case '2':
											
											if( contCombo > 0)
											{
																								
												System.out.println(" ==================Combos =================\n" + Fachada.getInstancia().listarCombos());
											
												
												try
												{
													System.out.println("\nDigite o codigo do combo que voce deseja");
													String codigo = in.nextLine();
												
													Combo c = new Combo();
												
													c = Fachada.getInstancia().procurarCombo(codigo);

													venda.comprarCombo(c);
													somethingcomprado++;
													System.out.println("Pedido adicionado ao carrinho com sucesso");
												}
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
												}
	
												
												
											}
											else
											{
												System.out.println("Nenhum combo cadastrado no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA DE COMBO
											
										case '3':
											
											if( contPromoProduto > 0)
											{
												System.out.println("===============Promocoes de produto===========\n"
														+ Fachada.getInstancia().listarProdutoPromotion());
												
												
												
												System.out.println("\nDigite o codigo da promocao desejada");
												String codigo = in.nextLine();
												
												PromocaoProduto pp = new PromocaoProduto();
												
												try
												{
													pp = Fachada.getInstancia().buscarPromocaoProduto(codigo);
													
													venda.comprarPromoProduto(pp);
													somethingcomprado++;
													System.out.println("Pedido adicionado ao carrinho com sucesso");
													
												}
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
												}

	
												
											}
											else
											{
												System.out.println("Nenhuma promocao de produto cadastrada no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE PRODOUTO
											
											
										case '4':
											if( contPromoCombo > 0 )
											{
												System.out.println("============Promocoes de combo============\n"
														+ Fachada.getInstancia().listarCombosPromotion());
												
												
												
												System.out.println("\nDigite o codigo da promocao desejada:");
												String codigo = in.nextLine();
												
												PromocaoCombo pc = new PromocaoCombo();
												try
												{
													
												pc = Fachada.getInstancia().buscarPromocaoCombo(codigo);
												venda.comprarPromoCombo(pc);
												somethingcomprado++;
												System.out.println("Pedido adicionado ao carrinho com sucesso");
												
												}
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println("Id do objeto: " + exc.getidObjeto());
												}
								
											}
											else
											{
												System.out.println("Nenhuma promocao de produto cadastrada no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE COMBO
											
											
										case '5':
											
											
											if(somethingcomprado > 0)
											{
											
											System.out.println("Seu pedido tem o valor de: " + venda.getValorTotal() +"\n");
											boolean resultado100 = false;
											do
											{
											System.out.println("Digite sua senha para confirmar o pedido");
											String confirmasenha = in.nextLine();
											
											try
											{
											
											resultado100 = Fachada.getInstancia().loginCliente(tempId, confirmasenha);
											Fachada.getInstancia().cadastrarVenda(venda);
											
											}
											catch(ONFException exc)	
											{
												System.out.println(exc.getMessage());
											}
											catch(WPException exc)
											{
												System.out.println(exc.getMessage());
												System.out.println(exc.getSenhaErrada());
											}
											


											}while( resultado100 == false);

												System.out.println("Compra realizada com sucesso\nPressione enter para continuar");
												in.nextLine();
												aux40 = 6;
											
											
}
											else
											{
												System.out.println("Nenhum pedido realizado");
											}
											break; //
											
										case '6':
											if(somethingcomprado > 0)
											{
											int aux8000 = 0;
											
											while( aux8000 != 5)
											{
												
											
											System.out.println("===========Remover do carrinho==============");
											System.out.println("1 - Produto");
											System.out.println("2 - Combo");
											System.out.println("3 - Promocao de Produto");
											System.out.println("4 - Promocao de Combo");
											System.out.println("5 - Sair");
											System.out.println("\nDigite sua opcao:");
											
											opcao = in.next().charAt(0);
											in.nextLine();
											
											
											switch(opcao)
											{
											
											case '1':
												
												System.out.println("Digite o id do produto a ser removido");
												String onemoretime = in.nextLine();
												
												Produto p = new Produto();
												p = venda.BuscarProduto(onemoretime);
												
												if( p.getCodigo() != null)
												{
													somethingcomprado--;
													venda.removerProduto(onemoretime);
													System.out.println("Produto removido com sucesso");
												}
												else
												{
													System.out.println("pedido nao realizado");
												}
												
												
												
												
												break;
												
											case '2':
												
												System.out.println("Digite o id do combo a ser removido");
												String onemoretime1 = in.nextLine();
												
												Combo c = new Combo();
												c = venda.BuscarCombo(onemoretime1);
												
												if( c.getCodigo() != null)
												{
													somethingcomprado--;
													venda.removerCombo(onemoretime1);
													System.out.println("Combo removido com sucesso");
												}
												else
												{
													System.out.println("pedido nao realizado");
												}
												
												break;
												
											case '3':
												
												System.out.println("Digite o id da promocao de produto a ser removida");
												String onemoretime2 = in.nextLine();
												
												PromocaoProduto pp = new PromocaoProduto();
												pp = venda.BuscarPromoProduto(onemoretime2);
												
												if( pp.getIdPromocao() != null)
												{
													somethingcomprado--;
													venda.removerPromoProduto(onemoretime2);
													System.out.println("Promocao de produto removida com sucesso");
												}
												else
												{
													System.out.println("pedido nao realizado");
												}
												
												break;
												
											case '4':
												
												System.out.println("Digite o id da promocao de combo a ser removida");
												String onemoretime3 = in.nextLine();
												
												PromocaoCombo pc = new PromocaoCombo();
												pc = venda.BuscarPromoCombo(onemoretime3);
												
												if( pc.getIdPromocao() != null)
												{
													somethingcomprado--;
													venda.removerPromoCombo(onemoretime3);
													System.out.println("Promocao de combo removida com sucesso");
												}
												else
												{
													System.out.println("pedido nao realizado");
												}
												
												break;
												
												
											case '5':
												
												aux8000 = 5;
												break;
												
											default:
												System.out.println("Opcao invalida");
												
												break;
												
												
										
											
											}
										}
										}
											
										break;
										
										case '7':
											if(somethingcomprado > 0)
											{
												System.out.println(venda.toString());
												in.nextLine();
											}
											else
											{
												System.out.println("Nenhum pedido realizado");
											}
											
											break;
										
										case '8':
											
											contVenda--;
											aux40 = 6;
											
											break;
											
										default:
											System.out.println("Opcao invalida");							
											
											
									}						
									
									} // END DO WHILE
									
									
									}
									else
									{
										System.out.println("Nenhum produto cadastrado no estoque");
									}
									
									break;

								case '2':
									String oldsenha, newsenha;
									boolean result = false;
									System.out.println("--------------Alteracao de Senha-------------\n");
									do {

										System.out.println("Digite sua antiga senha");
										oldsenha = in.nextLine();

										System.out.println("Digite sua senha nova");
										newsenha = in.nextLine();
										
										try
										{
										
										Fachada.getInstancia().alterarSenhaCliente(tempId, oldsenha, newsenha);
										result = true;
										
										}
										catch(ONFException exc)
										{
											System.out.println(exc.getMessage());
										}
										catch(WPException exc)
										{
											System.out.println(exc.getMessage());
										}


									} while (result != true);

									if (result == true) {
										System.out.println("Senha modificado com sucesso");
									} else {
										System.out.println("Senha nao foi modificada");
									}

									in.nextLine();

									break;

								case '3':

									aux30 = 3;
									
									break;

								default:

									System.out.print("Opcao Invalida!");

									break;
								}
							}
						} else {
							System.out.println("Nenhum Cliente cadastrado no Sistema");
						}

						break;

					case '3':
						aux2 = 3;
						
						break;

					default:
						System.out.println("Opcao Invalida");
						break;

					}

				}

				break;

			case '2':
				int auxsomething = 0;
				while (auxsomething != 3) {
					System.out.println("-----------Caixa----------\n");
					System.out.println("1 - Login Administrador;");
					System.out.println("2 - Login Funcionario;");
					System.out.println("3 - Voltar;\n");
					System.out.print("Digite sua opcao: ");
					opcao = in.next().charAt(0);
					in.nextLine();

					switch (opcao) {

					case '1':
						int tentativas2 = 0;
						boolean end = false;
						String tempSenhaAdmin;
						System.out.println("------------Login Administrador------------\n");

						do {
							System.out.print("Digite seu ID: ");
							String tempIdAdmin = in.nextLine();

							System.out.print("Digite sua senha: ");
							tempSenhaAdmin = in.nextLine();

							try
							{
								end = Fachada.getInstancia().loginFuncionario(tempIdAdmin, tempSenhaAdmin);
							}catch(WPException exc)
							{
								System.out.println(exc.getMessage());
							} catch (ONFException e) {
								System.out.println(e.getMessage());
							}


						} while (end != true);

						int auxadmin = 0;
						while (auxadmin != 10) {
							System.out.println("-----------Bem-Vindo-----------");
							System.out.println("1 - Gerenciar funcionarios");
							System.out.println("2 - Gerenciar produtos");
							System.out.println("3 - Gerenciar clientes");
							System.out.println("4 - Gerenciar vendas");
							System.out.println(("s - Deslogar como admin"));
							System.out.println("\nDigite sua opcao: ");

							opcao = in.next().charAt(0);
							in.nextLine();

							switch (opcao) {

							case '1':

								int b30 = 0;

								while (b30 != 5) {

									System.out
											.println("=================Gerenciamento de funcionarios================");
									System.out.println("1 - Adicionar ");
									System.out.println("2 - Remover");
									System.out.println("3 - Alterar dados");
									System.out.println("4 - listar");
									System.out.println("5 - Sair");
									System.out.println("======================\nDigite sua opcao:");

									opcao = in.next().charAt(0);
									in.nextLine();

									switch (opcao) {
									case '1':

										System.out.print("------------Cadastro Funcionario---------- \n");

										System.out.print("Nome: ");
										String nome = in.nextLine();

										System.out.print("CPF: ");
										String id = in.nextLine();

										System.out.print("Nascimento: ");
										String nascimento = in.nextLine();

										System.out.print("Rua: ");
										String rua = in.nextLine();

										System.out.print("Numero: ");
										int numero = in.nextInt();
										in.nextLine();

										System.out.print("Bairro: ");
										String bairro = in.nextLine();

										System.out.print("Cidade: ");
										String cidade = in.nextLine();

										System.out.print("Estado: ");
										String estado = in.nextLine();

										System.out.print("Telefone: ");
										String telefone = in.nextLine();

										String senha;
										String senha2;

										do {

											System.out.print("Senha: ");
											senha = in.nextLine();

											System.out.print("Confime a Senha: ");
											senha2 = in.nextLine();

										} while ((senha.equals(senha2) != true));

										Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
										Funcionario funcionario1 = new Funcionario(nome, id, nascimento, end1, senha);
										try
										{
										Fachada.getInstancia().cadastrarFuncionario(funcionario1);
										contFunc++;
										}
										catch(OJEException exc)
										{
											System.out.println(exc.getMessage());
											System.out.println("id:" + exc.getId());
										}

										break; // TERMINO DO CASE 1 DO
												// GERENCIAMENTO D FUNCIONARIOS

									case '2':

										if (contFunc > 0) {
											System.out.println("Digite o ID do Funcionario: ");
											String auxIdFunc = in.nextLine();
											
											try
											{
												Fachada.getInstancia().removerFuncionario(auxIdFunc);
												contFunc--;
												System.out.println("Funcionario removido com sucesso");
											}
											catch(ONFException exc)
											{
												System.out.println(exc.getMessage());
												System.out.println("Funcionario nao removido");
												
											}
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 2 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '3':

										String oldsenha, newsenha;
										boolean result = false;
										int blabla = 0;

										if (contFunc > 0) {
											System.out.println("Digite o id do funcionario:");
											String idd = in.nextLine();
											
											Funcionario f = new Funcionario();
											try
											{
											f = Fachada.getInstancia().procurarFuncionario(idd);
											
											while (blabla != 3) {
												System.out
														.print("------------Atualizacao Funcionario---------- \n");

												System.out.println("1 - Alterar endereco:");
												System.out.println("2 - Alterar senha:");
												System.out.println("3 - Sair");

												opcao = in.next().charAt(0);
												in.nextLine();

												switch (opcao) {

												case '1': 

													System.out.println("Digite a rua:");
													String ruaa = in.nextLine();

													System.out.println("Digite o numero:");
													int numeroo = in.nextInt();
													in.nextLine();

													System.out.println("Digite o bairro:");
													String bairroo = in.nextLine();

													System.out.println("Digite a cidade:");
													String cidadee = in.nextLine();

													System.out.println("Digite o estado:");
													String estadoo = in.nextLine();

													System.out.println("Digite o telefone:");
													String telefonee = in.nextLine();

													Endereco endtwo = new Endereco(ruaa, bairroo, cidadee, estadoo,
															numeroo, telefonee);
													
													try
													{
													Fachada.getInstancia().atualizarFuncionario(idd, endtwo);
													System.out.println("Alteracao realizada com sucesso!");
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
													}

														
	
													in.nextLine();

													break;

												case '2':

													System.out.println(
															"--------------Alteracao de Senha-------------\n");
													do {

														System.out.println("Digite sua antiga senha");
														oldsenha = in.nextLine();

														System.out.println("Digite sua senha nova");
														newsenha = in.nextLine();
														
														try
														{
														Fachada.getInstancia().alterarSenhaFuncionario(idd, oldsenha, newsenha);
														result = true;
														}
														catch(WPException exc)
														{
															System.out.println(exc.getMessage());
															
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															
														}

													} while (result != true);

														System.out.println("Senha modificado com sucesso");

													
													in.nextLine();

													break;

												case '3':

													blabla = 3;
													break;

												default:
													System.out.println("Opcao invalida");
													break;

												}
											}
											}
											catch(ONFException exc)
											{
												System.out.println(exc.getMessage());
											}
												

										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 3 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '4':

										if (contFunc > 0) {
											System.out.println(Fachada.getInstancia().listarFuncionarios());
											in.nextLine();
										} else {
											System.out.println(
													"Impossivel realizar aca, o sistema nao possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D FUNCIONARIOS

									case '5':

										b30 = 5;
										break;// funcao d sair

									default:
										System.out.println("Opcao invalida");
										break;

									}
								}

								break;// BREAK DO TERMINO DO CASE D FUNCIONARIO

							case '2':

								int b20 = 0;

								while (b20 != 5) {
									System.out.println(
											"=====================Gerenciamento de produtos==================");
									System.out.println("1 - Adicionar");
									System.out.println("2 - Remover");
									System.out.println("3 - Alterar dados");
									System.out.println("4 - Listar");
									System.out.println("5 - Sair");
									System.out.println("=====================\nDigite sua opcao:");

									opcao = in.next().charAt(0);
									in.nextLine();

									switch (opcao) {

									case '1':
										
										int h20 = 0;
										
										while(h20 != 5)
										{
										System.out.println("==================Adicionar==================");
										System.out.println("1 - Produto");
										System.out.println("2 - Combo");
										System.out.println("3 - Promocao de Combo");
										System.out.println("4 - Promocao de Produto");
										System.out.println("5 - Sair");
										System.out.println("\nDigite sua opcao:");
										
										opcao = in.next().charAt(0);
										in.nextLine();
										
										
										switch(opcao)
										{
											
											case '1': 
												
												System.out.print("Nome do Produto: ");
												String nomeProd = in.nextLine();

												System.out.print("Codigo do Produto: ");
												String codigoProd = in.nextLine();

												System.out.print("Valor do Produto: ");
												Double valorProd = in.nextDouble();
												in.nextLine();
												try
												{
												
												Produto produto1 = new Produto(nomeProd, valorProd, codigoProd);
												Fachada.getInstancia().cadastrarProduto(produto1);
												contProduto++;
												}
												catch(OJEException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println("Id do objeto: " + exc.getId());
												}
												break;
												
											
											case '2':
												
												int conterro = 0;
												
												if( contProduto > 2)
												{
														
												System.out.println("Nome do Combo: ");
												String nomeCombo = in.nextLine();
												
												System.out.println("Codigo do Combo: ");
												String codigoCombo = in.nextLine();
												
												Combo combo1 = new Combo(nomeCombo , codigoCombo);
												try
												{
												
													
												Fachada.getInstancia().cadastrarCombo(combo1);
												contCombo++;
												conterro++;
												}
												catch(OJEException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println("Id do objeto: " + exc.getId());
												}
												
												if(conterro > 0)
												{
												System.out.println("Deseja listar os produtos ja cadastrados para auxiliar na criacao do combo ? (S/N)");
												char resposta = in.next().charAt(0);
												in.nextLine();
												
												if( resposta == 'S' || resposta == 's')
												{
													System.out.println(Fachada.getInstancia().listarProdutos());
												}
												
									
												boolean result = true;
												Produto produto2 = new Produto();
												do
												{
													
													try
													{
													System.out.println("Digite o codigo do produto a ser adicionado no combo");
													String volatcode = in.nextLine();
													
													produto2 = Fachada.getInstancia().procurarProduto(volatcode);
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println(exc.getidObjeto());
														
													}
													
													try
													{
													combo1.addItens(produto2);
														
													System.out.println("Produto adicionado ao combo com sucesso\n");
													
													}
													catch(OJEException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto" + exc.getId());
														
													}
	
													
													System.out.println("Deseja adicionar mais um produto ao combo ? ( S/N )");
													
													char resposta1000 = in.next().charAt(0);
													
													in.nextLine();
													
													if( resposta1000 == 'n' || resposta1000 == 'N')
													{
														result = false;
													}
													
													System.out.println();
													
												}while( result == true);
												

												
												}
												}
												else
												{
													System.out.println("Impossivel criar um combo, devido a falta de produtos em estoque");
												}
												
												break;// TERMINO DO CASE 2 DO ADICIONAR
												
											case '3':
												
												if( contCombo >= 1)
												{
													Combo combo1 = new Combo();
													System.out.println("Digite o id do combo a entrar em promocao:");
													String idcombo1 = in.nextLine();
													
													try
													{
																									
													combo1 = Fachada.getInstancia().procurarCombo(idcombo1);
													
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
													}
													

														System.out.println("Digite o id da promocao do combo:");
														String idpromocombo = in.nextLine();
														
														System.out.println("Digite o valor da promocao:");
														Double valorpromocombo = in.nextDouble();
														in.nextLine();
														
														LocalDate creation = LocalDate.now();
														
														PromocaoCombo promocombo = new PromocaoCombo(idpromocombo, creation, combo1, valorpromocombo);
														
														
														
														try
														{
														
														Fachada.getInstancia().cadastrarPromoCombo(promocombo);
														contPromoCombo++;
														System.out.println("Promocao de combo cadastrada com sucesso");
														}
														catch(OJEException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto : " + exc.getId());
														}
														
													}
					
													
												else
												{
													System.out.println("Impossivel realizar a acao por falta de combos no estoque");
												}
												
												
												break;// TERMINO DO CASE DE ADICIONAR PROMOC�O DE COMBOS
												
											case '4':
												
												int contErro1 = 0;
												
												if( contProduto >= 1)
												{
												
													System.out.println("Digite o id do produto a entrar em promocao:");
													String idproduto1 = in.nextLine();
												
													Produto produto2 = new Produto();
													
													try
													{
										
														produto2 = Fachada.getInstancia().procurarProduto(idproduto1);
														contErro1++;
														
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println(exc.getidObjeto());
													}
					
													if(contErro1 > 0)
													{

														System.out.println("Digite o id da promocao do produto:");
														String idpromoprodutos = in.nextLine();
														
														System.out.println("Digite o valor da promocao:");
														Double valorpromoproduto = in.nextDouble();
														in.nextLine();
														
														LocalDate creation = LocalDate.now();
														
														PromocaoProduto promoproduto = new PromocaoProduto(idpromoprodutos, creation, produto2, valorpromoproduto);
														
														try
														{
															Fachada.getInstancia().cadastrarPromoProduto(promoproduto);
															
															contPromoProduto++;
															
															System.out.println("Promocao de produto cadastrada com sucesso");
														}
														catch(OJEException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto: " + exc.getId());
														}
													}
													
												}
												else
												{
													System.out.println("Impossivel realizar a acao por falta de produtos no estoque");
												}
												
												break; // TERMINO DO CASE DE CRIAR PROMOCAO DE PRODUTO
												
											case '5':
												
												h20 = 5;
												
											break;
												
												
											default:
												System.out.println("Opcao invalida");
												break;
											
										}
										}
										

										break; // TERMINO DO CASE 1 D
												// GERENCIAMENTO D PRODUTOS

									case '2':
										
										int y20 = 0;

										while (y20 != 5) 
										{
										
										System.out.println("==================Remover==================");
										System.out.println("1 - Produto");
										System.out.println("2 - Combo");
										System.out.println("3 - Promocao de Combo");
										System.out.println("4 - Promocao de Produto");
										System.out.println("5 - Sair");
										System.out.println("\nDigite sua opcao:");
										
										opcao = in.next().charAt(0);
										in.nextLine();
										
										
										switch(opcao)
										{
											case '1':
												
												if (contProduto > 0) {

													System.out.println("Digite o Codigo do Produto a ser removido: ");
													String auxCodigoProd = in.nextLine();
													try
													{
													
														Fachada.getInstancia().removerProduto(auxCodigoProd);
														contProduto--;
														System.out.println("Produto removido com sucesso");
														
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println(exc.getidObjeto());
													}
													
											
												} else {
													System.out.println(
															"Impossivel realizar acao, o sistema nao possui produtos cadastrados");
												}

												break; 
												
											case '2':
												
												if( contCombo > 0 )
												{
													try
													{
														System.out.println("Digite o codigo do combo a ser removido:");
														String auxCodigoCombo = in.nextLine();
													
														Fachada.getInstancia().removerCombo(auxCodigoCombo);
														contCombo--;
														System.out.println("Combo removido com sucesso");
													
												}catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
													System.out.println(exc.getidObjeto());
												}
												}
												else
												{
													System.out.println("Impossivel realizar acao, o sistema nao possui combos cadastrados");
												}
												break;
												
											
											case '3':
												
												if( contPromoCombo > 0 )
												{
													System.out.println("Digite o codigo da promocao de combo a se removida:");
													String auxCodigopromocombo = in.nextLine();
													
													try
													{
														Fachada.getInstancia().removerPromoCombo(auxCodigopromocombo);

														contPromoCombo--;
														System.out.println("Promocao de combo removida com sucesso");
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto: " + exc.getidObjeto());
													}

												}
												else
												{
													System.out.println("Impossivel realizar acao, o sistema nao possui promocoes de combo cadastradas");
												}
												break;
												
												
											case '4':
												
												if( contPromoProduto > 0 )
												{
													System.out.println("Digite o codigo da promocao de produto a ser removida:");
													String auxCodigopromoproduto = in.nextLine();
													
													try
													{
														Fachada.getInstancia().removerProduto(auxCodigopromoproduto);

														contPromoProduto--;
														System.out.println("Promocao de produto removida com sucesso");
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto: " + exc.getidObjeto());
													}

												}
												else
												{
													System.out.println("Impossivel realizar acao, o sistema nao possui promocoes de produto cadastradas");
												}
												break;
												
												
												
											case '5':
												y20 = 5;
												break;
												
											default:
												System.out.println("opcao invalida");
												break;
												
												
										}// END DO SWITCH DE REMOVER
										
										
										}// END DO WHILE DE REMOVER
										
										
										

									case '3':
										int x20 = 0;

										while (x20 != 5) {
											System.out.println(
													"=====================Alterar dados==================");
											System.out.println("1 - Produtos");
											System.out.println("2 - Combos");
											System.out.println("3 - Promocoes de combo");
											System.out.println("4 - Promocoes de produto");
											System.out.println("5 - Sair");
											System.out.println("=====================\nDigite sua opcao:");

											opcao = in.next().charAt(0);
											in.nextLine();

											switch (opcao) {
											
											case '1':
												if(contProduto > 0)
												{
													System.out.println("Digite o id do produto a ser alterado");
													String idprodutoalterado = in.nextLine();
													
													try
													{
														Produto p = new Produto();
														p = Fachada.getInstancia().procurarProduto(idprodutoalterado);

														System.out.println("Digite o novo valor do produto");
														double newvalor = in.nextDouble();
														in.nextLine();
																			
														Fachada.getInstancia().atualizarProduto(newvalor, idprodutoalterado);
														
														System.out.println("Preco alterado com suceso");
														
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println(exc.getidObjeto());
														}

													

												}
												else
												{
													System.out.println("Nenhum produto cadastrado no sistema");
												}
												
											break; // TERMINO DO CASE 1
											
											
											
											
											case '2':
												if( contCombo > 0 )
												{
													int k20 = 0;
													while(k20 != 3)
													{
														System.out.println("==================ALTERAR DADOS COMBO=============");
														System.out.println("1 - Adicionar produto");
														System.out.println("2 - Remover produto");
														System.out.println("3 - Sair");
														System.out.println("\nDigite sua opcao:");
														
														opcao = in.next().charAt(0);
														in.nextLine();
														
														
														switch(opcao)
														{
														case '1':
															

															
															System.out.println("Digite o codigo do combo:");                                                          
															String codigocombo = in.nextLine();
															try
															{
															
															Combo c = new Combo();
															c = Fachada.getInstancia().procurarCombo(codigocombo);
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
															}
															
															Produto p = new Produto();
															try
															{
																System.out.println("Digite o codigo do produto a ser adicionado no combo");
																String codigoproduto = in.nextLine();
															
																
																p = Fachada.getInstancia().procurarProduto(codigoproduto);

																
															}catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println(exc.getidObjeto());
															}
															try
															{
																Fachada.getInstancia().AdicionarProdutoAoCombo(p, codigocombo);

																System.out.println("Produto adicionado com sucesso");
															
															}
															catch(OJEException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto: " + exc.getId());
																
															}catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println(exc.getidObjeto());
															}
														
															
															break;
																	
															
														case '2':
															
		
															System.out.println("Digite o codigo do combo:");
															String codigocombo1 = in.nextLine();
															
															Combo c1 = new Combo();
															try
															{
															c1 = Fachada.getInstancia().procurarCombo(codigocombo1);
															}
															catch(ONFException exc )
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
															}
															
															Produto p10 = new Produto();
															
															try
															{
															System.out.println("Digite o codigo do produto a ser removido no combo");
															String codigoproduto1 = in.nextLine();
															
															
															p = Fachada.getInstancia().procurarProduto(codigoproduto1);						
																
															
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println(exc.getidObjeto());
															}
															
															try
															{
																Fachada.getInstancia().RemoverProduto(p10, codigocombo1);
																
																System.out.println("Produto removido com sucesso");
															}
															catch(PNEException exc)
															{
																System.out.println(exc.getMessage());                                                          
																System.out.println(exc.getidObjeto());
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println(exc.getidObjeto());
															}
															


															
															break;
															
														case '3':
															k20 = 3;
															break;
															
														default:
															System.out.println("opcao invalida");
															break;
																		
															
														}
														}
														
													}
													
												
												else
												{
													System.out.println("Nenhum combo cadastrado no sistema");
												}
												
												break;
												
											case '3':
												if(contPromoCombo > 0)
												{
													System.out.println("Digite o id da promocao de combo a ser alterada");
													String idpromocombo = in.nextLine();
													
													PromocaoCombo pc = new PromocaoCombo();
													try
													{
													pc = Fachada.getInstancia().buscarPromocaoCombo(idpromocombo);
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto: " + exc.getidObjeto());
													}
												

														System.out.println("Digite o novo valor da promocao de combo");
														double newvalor = in.nextDouble();
														in.nextLine();
														
														try
														{
														
														Fachada.getInstancia().alterarPrecoPromoCombo(newvalor, idpromocombo);
														System.out.println("Preco alterado com suceso");
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto: " + exc.getidObjeto());
															
														}


												}
												else
												{
													System.out.println("Nenhuma promocao de combo encontrada no sistema");
												}
												
												break;
												
											case '4':
												if(contPromoProduto > 0)
												{
													System.out.println("Digite o id da promocao de produto a ser alterada");
													String idpromoproduto = in.nextLine();
													
													PromocaoProduto pp = new PromocaoProduto();
													try
													{
													pp = Fachada.getInstancia().buscarPromocaoProduto(idpromoproduto);
													}
													catch(ONFException exc)
													{
														System.out.println(exc.getMessage());
														System.out.println("Id do objeto: " + exc.getidObjeto());
													}
													
														System.out.println("Digite o novo valor da promocao de produto");
														double newvalor = in.nextDouble();
														in.nextLine();
														
														try
														{
															Fachada.getInstancia().alterarPrecoPromoProduto(newvalor, idpromoproduto);

														System.out.println("Preco alterado com suceso");
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto : " + exc.getidObjeto());
														}

												}
												else
												{
													System.out.println("Nenhuma promocao de produto encontrada no sistema");
												}
												break;
												
											case '5':
												x20 = 5;
												break;
												
											default:
												System.out.println("opcao invalida");
												break;
											
												
											}// END DO SWITCH PRINCIPAL
											
											
											
										}// END DO WHILE
										
											
										break;

									case '4':
										
										int z20 = 0;

										while (z20 != 5) {
											System.out.println(
													"=====================Listar Produtos==================");
											System.out.println("1 - Listar Produtos");
											System.out.println("2 - Listar Combos");
											System.out.println("3 - Listar Promocoes de combo");
											System.out.println("4 - Listar Promocoes de produto");
											System.out.println("5 - Sair");
											System.out.println("=====================\nDigite sua opcao:");

											opcao = in.next().charAt(0);
											in.nextLine();

											switch (opcao) {
											
											
											case '1':
												
												if(contProduto >= 1)
												{
													System.out.println(Fachada.getInstancia().listarProdutos());
												}
												else
												{
													System.out.println("Nenhum produto cadastrado no estoque");
												}
												
											break;
											
											case '2':
												
											if(contCombo >= 1)
											{
												System.out.println(Fachada.getInstancia().listarCombos());
											}
											else
											{
												System.out.println("Nenhum combo cadastrado no estoque");
											}
											
										break;
										
											case '3':
												
											if(contPromoCombo >= 1)
											{
												System.out.println(Fachada.getInstancia().listarCombosPromotion());
											}
											else
											{
												System.out.println("Nenhuma promocao de combo cadastrado no estoque");
											}
											
										break;
										
											case '4':
												
											if(contPromoProduto >= 1)
											{
												System.out.println(Fachada.getInstancia().listarProdutoPromotion());
											}
											else
											{
												System.out.println("Nenhuma promocao de produtos cadastrado no estoque");
											}
											
										break;
										
											case '5':
												
												z20 = 5;
												
												break;
										
											
											default:
											
												System.out.println("Opcao invalida");
										
												break;
		
												
											
											}
											
											}
								

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D PRODUTOS

									case '5':
										b20 = 5;
										break;// CASE SAIR

									default:
										System.out.println("Opcao invalida");
										break;

									}
								}

								break; // BREAK DO TERMINO DO CASE D PRODUTO

							case '3':

								int b10 = 0;

								while (b10 != 5) {
									System.out.println("===================Gerenciamento de clientes=================");
									System.out.println("1 - Adicionar:");
									System.out.println("2 - Remover:");
									System.out.println("3 - Alterar dados:");
									System.out.println("4 - Listar:");
									System.out.println("5 - Sair:");
									System.out.println("=================\nDigite sua opcao:");

									opcao = in.next().charAt(0);
									in.nextLine();

									switch (opcao) {

									case '1':

										System.out.print("------------Cadastro Cliente---------- \n");

										System.out.print("Nome: ");
										String nome = in.nextLine();

										System.out.print("CPF: ");
										String id = in.nextLine();

										System.out.print("Nascimento: ");
										String nascimento = in.nextLine();

										System.out.print("Rua: ");
										String rua = in.nextLine();

										System.out.print("Numero: ");
										int numero = in.nextInt();
										in.nextLine();

										System.out.print("Bairro: ");
										String bairro = in.nextLine();

										System.out.print("Cidade: ");
										String cidade = in.nextLine();

										System.out.print("Estado: ");
										String estado = in.nextLine();

										System.out.print("Telefone: ");
										String telefone = in.nextLine();

										System.out.print("Email: ");
										String email = in.nextLine();

										String senha;
										String senha2;

										do {

											System.out.print("Senha: ");
											senha = in.nextLine();

											System.out.print("Confime a Senha: ");
											senha2 = in.nextLine();

										} while ((senha.equals(senha2) != true));

										Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
										Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
										try {
											Fachada.getInstancia().cadastrarCliente(cliente1);
											contCliente++;
											
										} catch (OJEException e1) {
											
											System.out.println(e1.getMessage());
										}
										
										break;

									case '2':

										if (contCliente > 0) {
											System.out.println("Digite o ID do Cliente: ");
											String auxIdCliente = in.nextLine();

											try
											{
												
												Fachada.getInstancia().removerCliente(auxIdCliente);
												contCliente--;
												System.out.println("Cliente removido com sucesso");
												
											}
											catch(ONFException exc)
											{
												System.out.println(exc.getMessage());
											}

										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 2 D
												// GERENCIAMENTO D CLIENTES

									case '3':


										String oldsenha, newsenha;
										int contla = 0;
										int blabla = 0;

										if (contCliente > 0) {
											
											System.out.println("Digite o id do cliente:");
											String idd = in.nextLine();
											
											Cliente c = new Cliente();
											
											try
											{
											
												c = Fachada.getInstancia().procurarCliente(idd);
												
												while (blabla != 3) {
													System.out.print("------------Atualizao cliente---------- \n");

													System.out.println("1 - Alterar endereco:");
													System.out.println("2 - Alterar senha:");
													System.out.println("3 - Sair");

													opcao = in.next().charAt(0);
													in.nextLine();

													switch (opcao) {

													case '1':

														System.out.println("Digite a rua:");
														String ruaa = in.nextLine();

														System.out.println("Digite o numero:");
														int numeroo = in.nextInt();
														in.nextLine();

														System.out.println("Digite o bairro:");
														String bairroo = in.nextLine();

														System.out.println("Digite a cidade:");
														String cidadee = in.nextLine();

														System.out.println("Digite o estado:");
														String estadoo = in.nextLine();

														System.out.println("Digite o telefone:");
														String telefonee = in.nextLine();

														Endereco endtwo = new Endereco(ruaa, bairroo, cidadee, estadoo,
																numeroo, telefonee);
														
														try
														{
															
														Fachada.getInstancia().atualizarClienteendereco(idd,endtwo);
														System.out.println("Alteracao realizada com sucesso!");
														
														}catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
														}
														
														break;

													case '2':

														System.out.println(
																"--------------Alteracao de Senha-------------\n");
														
															System.out.println("Digite a antiga senha");
															oldsenha = in.nextLine();

															System.out.println("Digite a senha nova");
															newsenha = in.nextLine();

															try
															{
															Fachada.getInstancia().alterarSenhaCliente(idd, oldsenha, newsenha);
															System.out.println("Senha modificado com sucesso");
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
															} catch (WPException e) {
																
																System.out.println(e.getMessage());
															}



														break;

													case '3':

														blabla = 3;
														break;

													default:
														System.out.println("Opcao invalida");
														break;

													}
												}
			
								
											
											}																								
											catch(ONFException exc)
											{
												System.out.println(exc.getMessage());
											}
										}
											else {
												System.out.println(
														"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
											}

										break;

									case '4':

										if (contCliente > 0) {
											System.out.println(Fachada.getInstancia().listarClientes());
											in.nextLine();
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D CLIENTES

									case '5':
										b10 = 5;
										break;

									default:
										System.out.println("Opcao invalida");
										break;

									}
								}

								break;// BREAK DO TERMINO DO CASE D CLIENTES
							
								
							case '4':
								

								if( contCombo > 0 || contProduto > 0 || contPromoCombo > 0 || contPromoProduto > 0)
								{
									int v20 = 0;
									
									while (v20 != 3) {
									System.out.println(
											"=====================Gerenciar Vendas==================");
									System.out.println("1 - Fazer pedido");
									System.out.println("2 - Mostrar historico de vendas");
									System.out.println("3 - Sair");
									System.out.println("=====================\nDigite sua opcao:");

									opcao = in.next().charAt(0);
									in.nextLine();

										switch (opcao) {
									
										case '1':
											
											int aux40 = 0;
											int somethingcomprado = 0;
											
											System.out.println("Digite o id do cliente a fazer o pedido:");
											String tempId = in.nextLine();
											
											Cliente c1 = new Cliente();
											try {
												c1 = Fachada.getInstancia().procurarCliente(tempId);
											} catch (ONFException e) {
												System.out.println(e.getMessage());
											}
											
											if(c1.getId() != null)
											{
											contVenda++;
											Venda venda = new Venda(contVenda, tempId);
											
											while( aux40 != 6)
											{
												
											
											System.out.println("===========Compra==============");
											System.out.println("1 - Produto");
											System.out.println("2 - Combo");
											System.out.println("3 - Promocao de Produto");
											System.out.println("4 - Promocao de Combo");
											System.out.println("5 - Finalizar Compra");
											System.out.println("6 - Remover item do carrinho");
											System.out.println("7 - Listar pedidos ja feitos");
											System.out.println("8 - Cancelar Compra");
											System.out.println("\nDigite sua opcao:");
											
											opcao = in.next().charAt(0);
											in.nextLine();
											
											
											switch(opcao)
											{
												
											
												case '1':
													

													if (contProduto > 0) {
														System.out.println(
																"----------Produtos----------\n" + Fachada.getInstancia().listarProdutos());
														
														
														try
														{
														System.out.println("\nDigite o codigo do Produto que voce deseja");
														String codigo = in.nextLine();
														
														Produto p = new Produto();
														
														p = Fachada.getInstancia().procurarProduto(codigo);
														
														venda.comprarProduto(p);
														somethingcomprado++;
														System.out.println("Pedido adicionado ao carrinho com sucesso");
														
														}	
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println(exc.getidObjeto());
														}
							
														
														

													} else {
														System.out.println("Nenhum produto cadastrado no estoque");
													}
													
													break; // BREAK DA FUNCAO DE COMPRA PRODUTO
													
													
												case '2':
													
													if( contCombo > 0)
													{
																										
														System.out.println(" ==================Combos =================\n" + Fachada.getInstancia().listarCombos());
													
														
														try
														{
															System.out.println("\nDigite o codigo do combo que voce deseja");
															String codigo = in.nextLine();
														
															Combo c = new Combo();
														
															c = Fachada.getInstancia().procurarCombo(codigo);

															venda.comprarCombo(c);
															somethingcomprado++;
															System.out.println("Pedido adicionado ao carrinho com sucesso");
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
														}
			
														
														
													}
													else
													{
														System.out.println("Nenhum combo cadastrado no estoque");
													}
													
													break; // BREAK DA FUNCAO DE COMPRA DE COMBO
													
												case '3':
													
													if( contPromoProduto > 0)
													{
														System.out.println("===============Promocoes de produto===========\n"
																+ Fachada.getInstancia().listarProdutoPromotion());
														
														
														
														System.out.println("\nDigite o codigo da promocao desejada");
														String codigo = in.nextLine();
														
														PromocaoProduto pp = new PromocaoProduto();
														
														try
														{
															pp = Fachada.getInstancia().buscarPromocaoProduto(codigo);
															
															venda.comprarPromoProduto(pp);
															somethingcomprado++;
															System.out.println("Pedido adicionado ao carrinho com sucesso");
															
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
														}

			
														
													}
													else
													{
														System.out.println("Nenhuma promocao de produto cadastrada no estoque");
													}
													break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE PRODOUTO
													
													
												case '4':
													if( contPromoCombo > 0 )
													{
														System.out.println("============Promocoes de combo============\n"
																+ Fachada.getInstancia().listarCombosPromotion());
														
														
														
														System.out.println("\nDigite o codigo da promocao desejada:");
														String codigo = in.nextLine();
														
														PromocaoCombo pc = new PromocaoCombo();
														try
														{
															
														pc = Fachada.getInstancia().buscarPromocaoCombo(codigo);
														venda.comprarPromoCombo(pc);
														somethingcomprado++;
														System.out.println("Pedido adicionado ao carrinho com sucesso");
														
														}
														catch(ONFException exc)
														{
															System.out.println(exc.getMessage());
															System.out.println("Id do objeto: " + exc.getidObjeto());
														}
										
													}
													else
													{
														System.out.println("Nenhuma promocao de produto cadastrada no estoque");
													}
													
													break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE COMBO
													
													
												case '5':
													
													
													if(somethingcomprado > 0)
													{
													
														System.out.println("O pedido tem o valor de: " + venda.getValorTotal() +"\n");
													boolean resultado100 = false;
													int contcompraerro = 0;
													do
													{
													System.out.println("Digite sua senha para confirmar o pedido");
													String confirmasenha = in.nextLine();
													
													boolean resultado1000 = confirmasenha.equals(tempSenhaAdmin);
													
													if(resultado1000 == true)
													{
														
														Fachada.getInstancia().cadastrarVenda(venda);
														
														resultado100 = true;
														
													}
													else
													{
														contcompraerro++;
														System.out.println("Senha incorreta");
													}
													
													if(contcompraerro == 7)
													{
														break;
														
													}
													}while( resultado100 == false);
													
													if(resultado100 == true)
													{
														System.out.println("Compra realizada com sucesso\nPressione enter para continuar");
														in.nextLine();
														aux40 = 6;
													}
													if( contcompraerro == 7)
													{
														System.out.println("Limite de tentativas excedida\nPressione enter para continuar");
														contVenda--;
														in.nextLine();
														aux40= 6;
													}
													}
													else
													{
														System.out.println("Nenhum pedido realizado");
													}
													break; //
													
												case '6':
													if(somethingcomprado > 0)
													{
													int aux8000 = 0;
													
													while( aux8000 != 5)
													{
														
													
													System.out.println("===========Remover do carrinho==============");
													System.out.println("1 - Produto");
													System.out.println("2 - Combo");
													System.out.println("3 - Promocao de Produto");
													System.out.println("4 - Promocao de Combo");
													System.out.println("5 - Sair");
													System.out.println("\nDigite sua opcao:");
													
													opcao = in.next().charAt(0);
													in.nextLine();
													
													
													switch(opcao)
													{
													
													case '1':
														
														System.out.println("Digite o id do produto a ser removido");
														String onemoretime = in.nextLine();
														
														Produto p = new Produto();
														p = venda.BuscarProduto(onemoretime);
														
														if( p.getCodigo() != null)
														{
															somethingcomprado--;
															venda.removerProduto(onemoretime);
															System.out.println("Produto removido com sucesso");
														}
														else
														{
															System.out.println("pedido nao realizado");
														}
														
														
														
														
														break;
														
													case '2':
														
														System.out.println("Digite o id do combo a ser removido");
														String onemoretime1 = in.nextLine();
														
														Combo c = new Combo();
														c = venda.BuscarCombo(onemoretime1);
														
														if( c.getCodigo() != null)
														{
															somethingcomprado--;
															venda.removerCombo(onemoretime1);
															System.out.println("Combo removido com sucesso");
														}
														else
														{
															System.out.println("pedido nao realizado");
														}
														
														break;
														
													case '3':
														
														System.out.println("Digite o id da promocao de produto a ser removida");
														String onemoretime2 = in.nextLine();
														
														PromocaoProduto pp = new PromocaoProduto();
														pp = venda.BuscarPromoProduto(onemoretime2);
														
														if( pp.getIdPromocao() != null)
														{
															somethingcomprado--;
															venda.removerPromoProduto(onemoretime2);
															System.out.println("Promocao de produto removida com sucesso");
														}
														else
														{
															System.out.println("pedido nao realizado");
														}
														
														break;
														
													case '4':
														
														System.out.println("Digite o id da promocao de combo a ser removida");
														String onemoretime3 = in.nextLine();
														
														PromocaoCombo pc = new PromocaoCombo();
														pc = venda.BuscarPromoCombo(onemoretime3);
														
														if( pc.getIdPromocao() != null)
														{
															somethingcomprado--;
															venda.removerPromoCombo(onemoretime3);
															System.out.println("Promocao de combo removida com sucesso");
														}
														else
														{
															System.out.println("pedido nao realizado");
														}
														
														break;
														
														
													case '5':
														
														aux8000 = 5;
														break;
														
													default:
														System.out.println("Opcao invalida");
														
														break;
														
														
												
													
													}
												}
												}
													
												break;
												
												case '7':
													if(somethingcomprado > 0)
													{
														System.out.println(venda.toString());
														in.nextLine();
													}
													else
													{
														System.out.println("Nenhum pedido realizado");
													}
													
													break;
												
												case '8':
													
													contVenda--;
													aux40 = 6;
													
													break;
													
												default:
													System.out.println("Opcao invalida");							
													
													
											}						
											
											} // END DO WHILE
											
											}
											else
											{
												System.out.println("Cliente nao encontrado no sistema");
											}
										
											break; // END DO CASE DE FAZER PEDIDO
											
										case '2':
											
											if(contVenda > 0)
											{
												System.out.println(Fachada.getInstancia().listarVendas());
											}
											else
											{
												System.out.println("Nenhuma venda realizada");
											}
											break;
											
										case '3':
											
											v20 = 3;
											
											break;
											
										default:
											System.out.println("opcao invalida");
											break;
									
											
										}// END DO SWITCH PRINCIPAL
									
									
									}// END DO WHILE
								}// END DO IF
							else
							{
								System.out.println("Nenhum produto cadastrado no estoque");
							}
					
								
						
								
								break; // BREAK DO TERMINO DO CASE DE GERENCIAMENTO DE VENDAS
								
							case 's':
								auxadmin = 10;
								break;

							default:

								System.out.println("Opcao invalida!");

								break;

							}
						}

						break;// TERMINO DA FUNCAO D LOGIN POR ADIMINSTRADOR

					case '2':
						if (contFunc > 0) {
							boolean result3 = false;
							String tempId2, tempSenha2;
							int tentativas3 = 0;
							do {

								System.out.println("------------Login Funcionario------------\n");

								System.out.println("Digite seu ID: ");
								tempId2 = in.nextLine();

								System.out.println("Digite sua senha: ");
								tempSenha2 = in.nextLine();

								tentativas3++;
								
								try {
									result3 = Fachada.getInstancia().loginFuncionario(tempId2, tempSenha2);
								} catch (ONFException e) {
									
									System.out.println(e.getMessage());
								} catch (WPException e) {
									System.out.println(e.getMessage());
											
								}

								if (result3 == false) {
									System.out.println("Senha ou id Incorretos");
								}

							} while (result3 != true);

							
							int auxfunc = 0;
							while (auxfunc != 4) {
								System.out.println("-----------Bem-Vindo-----------");
								System.out.println("1 - Gerenciar clientes");
								System.out.println("2 - Gerenciar vendas");
								System.out.println(("3 - Deslogar como funcionario"));
								System.out.println("\nDigite sua opcao: ");

								opcao = in.next().charAt(0);
								in.nextLine();

								switch (opcao) {
								
									
								case '1':
									
									int b10 = 0;

									while (b10 != 5) {
										System.out.println("===================Gerenciamento de clientes=================");
										System.out.println("1 - Adicionar:");
										System.out.println("2 - Remover:");
										System.out.println("3 - Alterar dados:");
										System.out.println("4 - Listar:");
										System.out.println("5 - Sair:");
										System.out.println("=================\nDigite sua opcao:");

										opcao = in.next().charAt(0);
										in.nextLine();

										switch (opcao) {

										case '1':

											System.out.print("------------Cadastro Cliente---------- \n");

											System.out.print("Nome: ");
											String nome = in.nextLine();

											System.out.print("CPF: ");
											String id = in.nextLine();

											System.out.print("Nascimento: ");
											String nascimento = in.nextLine();

											System.out.print("Rua: ");
											String rua = in.nextLine();

											System.out.print("Numero: ");
											int numero = in.nextInt();
											in.nextLine();

											System.out.print("Bairro: ");
											String bairro = in.nextLine();

											System.out.print("Cidade: ");
											String cidade = in.nextLine();

											System.out.print("Estado: ");
											String estado = in.nextLine();

											System.out.print("Telefone: ");
											String telefone = in.nextLine();

											System.out.print("Email: ");
											String email = in.nextLine();

											String senha;
											String senha2;

											do {

												System.out.print("Senha: ");
												senha = in.nextLine();

												System.out.print("Confime a Senha: ");
												senha2 = in.nextLine();

											} while ((senha.equals(senha2) != true));

											Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
											Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
											try {
												Fachada.getInstancia().cadastrarCliente(cliente1);
												contCliente++;
											} catch (OJEException e) {
												
												System.out.println(e.getMessage());
												
											}
											
											break;

										case '2':


											if (contCliente > 0) {
												System.out.println("Digite o ID do Cliente: ");
												String auxIdCliente = in.nextLine();

												try
												{
													
													Fachada.getInstancia().removerCliente(auxIdCliente);
													contCliente--;
													System.out.println("Cliente removido com sucesso");
													
												}
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
												}

											} else {
												System.out.println(
														"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
											}

											break; // TERMINO DO CASE 2 D
													// GERENCIAMENTO D CLIENTES

										case '3':

											String oldsenha, newsenha;
											int contla = 0;
											int blabla = 0;

											if (contCliente > 0) {
												
												System.out.println("Digite o id do cliente:");
												String idd = in.nextLine();
												
												Cliente c = new Cliente();
												
												try
												{
												
													c = Fachada.getInstancia().procurarCliente(idd);
													
													while (blabla != 3) {
														System.out.print("------------Atualizao cliente---------- \n");

														System.out.println("1 - Alterar endereco:");
														System.out.println("2 - Alterar senha:");
														System.out.println("3 - Sair");

														opcao = in.next().charAt(0);
														in.nextLine();

														switch (opcao) {

														case '1':

															System.out.println("Digite a rua:");
															String ruaa = in.nextLine();

															System.out.println("Digite o numero:");
															int numeroo = in.nextInt();
															in.nextLine();

															System.out.println("Digite o bairro:");
															String bairroo = in.nextLine();

															System.out.println("Digite a cidade:");
															String cidadee = in.nextLine();

															System.out.println("Digite o estado:");
															String estadoo = in.nextLine();

															System.out.println("Digite o telefone:");
															String telefonee = in.nextLine();

															Endereco endtwo = new Endereco(ruaa, bairroo, cidadee, estadoo,
																	numeroo, telefonee);
															
															try
															{
																
															Fachada.getInstancia().atualizarClienteendereco(idd,endtwo);
															System.out.println("Alteracao realizada com sucesso!");
															
															}catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
															}
															
															break;

														case '2':

															System.out.println(
																	"--------------Alteracao de Senha-------------\n");
															
																System.out.println("Digite a antiga senha");
																oldsenha = in.nextLine();

																System.out.println("Digite a senha nova");
																newsenha = in.nextLine();

																try
																{
																Fachada.getInstancia().alterarSenhaCliente(idd, oldsenha, newsenha);
																System.out.println("Senha modificado com sucesso");
																}
																catch(ONFException exc)
																{
																	System.out.println(exc.getMessage());
																}
																catch(WPException exc)
																{
																	System.out.println(exc.getMessage());
																}



															break;

														case '3':

															blabla = 3;
															break;

														default:
															System.out.println("Opcao invalida");
															break;

														}
													}
				
									
												
												}																								
												catch(ONFException exc)
												{
													System.out.println(exc.getMessage());
												}
											}
												else {
													System.out.println(
															"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
												}

											break;

										case '4':

											if (contCliente > 0) {
												System.out.println(Fachada.getInstancia().listarClientes());
												in.nextLine();
											} else {
												System.out.println(
														"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
											}

											break; // TERMINO DO CASE 4 D
													// GERENCIAMENTO D CLIENTES

										case '5':
											b10 = 5;
											break;

										default:
											System.out.println("Opcao invalida");
											break;

										}
									}

									
									break; // END DO CASE 2 GERENCIAR CLIENTES
									
								case '2':
									
									if( contCombo > 0 || contProduto > 0 || contPromoCombo > 0 || contPromoProduto > 0)
									{
										int v20 = 0;
										
										while (v20 != 3) {
										System.out.println(
												"=====================Gerenciar Vendas==================");
										System.out.println("1 - Fazer pedido");
										System.out.println("2 - Mostrar historico de vendas");
										System.out.println("3 - Sair");
										System.out.println("=====================\nDigite sua opcao:");

										opcao = in.next().charAt(0);
										in.nextLine();

											switch (opcao) {
										
											case '1':
												
												int aux40 = 0;
												int somethingcomprado = 0;
												
												System.out.println("Digite o id do cliente a fazer o pedido:");
												String tempId = in.nextLine();
												
												Cliente c1 = new Cliente();
												try {
													c1 = Fachada.getInstancia().procurarCliente(tempId);
												} catch (ONFException e) {
													
													System.out.println(e.getMessage());
												}
												
												if(c1.getId() != null)
												{
												contVenda++;
												Venda venda = new Venda(contVenda, tempId);
												
												while( aux40 != 6)
												{
													
												
												System.out.println("===========Compra==============");
												System.out.println("1 - Produto");
												System.out.println("2 - Combo");
												System.out.println("3 - Promocao de Produto");
												System.out.println("4 - Promocao de Combo");
												System.out.println("5 - Finalizar Compra");
												System.out.println("6 - Remover item do carrinho");
												System.out.println("7 - Listar pedidos ja feitos");
												System.out.println("8 - Cancelar Compra");
												System.out.println("\nDigite sua opcao:");
												
												opcao = in.next().charAt(0);
												in.nextLine();
												
												
												switch(opcao)
												{
													
												
													case '1':
														
														if (contProduto > 0) {
															System.out.println(
																	"----------Produtos----------\n" + Fachada.getInstancia().listarProdutos());
															
															
															try
															{
															System.out.println("\nDigite o codigo do Produto que voce deseja");
															String codigo = in.nextLine();
															
															Produto p = new Produto();
															
															p = Fachada.getInstancia().procurarProduto(codigo);
															
															venda.comprarProduto(p);
															somethingcomprado++;
															System.out.println("Pedido adicionado ao carrinho com sucesso");
															
															}	
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println(exc.getidObjeto());
															}
														

														} else {
															System.out.println("Nenhum produto cadastrado no estoque");
														}
														
														break; // BREAK DA FUNCAO DE COMPRA PRODUTO
														
														
													case '2':
														
														if( contCombo > 0)
														{
																											
															System.out.println(" ==================Combos =================\n" + Fachada.getInstancia().listarCombos());
														
															
															try
															{
																System.out.println("\nDigite o codigo do combo que voce deseja");
																String codigo = in.nextLine();
															
																Combo c = new Combo();
															
																c = Fachada.getInstancia().procurarCombo(codigo);

																venda.comprarCombo(c);
																somethingcomprado++;
																System.out.println("Pedido adicionado ao carrinho com sucesso");
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
															}
				
															
															
														}
														else
														{
															System.out.println("Nenhum combo cadastrado no estoque");
														}
														
														break; // BREAK DA FUNCAO DE COMPRA DE COMBO
														
													case '3':
														
														if( contPromoProduto > 0)
														{
															System.out.println("===============Promocoes de produto===========\n"
																	+ Fachada.getInstancia().listarProdutoPromotion());
															
															
															
															System.out.println("\nDigite o codigo da promocao desejada");
															String codigo = in.nextLine();
															
															PromocaoProduto pp = new PromocaoProduto();
															
															try
															{
																pp = Fachada.getInstancia().buscarPromocaoProduto(codigo);
																
																venda.comprarPromoProduto(pp);
																somethingcomprado++;
																System.out.println("Pedido adicionado ao carrinho com sucesso");
																
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto nao encontrado: " + exc.getidObjeto());
															}

				
															
														}
														else
														{
															System.out.println("Nenhuma promocao de produto cadastrada no estoque");
														}
														
														break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE PRODOUTO
														
														
													case '4':
														
														if( contPromoCombo > 0 )
														{
															System.out.println("============Promocoes de combo============\n"
																	+ Fachada.getInstancia().listarCombosPromotion());
															
															
															
															System.out.println("\nDigite o codigo da promocao desejada:");
															String codigo = in.nextLine();
															
															PromocaoCombo pc = new PromocaoCombo();
															try
															{
																
															pc = Fachada.getInstancia().buscarPromocaoCombo(codigo);
															venda.comprarPromoCombo(pc);
															somethingcomprado++;
															System.out.println("Pedido adicionado ao carrinho com sucesso");
															
															}
															catch(ONFException exc)
															{
																System.out.println(exc.getMessage());
																System.out.println("Id do objeto: " + exc.getidObjeto());
															}
											
														}
														else
														{
															System.out.println("Nenhuma promocao de produto cadastrada no estoque");
														}
														
														break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE COMBO
														
														
													case '5':
														
														
														if(somethingcomprado > 0)
														{
														
															System.out.println("O pedido tem o valor de: " + venda.getValorTotal() +"\n");
														boolean resultado100 = false;
														int contcompraerro = 0;
														do
														{
														System.out.println("Digite sua senha para confirmar o pedido");
														String confirmasenha = in.nextLine();
														
														boolean resultado1000 = false;
														try {
															resultado100 = Fachada.getInstancia().loginFuncionario(tempId2, confirmasenha);
															Fachada.getInstancia().cadastrarVenda(venda);
															
															
															
														} catch (ONFException e) {
															System.out.println(e.getMessage());
															
														} catch (WPException e) {
															
															System.out.println(e.getMessage());
														}
														
														}while( resultado100 == false);

															System.out.println("Compra realizada com sucesso\nPressione enter para continuar");
															in.nextLine();
															aux40 = 6;
														
		
														}
														else
														{
															System.out.println("Nenhum pedido realizado");
														}
														break; //
														
													case '6':
														if(somethingcomprado > 0)
														{
														int aux8000 = 0;
														
														while( aux8000 != 5)
														{
															
														
														System.out.println("===========Remover do carrinho==============");
														System.out.println("1 - Produto");
														System.out.println("2 - Combo");
														System.out.println("3 - Promocao de Produto");
														System.out.println("4 - Promocao de Combo");
														System.out.println("5 - Sair");
														System.out.println("\nDigite sua opcao:");
														
														opcao = in.next().charAt(0);
														in.nextLine();
														
														
														switch(opcao)
														{
														
														case '1':
															
															System.out.println("Digite o id do produto a ser removido");
															String onemoretime = in.nextLine();
															
															Produto p = new Produto();
															p = venda.BuscarProduto(onemoretime);
															
															if( p.getCodigo() != null)
															{
																somethingcomprado--;
																venda.removerProduto(onemoretime);
																System.out.println("Produto removido com sucesso");
															}
															else
															{
																System.out.println("pedido nao realizado");
															}
															
															
															
															
															break;
															
														case '2':
															
															System.out.println("Digite o id do combo a ser removido");
															String onemoretime1 = in.nextLine();
															
															Combo c = new Combo();
															c = venda.BuscarCombo(onemoretime1);
															
															if( c.getCodigo() != null)
															{
																somethingcomprado--;
																venda.removerCombo(onemoretime1);
																System.out.println("Combo removido com sucesso");
															}
															else
															{
																System.out.println("pedido nao realizado");
															}
															
															break;
															
														case '3':
															
															System.out.println("Digite o id da promocao de produto a ser removida");
															String onemoretime2 = in.nextLine();
															
															PromocaoProduto pp = new PromocaoProduto();
															pp = venda.BuscarPromoProduto(onemoretime2);
															
															if( pp.getIdPromocao() != null)
															{
																somethingcomprado--;
																venda.removerPromoProduto(onemoretime2);
																System.out.println("Promocao de produto removida com sucesso");
															}
															else
															{
																System.out.println("pedido nao realizado");
															}
															
															break;
															
														case '4':
															
															System.out.println("Digite o id da promocao de combo a ser removida");
															String onemoretime3 = in.nextLine();
															
															PromocaoCombo pc = new PromocaoCombo();
															pc = venda.BuscarPromoCombo(onemoretime3);
															
															if( pc.getIdPromocao() != null)
															{
																somethingcomprado--;
																venda.removerPromoCombo(onemoretime3);
																System.out.println("Promocao de combo removida com sucesso");
															}
															else
															{
																System.out.println("pedido nao realizado");
															}
															
															break;
															
															
														case '5':
															
															aux8000 = 5;
															break;
															
														default:
															System.out.println("Opcao invalida");
															
															break;
															
															
													
														
														}
													}
													}
														
													break;
													
													case '7':
														if(somethingcomprado > 0)
														{
															System.out.println(venda.toString());
															in.nextLine();
														}
														else
														{
															System.out.println("Nenhum pedido realizado");
														}
														
														break;
													
													case '8':
														
														contVenda--;
														aux40 = 6;
														
														break;
														
													default:
														System.out.println("Opcao invalida");							
														
														
												}						
												
												} // END DO WHILE
												
												}
												else
												{
													System.out.println("Cliente nao encontrado no sistema");
												}
											
												break; // END DO CASE DE FAZER PEDIDO
												
											case '2':
												
												if(contVenda > 0)
												{
													System.out.println(Fachada.getInstancia().listarVendas());
												}
												else
												{
													System.out.println("Nenhuma venda realizada");
												}
												break;
												
											case '3':
												
												v20 = 3;
												
												break;
												
											default:
												System.out.println("opcao invalida");
												break;
										
												
											}// END DO SWITCH PRINCIPAL
										
										
										}// END DO WHILE
									}// END DO IF
								else
								{
									System.out.println("Nenhum produto cadastrado no estoque");
								}
						
									
									break; // END DO CASE 3 GERENCIAR VENDAS
									
									
								case '3':
									auxfunc = 4;
									break; // END DO CASE 4
									
									
								default:
									
									System.out.println("Opcao invalida");
									
								break; // END DO DEFAULT
								
								
								
								} // END DO SWITWCH DE FUNCIONARIO
						
						} // END DO WHILE DE FUNCIONARIO
						
						}
						
						else {
							System.out.println("Nenhum Funcionario cadastrado no Sistema");
						}

						break;

					case '3':
						auxsomething = 3;
						break;

					default:

						System.out.println("Opcao invalida!");

						break;

					}
				}
				break;

			case '3':

				System.out.println("Obrigado, volte sempre!");
				in.nextLine();
				System.exit(0);

			default:

				System.out.println("Opcao Invalida!");

				break;
			}

		}

	}
}
