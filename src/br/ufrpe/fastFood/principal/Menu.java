package br.ufrpe.fastFood.principal;

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
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.dados.RepositorioVendas;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;
import br.ufrpe.fastFood.negocios.GerenciadorClientes;
import br.ufrpe.fastFood.negocios.GerenciadorCombos;
import br.ufrpe.fastFood.negocios.GerenciadorFuncionarios;
import br.ufrpe.fastFood.negocios.GerenciadorProdutos;
import br.ufrpe.fastFood.negocios.GerenciadorPromocoes;
import br.ufrpe.fastFood.negocios.GerenciadorVendas;
import br.ufrpe.fastFood.interfaces.RepositorioClienteInterface;
import br.ufrpe.fastFood.interfaces.RepositorioFuncionarioInterface;
import br.ufrpe.fastFood.interfaces.RepositorioProdutoInterface;
import br.ufrpe.fastFood.interfaces.RepositorioVendaInterface;;


public class Menu {

	public static void main(String[] args) {

		char opcao;
		int contFunc = 0, contCliente = 0, contProduto = 0, contVenda = 0 , contCombo = 0 , contPromoCombo = 0 , contPromoProduto = 0;

		GerenciadorClientes gerencliente = new GerenciadorClientes();
		GerenciadorFuncionarios gerenfunc = new GerenciadorFuncionarios();
		GerenciadorProdutos gerenprodutos = new GerenciadorProdutos();
		GerenciadorVendas gerenvendas = new GerenciadorVendas();
		GerenciadorCombos gerencombos = new GerenciadorCombos();
		GerenciadorPromocoes gerenpromocoes  = new GerenciadorPromocoes();

		Admin admin = new Admin("Carlos", "1234", "Admin123", "123");

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out.println("-----------Seja Bem-vindo------------\n");
			System.out.println("1 - Auto Atendimento;");
			System.out.println("2 - Caixa;");
			System.out.println("3 - Encerrar.\n");
			System.out.print("Digite sua op��o: ");

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
					System.out.print("Digite sua op��o: ");

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
						gerencliente.cadastrar(cliente1);
						contCliente++;
						break;

					case '2':

						if (contCliente > 0) {
							boolean resultado1;
							String tempId, tempSenha;
							int contTentativas = 0;

							do {
								System.out.println("------------Login Cliente------------\n");

								System.out.print("Digite seu ID: ");
								tempId = in.nextLine();

								System.out.print("Digite sua senha: ");
								tempSenha = in.nextLine();

								resultado1 = gerencliente.loginCliente(tempId, tempSenha);

								if (resultado1 == false) {
									System.out.println("Senha incorreta!\n");
								}
								contTentativas++;

								if (contTentativas == 7) {
									break;
								}

							} while (resultado1 != true);

							if (contTentativas == 7) {
								break;
							}
							int aux30 = 0;
							while (aux30 != 3) {
								System.out.printf("-------Seja Bem-Vindo %s------- \n",
										gerencliente.nomeCliente(tempId));
								System.out.println("1 - Fazer um pedido");
								System.out.println("2 - Alterar senha");
								System.out.println("3 - Sair");
								System.out.print("\nDigite sua op��o: ");

								opcao = in.next().charAt(0);
								in.nextLine();

								switch (opcao) {

								case '1':
									int aux40 = 0;
									
									Venda venda = new Venda(contVenda);
									
									while( aux40 != 6)
									{
										
									
									System.out.println("===========Compra==============");
									System.out.println("1 - Produto");
									System.out.println("2 - Combo");
									System.out.println("3 - Promocao de Produto");
									System.out.println("4 - Promocao de Combo");
									System.out.println("5 - Finalizar Compra");
									System.out.println("6 - Cancelar Compra");
									System.out.println("\nDigite sua opcao:");
									
									opcao = in.next().charAt(0);
									in.nextLine();
									
									switch(opcao)
									{
										
										case '1':
											
											if (contProduto > 0) {
												System.out.println(
														"----------Produtos----------\n" + gerenprodutos.listarProdutos());
												in.nextLine();
												
												
												System.out.println("Digite o codigo do Produto que voce deseja");
												String codigo = in.nextLine();
												
												Produto p = new Produto();
												
												p = gerenprodutos.procurar(codigo);
												
												if( p.getCodigo() != null)
												{
													venda.comprarProduto(p);
												}
												else
												{
													System.out.println("Ops");
												}
					
												
												

											} else {
												System.out.println("Nenhum produto cadastrado no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA PRODUTO
											
											
										case '2':
											
											if( contCombo > 0)
											{
																								
												System.out.println(" ==================Combos =================\n" + gerencombos.listarCombos());
											
												in.nextLine();
												
												System.out.println("Digite o codigo do combo que voce deseja");
												String codigo = in.nextLine();
												
												Combo c = new Combo();
												
												c = gerencombos.procurarCombo(codigo);
												
												if( c.getCodigo() != null )
												{
													venda.comprarCombo(c);
												}
												else
												{
													System.out.println("ops");
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
														+ gerenpromocoes.listarProdutoPromotion());
												
												in.nextLine();
												
												System.out.println("Digite o codigo da promocao desejada");
												String codigo = in.nextLine();
												
												PromocaoProduto pp = new PromocaoProduto();
												
												pp = gerenpromocoes.buscarPromocaoProduto(codigo);
												
												if( pp.getIdPromocao() != null)
												{
													venda.comprarPromoProduto(pp);
												}
												else
												{
													System.out.println("ops");
												}
												
											}
											else
											{
												System.out.println("Nenhuma promocao de combo cadastrada no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE PRDOUTO
											
											
										case '4':
											
											if( contPromoCombo > 0 )
											{
												System.out.println("============Promocoes de combo============\n"
														+ gerenpromocoes.listarCombosPromotion());
												
												in.nextLine();
												
												System.out.println("Digite o codigo da promocao desejada:");
												String codigo = in.nextLine();
												
												PromocaoCombo pc = new PromocaoCombo();
												pc = gerenpromocoes.buscarPromocaoCombo(codigo);
												
												if( pc.getIdPromocao() != null)
												{
													venda.comprarPromoCombo(pc);
												}
												else
												{
													System.out.println("ops");
												}
												
												
											}
											else
											{
												System.out.println("Nenhuma promocao de produto cadastrada no estoque");
											}
											
											break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE COMBO
											
											
										case '5':
											
											
											break; //
											
											
										case '6':
											
											aux40 = 6;
											
											break;
											
										default:
											System.out.println("Opcao invalida");							
											
											
									}						
									
									} // END DO WHILE
									
									
									
									break;

								case '2':
									String oldsenha, newsenha;
									boolean result;
									int contla = 0;
									System.out.println("--------------Altera��o de Senha-------------\n");
									do {

										System.out.println("Digite sua antiga senha");
										oldsenha = in.nextLine();

										System.out.println("Digite sua senha nova");
										newsenha = in.nextLine();

										result = gerencliente.alterarSenha(tempId, oldsenha, newsenha);

										if (result == false) {
											System.out.println("Senha antiga incorreta\n");
											contla++;

										}
										if (contla > 6) {
											break;
										}

									} while (result != true);

									if (result == true) {
										System.out.println("Senha modificado com sucesso");
									} else {
										System.out.println("Senha n�o foi modificada");
									}

									in.nextLine();

									break;

								case '3':

									aux30 = 3;

								default:

									System.out.print("Op��o Invalida!");

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
						System.out.println("Op��o Invalida");

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
					System.out.print("Digite sua op��o: ");
					opcao = in.next().charAt(0);
					in.nextLine();

					switch (opcao) {

					case '1':
						int tentativas2 = 0;
						boolean end;
						System.out.println("------------Login Administrador------------\n");

						do {
							System.out.print("Digite seu ID: ");
							String tempIdAdmin = in.nextLine();

							System.out.print("Digite sua senha: ");
							String tempSenhaAdmin = in.nextLine();

							tentativas2++;
							end = admin.equalsSenhaAdmin(tempIdAdmin, tempSenhaAdmin);

							if (end == false) {
								System.out.println("Senha incorreta!\n");
							}

							if (tentativas2 == 7) {
								break;
							}

						} while (end != true);

						if (tentativas2 == 7) {
							break;
						}

						int auxadmin = 0;
						while (auxadmin != 10) {
							System.out.println("-----------Bem-Vindo-----------");
							System.out.println("1 - Gerenciar funcionarios");
							System.out.println("2 - Gerenciar produtos");
							System.out.println("3 - Gerenciar clientes");
							System.out.println("4 - Gerenciar vendas");
							System.out.println(("s - Deslogar como admin"));
							System.out.println("\nDigite sua op��o: ");

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
									System.out.println("======================\nDigite sua op��o:");

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
										gerenfunc.cadastrar(funcionario1);
										contFunc++;

										break; // TERMINO DO CASE 1 DO
												// GERENCIAMENTO D FUNCIONARIOS

									case '2':

										if (contFunc > 0) {
											System.out.println("Digite o ID do Funcionario: ");
											String auxIdFunc = in.nextLine();

											boolean a1 = gerenfunc.remover(auxIdFunc);

											if (a1 == true) {
												contFunc--;
												System.out.println("Funcionario removido com sucesso");
											} else {
												System.out.println("Funcionario nao removido");
											}
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema naoo possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 2 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '3':

										String oldsenha, newsenha;
										boolean result;
										int contla = 0;
										int blabla = 0;

										if (contFunc > 0) {
											System.out.println("Digite o id do funcionario:");
											String idd = in.nextLine();
											boolean resul = gerenfunc.existe(idd);

											if (resul == true) {
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
														boolean allritgh = gerenfunc.atualizarFuncionario(idd, endtwo);

														if (allritgh == true) {
															System.out.println("Altera��o realizada com sucesso!");
														} else {
															System.out.println("Falha ao realizar altera��o");
														}

														in.nextLine();

														break;

													case '2':

														System.out.println(
																"--------------Altera��o de Senha-------------\n");
														do {

															System.out.println("Digite sua antiga senha");
															oldsenha = in.nextLine();

															System.out.println("Digite sua senha nova");
															newsenha = in.nextLine();

															result = gerenfunc.alterarSenha(idd, oldsenha, newsenha);

															if (result == false) {
																System.out.println("Senha antiga incorreta\n");
																contla++;

															}
															if (contla > 6) {
																break;
															}

														} while (result != true);

														if (result == true) {
															System.out.println("Senha modificado com sucesso");
														} else {
															System.out.println("Senha n�o foi modificada");
														}

														in.nextLine();

														break;

													case '3':

														blabla = 3;
														break;

													default:
														System.out.println("Op��o invalida");
														break;

													}
												}
											} else {
												System.out.println("Usuario n�o encontrado no sistema");
											}
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 3 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '4':

										if (contFunc > 0) {
											System.out.println(gerenfunc.listarFuncionarios());
											in.nextLine();
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D FUNCIONARIOS

									case '5':

										b30 = 5;
										break;// fun��o d sair

									default:
										System.out.println("Op��o invalida");
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
									System.out.println("=====================\nDigite sua op��o:");

									opcao = in.next().charAt(0);
									in.nextLine();

									switch (opcao) {

									case '1':
										
										
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

												Produto produto1 = new Produto(nomeProd, valorProd, codigoProd);
												gerenprodutos.cadastrar(produto1);
												contProduto++;
												
												break;
												
											
											case '2':
												
												
											
										
										
										}
										
										
										
										

										break; // TERMINO DO CASE 1 D
												// GERENCIAMENTO D PRODUTOS

									case '2':

										if (contProduto > 0) {

											System.out.println("Digite o Codigo do Produto: ");
											String auxCodigoProd = in.nextLine();

											boolean a2 = gerenprodutos.remover(auxCodigoProd);

											if (a2 == true) {
												contProduto--;
												System.out.println("Produto removido com sucesso");
											} else {
												System.out.println("Produto n�o removido");
											}
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui produtos cadastrados");
										}

										break; // TERMINO DO CASE 2 D
												// GERENCIAMENTO D PRODUTOS

									case '3':

										break;

									case '4':

										if (contProduto > 0) {
											System.out.println(gerenprodutos.listarProdutos());
											in.nextLine();
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui produtos cadastrados");
										}

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D PRODUTOS

									case '5':
										b20 = 5;
										break;// CASE SAIR

									default:
										System.out.println("Op��o invalida");

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
									System.out.println("=================\nDigite sua op��o:");

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
										gerencliente.cadastrar(cliente1);
										contCliente++;
										break;

									case '2':

										if (contCliente > 0) {
											System.out.println("Digite o ID do Cliente: ");
											String auxIdCliente = in.nextLine();

											boolean a3 = gerencliente.remover(auxIdCliente);

											if (a3 == true) {
												contCliente--;
												System.out.println("Cliente removido com sucesso");
											} else {
												System.out.println("Cliente n�o removido");
											}
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 2 D
												// GERENCIAMENTO D CLIENTES

									case '3':

										String oldsenha, newsenha;
										boolean result;
										int contla = 0;
										int blabla = 0;

										if (contCliente > 0) {
											System.out.println("Digite o id do cliente:");
											String idd = in.nextLine();
											boolean resul = gerencliente.existeC(idd);

											if (resul == true) {
												while (blabla != 3) {
													System.out.print("------------Atualiza��o cliente---------- \n");

													System.out.println("1 - Alterar endere�o:");
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
														boolean allritgh = gerencliente.atualizarClienteendereco(idd,
																endtwo);

														if (allritgh == true) {
															System.out.println("Altera��o realizada com sucesso!");
														} else {
															System.out.println("Falha ao realizar altera��o");
														}

														in.nextLine();

														break;

													case '2':

														System.out.println(
																"--------------Altera��o de Senha-------------\n");
														do {

															System.out.println("Digite a antiga senha");
															oldsenha = in.nextLine();

															System.out.println("Digite a senha nova");
															newsenha = in.nextLine();

															result = gerencliente.alterarSenha(idd, oldsenha, newsenha);

															if (result == false) {
																System.out.println("Senha antiga incorreta\n");
																contla++;

															}
															if (contla > 6) {
																break;
															}

														} while (result != true);

														if (result == true) {
															System.out.println("Senha modificado com sucesso");
														} else {
															System.out.println("Senha n�o foi modificada");
														}

														in.nextLine();

														break;

													case '3':

														blabla = 3;
														break;

													default:
														System.out.println("Op��o invalida");
														break;

													}
												}
											} else {
												System.out.println("Usuario n�o encontrado no sistema");
											}
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 3 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '4':

										if (contCliente > 0) {
											System.out.println(gerencliente.listarClientes());
											in.nextLine();
										} else {
											System.out.println(
													"Impossivel realizar a��o, o sistema n�o possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 4 D
												// GERENCIAMENTO D CLIENTES

									case '5':
										b10 = 5;
										break;

									default:
										System.out.println("Op��o invalida");
										break;

									}
								}

								break;// BREAK DO TERMINO DO CASE D CLIENTES
							
								
							case '5':
								
								
								
								
								
								
								
								break; // BREAK DO TERMINO DO CASE DE GERENCIAMENTO DE VENDAS
								
							case 's':
								auxadmin = 10;
								break;

							default:

								System.out.println("Op��o invalida!");

								break;

							}
						}

						break;// TERMINO DA FUN��O D LOGIN POR ADIMINSTRADOR

					case '2':
						if (contFunc > 0) {
							boolean result3;
							String tempId2, tempSenha2;
							int tentativas3 = 0;
							do {

								System.out.println("------------Login Funcionario------------\n");

								System.out.println("Digite seu ID: ");
								tempId2 = in.nextLine();

								System.out.println("Digite sua senha: ");
								tempSenha2 = in.nextLine();

								tentativas3++;

								result3 = gerenfunc.loginFuncionario(tempId2, tempSenha2);

								if (result3 == false) {
									System.out.println("Senha ou id Incorretos");
								}

								if (tentativas3 == 7) {
									break;
								}

							} while (result3 != true);

							if (tentativas3 == 7) {
								break;
							}
						} else {
							System.out.println("Nenhum Funcionario cadastrado no Sistema");
						}

						break;

					case '3':
						auxsomething = 3;
						break;

					default:

						System.out.println("Opção invalida!");

						break;

					}
				}
				break;

			case '3':

				System.out.println("Obrigado, volte sempre!");
				in.nextLine();
				System.exit(0);

			default:

				System.out.println("Op��o Invalida!");

				break;
			}

		}

	}
}
