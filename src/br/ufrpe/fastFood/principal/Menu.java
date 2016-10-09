package br.ufrpe.fastFood.principal;
import java.util.Scanner;

import br.ufrpe.fastFood.beans.Admin;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;
import br.ufrpe.fastFood.dados.RepositorioProdutos;
import br.ufrpe.fastFood.dados.RepositorioVendas;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;
import br.ufrpe.fastFood.negocios.GerenciadorClientes;
import br.ufrpe.fastFood.negocios.GerenciadorFuncionarios;
import br.ufrpe.fastFood.negocios.GerenciadorProdutos;
import br.ufrpe.fastFood.negocios.GerenciadorVendas;

public class Menu {

	public static void main(String[] args) {

		int opcao = 0;
		boolean aux = false;

		GerenciadorClientes gerencliente = new GerenciadorClientes();
		GerenciadorFuncionarios gerenfunc = new GerenciadorFuncionarios();
		GerenciadorProdutos gerenprodutos = new GerenciadorProdutos();
		GerenciadorVendas gerenvendas = new GerenciadorVendas();
		
		Admin admin = new Admin("Carlos", "1234", "Admin123", "123");
		
		Scanner in = new Scanner(System.in);

		while (true) {

			System.out.println("-----------Seja Bem-vindo------------\n");
			System.out.println("1 - Auto Atendimento;");
			System.out.println("2 - Caixa;");
			System.out.println("3 - Encerrar.\n");
			System.out.print("Digite sua opção: ");

			opcao = in.nextInt();
			in.nextLine();

			switch (opcao) {

			case 1:

				int aux2 = 0;

				while (aux2 != 3) {
					
					System.out.println("-----------Auto Atendimento----------\n");
					System.out.println("1 - Cadastro;");
					System.out.println("2 - Login;");
					System.out.println("3 - Voltar;\n");
					System.out.print("Digite sua opção: ");
					
					opcao = in.nextInt();
					in.nextLine();
					
					switch (opcao) {

					case 1:

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
						break;

					case 2:

						boolean resultado1;
						String tempId , tempSenha;
						int contTentativas = 0;
						
						do{
							System.out.println("------------Login Cliente------------\n");

							System.out.print("Digite seu ID: ");
							tempId = in.nextLine();

							System.out.print("Digite sua senha: ");
							tempSenha = in.nextLine();

							resultado1 = gerencliente.loginCliente(tempId, tempSenha);
							
							if( resultado1 == false)
							{
								System.out.println("Senha incorreta!\n");
							}
							contTentativas++;
							
							if(contTentativas == 7)
							{
								break;
							}
							
						}while(resultado1 != true);
						
							if(contTentativas == 7)
							{
								break;
							}
								int aux30 = 0;
								while(aux30 != 3)
								{
								System.out.printf("-------Seja Bem-Vindo %s------- \n", gerencliente.nomeCliente(tempId));
								System.out.println("1 - Fazer um pedido");
								System.out.println("2 - Alterar senha");
								System.out.println("3 - Sair");
								System.out.print("\nDigite sua opção: ");
								
								opcao = in.nextInt();
								in.nextLine();
								
								switch (opcao) {
								
								case 1:
									try{
										System.out.println("----------Produtos----------\n" + gerenprodutos.listarProdutos());
									}
									catch(ObjectNotFound e)
									{
										System.out.println(e.getMessage());
									}
									
									in.nextLine();
									
									break;
									
								case 2:
									String oldsenha , newsenha;
									boolean result;
									int conterro1 = 0 , conterro2 = 0; 
									System.out.println("--------------Alteração de Senha-------------\n");
									do
									{
							
											System.out.println("Digite sua antiga senha");
											oldsenha = in.nextLine();
										
											System.out.println("Digite sua senha nova");
											newsenha = in.nextLine();	
											
											result = gerencliente.alterarSenha(tempId, newsenha);
											
											if(result == false)
											{
												System.out.println("Senha antiga incorreta\n");
											}
										
									}while(result != true);
									
									if ( result == true)
									{
										System.out.println("Senha modificado com sucesso");
									}
									
									in.nextLine();
									
									break;
									
								case 3:
									
									aux30 = 3;
									
								default:
									
									System.out.print("Opção Invalida!");
									
									break;
								}
							}
								
					case 3:
						aux2 = 3;
						break;
						
								
					default:
						System.out.println("Opção Invalida");
		
						}

				}
				
				break;
													
			case 2:
				int auxsomething = 0;
				while(auxsomething != 3)
				{
				System.out.println("-----------Caixa----------\n");
				System.out.println("1 - Login Administrador;");
				System.out.println("2 - Login Funcionario;");
				System.out.println("3 - Voltar;\n");
				System.out.print("Digite sua opção: ");
				opcao = in.nextInt();
				in.nextLine();

				switch (opcao) {

				case 1:
					int tentativas2 = 0;
					boolean end;
					System.out.println("------------Login Administrador------------\n");
					
					do
					{
						System.out.print("Digite seu ID: ");
						String tempIdAdmin = in.nextLine();
					
						
						System.out.print("Digite sua senha: ");
						String tempSenhaAdmin = in.nextLine();
						
						tentativas2++;
						end = admin.equalsSenhaAdmin(tempIdAdmin, tempSenhaAdmin);
						
						if( end == false)
						{
							System.out.println("Senha incorreta!\n");
						}
						
						if(tentativas2 == 7)
						{
							break;
						}
						
					
					}while(end != true);
					
					if(tentativas2 == 7)
					{
						break;
					}
					
					int auxadmin = 0;
					while(auxadmin != 10)
					{
						System.out.println("-----------Bem-Vindo-----------");
						System.out.println("1 - Adicionar funcionario");
						System.out.println("2 - Remover Funcionario");
						System.out.println("3 - Atualizar Funcionario");
						System.out.println("4 - listar Funcionarios");
						System.out.println("5 - Adicionar Produtos");
						System.out.println("6 - Remover Produto");
						System.out.println("7 - Listar Produtos");
						System.out.println("8 - Listar Clientes");
						System.out.println("9 - Remover Clientes");
						System.out.println(("10 - Deslogar como admin"));
						System.out.println("\nDigite sua opção: ");
						
						opcao = in.nextInt();
						in.nextLine();
						
						switch (opcao) {
						
						case 1:
							
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
								in.nextLine();
								
								System.out.print("Confime a Senha: ");
								senha2 = in.nextLine();
								in.nextLine();
																
							} while ((senha.equals(senha2) != true));
							
							Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
							Funcionario funcionario1 = new Funcionario(nome, id, nascimento, end1, senha);
							gerenfunc.cadastrar(funcionario1);
							
							break;
							
						case 2:
							
							System.out.println("Digite o ID do Funcionario: ");
							String auxIdFunc = in.nextLine();
							
							gerenfunc.remover(auxIdFunc);
							
							
							break;
							
						case 3:
							
							System.out.print("------------Atualização Funcionario---------- \n");

							System.out.print("Nome: ");
							String nome2 = in.nextLine();
							

							System.out.print("CPF: ");
							String id2 = in.nextLine();

							System.out.print("Nascimento: ");
							String nascimento2 = in.nextLine();

							System.out.print("Rua: ");
							String rua2 = in.nextLine();

							System.out.print("Numero: ");
							int numero2 = in.nextInt();
							in.nextLine();

							System.out.print("Bairro: ");
							String bairro2 = in.nextLine();
							

							System.out.print("Cidade: ");
							String cidade2 = in.nextLine();

							System.out.print("Estado: ");
							String estado2 = in.nextLine();

							System.out.print("Telefone: ");
							String telefone2 = in.nextLine();
							
							String senha4;
							String senha5;
							
							do {
								
								System.out.print("Senha: ");
								senha4 = in.nextLine();
								
								System.out.print("Confime a Senha: ");
								senha5 = in.nextLine();
																
							} while ((senha4.equals(senha5) != true));
							
							Endereco end2 = new Endereco(rua2, bairro2, cidade2, estado2, numero2, telefone2);
							Funcionario funcionario2 = new Funcionario(nome2, id2, nascimento2, end2, senha4);
							gerenfunc.atualizarFuncionario(funcionario2);
							
							break;
							
						case 4:
							
							gerenfunc.listarFuncionarios();
							in.nextLine();
							
							break;
							
						case 5:
							
							System.out.print("Nome do Produto: ");
							String nomeProd = in.nextLine();
							
							System.out.print("Codigo do Produto: ");
							String codigoProd = in.nextLine();
							
							System.out.print("Valor do Produto: ");
							Double valorProd = in.nextDouble();
							in.nextLine();
							
							Produto produto1 = new Produto(nomeProd, valorProd, codigoProd);
							gerenprodutos.cadastrar(produto1);
							
							break;
							
						case 6:
							
							System.out.println("Digite o Codigo do Produto: ");
							String auxCodigoProd = in.nextLine();
							
							gerenprodutos.remover(auxCodigoProd);
							
							
							break;
							
						case 7:
							
							gerenprodutos.listarProdutos();
							in.nextLine();
							
							break;
							
						case 10:
							auxadmin = 10;
							break;

						default:
							
							System.out.println("Opção invalida!");
							
							break;
						
						
					}
				}

					break;

				case 2:

					boolean result3;
					String tempId2 , tempSenha2;
					int tentativas3 = 0;
					do{

						System.out.println("------------Login Funcionario------------\n");
						
						System.out.println("Digite seu ID: ");
						tempId2 = in.nextLine();
						
						System.out.println("Digite sua senha: ");
						tempSenha2 = in.nextLine();
						
						tentativas3++;
						
						result3 = gerenfunc.loginFuncionario(tempId2, tempSenha2);
						
						if( result3 == false)
						{
							System.out.println("Senha ou id Incorretos");
						}
						
						if( tentativas3 == 7)
						{
							break;
						}		
										
						
					}while(result3 != true);

					if( tentativas3 == 7)
					{
						break;
					}		
					
					
					break;

				case 3:
					auxsomething = 3;
					break;

				default:

					System.out.println("OpÃ§Ã£o invalida!");

					break;
				
			}
		}
				break;

			case 3:

				System.out.println("Obrigado, volte sempre!");
				in.nextLine();
				System.exit(0);

			default:
				
				System.out.println("Opção Invalida!");
				
				break;
			}

		}
		
	}
	}
