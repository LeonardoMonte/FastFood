package br.ufrpe.fastFood.principal;
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
					System.out.print("Digite sua opï¿½ï¿½o: ");

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
								System.out.print("\nDigite sua opï¿½ï¿½o: ");

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
											
											break; // BREAK DA FUNCAO DE COMPRA DE PROMOCAO DE PRODOUTO
											
											
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
									System.out.println("--------------Alteracao de Senha-------------\n");
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
										System.out.println("Senha nï¿½o foi modificada");
									}

									in.nextLine();

									break;

								case '3':

									aux30 = 3;

								default:

									System.out.print("Opï¿½ï¿½o Invalida!");

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
															System.out.println("Alteracao realizada com sucesso!");
														} else {
															System.out.println("Falha ao realizar alteracao");
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
															System.out.println("Senha nao foi modificada");
														}

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
											} else {
												System.out.println("Usuario nao encontrado no sistema");
											}
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui funcionarios cadastrados");
										}

										break; // TERMINO DO CASE 3 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '4':

										if (contFunc > 0) {
											System.out.println(gerenfunc.listarFuncionarios());
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

												Produto produto1 = new Produto(nomeProd, valorProd, codigoProd);
												gerenprodutos.cadastrar(produto1);
												contProduto++;
												
												break;
												
											
											case '2':
												
												if( contProduto > 2)
												{
														
												System.out.println("Nome do Combo: ");
												String nomeCombo = in.nextLine();
												
												System.out.println("Codigo do Combo: ");
												String codigoCombo = in.nextLine();
												
												Combo combo1 = new Combo(nomeCombo , codigoCombo);
												
												System.out.println("Deseja listar os produtos ja cadastrados para auxiliar na criacao do combo ? (S/N)");
												char resposta = in.next().charAt(0);
												in.nextLine();
												
												if( resposta == 'S' || resposta == 's')
												{
													System.out.println(gerenprodutos.listarProdutos());
												}
												
												int contcadastrocombo = 0;
												boolean result = true;
												Produto produto2 = new Produto();
												do
												{
													
													
													System.out.println("Digite o codigo do produto a ser adicionado no combo");
													String volatcode = in.nextLine();
													
													produto2 = gerenprodutos.procurar(volatcode);
													
													
													
													if(produto2.getCodigo() != null)
													{
														combo1.addItens(produto2);
														
														System.out.println("Produto adicionado ao combo com sucesso");
														contcadastrocombo++;
	
													}
													else
													{
														System.out.println("Produto não encontrado no estoque");
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
												
												gerencombos.cadastrarCombo(combo1);
												contCombo++;
												
												}
												else
												{
													System.out.println("Impossivel criar um combo, devido a falta de produtos em estoque");
												}
												
												break;// TERMINO DO CASE 2 DO ADICIONAR
												
											case '3':
												
												if( contCombo >= 1)
												{
												
													
													System.out.println("Digite o id do combo a entrar em promocão:");
													String idcombo1 = in.nextLine();
													
													Combo combo1 = new Combo();
													combo1 = gerencombos.procurarCombo(idcombo1);
													
													if( combo1.getNome() != null)
													{
														System.out.println("Digite o id da promocao do combo:");
														String idpromocombo = in.nextLine();
														
														System.out.println("Digite o valor da promocao:");
														Double valorpromocombo = in.nextDouble();
														in.nextLine();
														
														LocalDate creation = LocalDate.now();
														
														PromocaoCombo promocombo = new PromocaoCombo(idpromocombo, creation, combo1, valorpromocombo);
														
														contPromoCombo++;
														
														gerenpromocoes.cadastrarCombo(promocombo);
														
														System.out.println("Promocao de combo cadastrada com sucesso");
														
													}
													else
													{
														System.out.println("Combo nao encontrado no estoque");
													}
					
													
												}
												else
												{
													System.out.println("Impossivel realizar a ação por falta de combos no estoque");
												}
												
												break;// TERMINO DO CASE DE ADICIONAR PROMOCÃO DE COMBOS
												
											case '4':
												
												if( contProduto >= 1)
												{
												
													
													System.out.println("Digite o id do produto a entrar em promocão:");
													String idproduto1 = in.nextLine();
													
													Produto produto2 = new Produto();
													produto2 = gerenprodutos.procurar(idproduto1);
													
													if( produto2.getNome() != null)
													{
														System.out.println("Digite o id da promocao do produto:");
														String idpromoprodutos = in.nextLine();
														
														System.out.println("Digite o valor da promocao:");
														Double valorpromoproduto = in.nextDouble();
														in.nextLine();
														
														LocalDate creation = LocalDate.now();
														
														PromocaoProduto promoproduto = new PromocaoProduto(idpromoprodutos, creation, produto2, valorpromoproduto);
														
														gerenpromocoes.cadastrarProduto(promoproduto);
														
														contPromoProduto++;
														
														System.out.println("Promocao de produto cadastrada com sucesso");
														
													}
													else
													{
														System.out.println("Produto nao encontrado no estoque");
													}
					
													
												}
												else
												{
													System.out.println("Impossivel realizar a ação por falta de produtos no estoque");
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

													boolean a2 = gerenprodutos.remover(auxCodigoProd);

													if (a2 == true) {
														contProduto--;
														System.out.println("Produto removido com sucesso");
													} else {
														System.out.println("Produto nao removido");
													}
												} else {
													System.out.println(
															"Impossivel realizar acao, o sistema nao possui produtos cadastrados");
												}

												break; 
												
											case '2':
												
												if( contCombo > 0 )
												{
													System.out.println("Digite o codigo do combo a ser removido:");
													String auxCodigoCombo = in.nextLine();
													
													boolean z1 = gerencombos.removerCombo(auxCodigoCombo);
													
													if(z1 == true)
													{
														contCombo--;
														System.out.println("Combo removido com sucesso");
													}
													else
													{
														System.out.println("Combo nao removido");
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
													
													boolean z2 = gerenpromocoes.removerCombo(auxCodigopromocombo);
													
													if(z2 == true)
													{
														contPromoCombo--;
														System.out.println("Promocao de combo removida com sucesso");
													}
													else
													{
														System.out.println("Promocao de combo nao removida");
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
													
													boolean z3 = gerenpromocoes.removerProduto(auxCodigopromoproduto);
													
													if(z3 == true)
													{
														contPromoProduto--;
														System.out.println("Promocao de produto removida com sucesso");
													}
													else
													{
														System.out.println("Promocao de produto nao removida");
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
													
													boolean result = gerenprodutos.existeProduto(idprodutoalterado);
													
													if( result == true)
													{
														System.out.println("Digite o novo valor do produto");
														double newvalor = in.nextDouble();
														in.nextLine();
														
														boolean result2 = gerenprodutos.atualizarProduto(newvalor, idprodutoalterado);
														
														if(result2 == true)
														{
															System.out.println("Preco alterado com suceso");
														}
														else
														{
															System.out.println("Preco nao alterado");
														}
														
													}
													else
													{
														System.out.println("Produto nao encontrado no estoque");
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
															
															boolean resultwo = gerencombos.Existecombo(codigocombo);
															
															if(resultwo == true)
															{
																
															System.out.println("Digite o codigo do produto a ser adicionado no combo");
															String codigoproduto = in.nextLine();
															
															boolean resultone = gerenprodutos.existeProduto(codigoproduto);
															
															if(resultone == true)
															{
																Produto produto = new Produto();
																produto = gerenprodutos.procurar(codigoproduto);
																
																boolean helpme = gerencombos.AdicionarProduto(produto, codigocombo);
																
																if(helpme == true)
																{
																	System.out.println("Produto adicionado com sucesso");
																}
																else
																{
																	System.out.println("Produto nao adicionado");
																}
																
															}
															else
															{
																System.out.println("Produto nao encontrado no sistema");
															}
															}
															else
															{
																System.out.println("Combo nao encontrado no sistema");
															}
															
															break;
															
														case '2':
															
															System.out.println("Digite o codigo do combo:");
															String codigocombo1 = in.nextLine();
															
															boolean resultwo1 = gerencombos.Existecombo(codigocombo1);
															
															if(resultwo1 == true)
															{
																
															System.out.println("Digite o codigo do produto a ser removido no combo");
															String codigoproduto1 = in.nextLine();
															
															boolean resultone1 = gerenprodutos.existeProduto(codigoproduto1);
															
															if(resultone1 == true)
															{
																Produto produto1 = new Produto();
																produto1 = gerenprodutos.procurar(codigoproduto1);
																
																boolean help = gerencombos.RemoverProduto(produto1, codigocombo1);
																
																if(help == true)
																{
																	System.out.println("Produto removido com sucesso");
																}
																else
																{
																	System.out.println("Produto nao removido");
																}
																
															}
															else
															{
																System.out.println("Produto nao encontrado no sistema");
															}
															}
															else
															{
																System.out.println("Combo nao encontrado no sistema");
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
													
													boolean result = gerenpromocoes.Existepromocombo(idpromocombo);
													
													if( result == true)
													{
														System.out.println("Digite o novo valor da promocao de combo");
														double newvalor = in.nextDouble();
														in.nextLine();
														
														boolean result2 = gerenpromocoes.alterarPrecoPromoCombo(newvalor, idpromocombo);
														
														if(result2 == true)
														{
															System.out.println("Preco alterado com suceso");
														}
														else
														{
															System.out.println("Preco nao alterado");
														}
														
													}
													else
													{
														System.out.println("Promocao de combo nao encontrada no estoque");
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
													
													boolean result = gerenpromocoes.Existepromoproduto(idpromoproduto);
													
													if( result == true)
													{
														System.out.println("Digite o novo valor da promocao de produto");
														double newvalor = in.nextDouble();
														in.nextLine();
														
														boolean result2 = gerenpromocoes.alterarPrecoPromoProduto(newvalor, idpromoproduto);
														
														if(result2 == true)
														{
															System.out.println("Preco alterado com suceso");
														}
														else
														{
															System.out.println("Preco nao alterado");
														}
														
													}
													else
													{
														System.out.println("Promocao de combo nao encontrada no estoque");
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
													System.out.println(gerenprodutos.listarProdutos());
												}
												else
												{
													System.out.println("Nenhum produto cadastrado no estoque");
												}
												
											break;
											
											case '2':
												
											if(contCombo >= 1)
											{
												System.out.println(gerencombos.listarCombos());
											}
											else
											{
												System.out.println("Nenhum combo cadastrado no estoque");
											}
											
										break;
										
											case '3':
												
											if(contPromoCombo >= 1)
											{
												System.out.println(gerenpromocoes.listarCombosPromotion());
											}
											else
											{
												System.out.println("Nenhuma promocao de combo cadastrado no estoque");
											}
											
										break;
										
											case '4':
												
											if(contPromoProduto >= 1)
											{
												System.out.println(gerenpromocoes.listarProdutoPromotion());
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
												System.out.println("Cliente nao removido");
											}
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
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
														boolean allritgh = gerencliente.atualizarClienteendereco(idd,
																endtwo);

														if (allritgh == true) {
															System.out.println("Alteracao realizada com sucesso!");
														} else {
															System.out.println("Falha ao realizar alteracao");
														}

														in.nextLine();

														break;

													case '2':

														System.out.println(
																"--------------Alteracao de Senha-------------\n");
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
															System.out.println("Senha nao foi modificada");
														}

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
											} else {
												System.out.println("Usuario nao encontrado no sistema");
											}
										} else {
											System.out.println(
													"Impossivel realizar acao, o sistema nao possui clientes cadastrados");
										}

										break; // TERMINO DO CASE 3 DE
												// GERENCIAMENTO D FUNCIONARIOS

									case '4':

										if (contCliente > 0) {
											System.out.println(gerencliente.listarClientes());
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
										System.out.println("Opï¿½ï¿½o invalida");
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

								System.out.println("Opï¿½ï¿½o invalida!");

								break;

							}
						}

						break;// TERMINO DA FUNï¿½ï¿½O D LOGIN POR ADIMINSTRADOR

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

						System.out.println("OpÃ§Ã£o invalida!");

						break;

					}
				}
				break;

			case '3':

				System.out.println("Obrigado, volte sempre!");
				in.nextLine();
				System.exit(0);

			default:

				System.out.println("Opï¿½ï¿½o Invalida!");

				break;
			}

		}

	}
}
