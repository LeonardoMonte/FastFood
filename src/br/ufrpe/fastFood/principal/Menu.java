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

public class menu {

	public static void main(String[] args) {

		int opcao = 0;
		boolean aux = false;

		RepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();
		RepositorioFuncionarios repositorioFuncionario = RepositorioFuncionarios.getInstancia();
		RepositorioProdutos repositorioProdutos = RepositorioProdutos.getInstancia();
		RepositorioVendas repositorioVendas = RepositorioVendas.getInstancia();
		Admin admin = new Admin("Carlos", "123456", "Admin123", "carlos");
		
		Scanner in = new Scanner(System.in);

		while (!aux) {

			System.out.println("-----------Seja Bem-vindo------------\n");
			System.out.println("1 - Auto Atendimento;");
			System.out.println("2 - Caixa;");
			System.out.println("3 - Encerrar.\n");
			System.out.print("Digite sua opção: ");

			opcao = in.nextInt();

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
					
					switch (opcao) {

					case 1:

						System.out.print("------------Cadastro Cliente---------- \n");

						System.out.print("Nome: ");
						String nome = in.nextLine();
						in.nextLine();

						System.out.print("CPF: ");
						String id = in.nextLine();

						System.out.print("Nascimento: ");
						String nascimento = in.nextLine();

						System.out.print("Rua: ");
						String rua = in.nextLine();

						System.out.print("Numero: ");
						int numero = in.nextInt();

						System.out.print("Bairro: ");
						String bairro = in.nextLine();
						in.nextLine();

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
							in.nextLine();
							
							System.out.print("Confime a Senha: ");
							senha2 = in.nextLine();
							in.nextLine();
							
							
						} while ((senha.equals(senha2) != true));
						
						Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
						Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
						repositorioClientes.cadastrarCliente(cliente1);

						break;

					case 2:

						boolean play = false;

						while (!play) {

							System.out.println("------------Login Cliente------------\n");

							System.out.print("Digite seu ID: ");
							String tempId = in.nextLine();
							in.nextLine();

							System.out.print("Digite sua senha: ");
							String tempSenha = in.nextLine();

							Cliente auxCliente = repositorioClientes.buscarCliente(tempId);

							if ((auxCliente != null) && (auxCliente.getSenha().equals(tempSenha))) {
								
								play = true;
								
								System.out.printf("-------Seja Bem-Vindo %s------- \n", auxCliente.getNome());
								System.out.println("1 - Fazer um pedido");
								System.out.println("2 - Alterar senha");
								System.out.println("3 - Sair");
								System.out.print("\nDigite sua opção: ");
								
								opcao = in.nextInt();
								
								switch (opcao) {
								
								case 1:
									
									System.out.println("----------Produtos----------\n" + repositorioProdutos.listarProdutos());
									in.nextLine();
									
									break;

								default:
									
									System.out.print("Opção invalida!");
									
									break;
								}

							} else {

								System.out.println("O id ou a senha foi digitado incorretamente, tente novamente!");
							}
						}

						break;

					default:

						System.out.println("Opção invalida!");

						break;
					}					
				}
				
				break;
				
			case 2:

				System.out.println("-----------Caixa----------\n");
				System.out.println("1 - Login Administrador;");
				System.out.println("2 - Login Funcionario;");
				System.out.println("3 - Voltar;\n");
				System.out.print("Digite sua opção: ");
				opcao = in.nextInt();
				in.nextLine();

				switch (opcao) {

				case 1:
					
					System.out.println("------------Login Administrador------------\n");
					
					System.out.print("Digite seu ID: ");
					String tempIdAdmin = in.nextLine();
					
					
					System.out.print("Digite sua senha: ");
					String tempSenhaAdmin = in.nextLine();
					boolean teste = admin.equals(tempIdAdmin, tempSenhaAdmin);
					System.out.println(teste);
					if(!(admin.equals(tempIdAdmin, tempSenhaAdmin))){
						
						System.out.println("-----------Bem-Vindo-----------");
						System.out.println("1 - Adicionar funcionario");
						System.out.println("2 - Remover Funcionario");
						System.out.println("3 - listar Funcionarios");
						System.out.println("4 - Adicionar Produtos");
						System.out.println("5 - Remover Produto");
						System.out.println("6 - Listar Produtos");
						System.out.println("\nDigite sua opção: ");
						
						opcao = in.nextInt();
						
						switch (opcao) {
						
						case 1:
							
							System.out.print("------------Cadastro Funcionario---------- \n");

							System.out.print("Nome: ");
							String nome = in.nextLine();
							in.nextLine();

							System.out.print("CPF: ");
							String id = in.nextLine();

							System.out.print("Nascimento: ");
							String nascimento = in.nextLine();

							System.out.print("Rua: ");
							String rua = in.nextLine();

							System.out.print("Numero: ");
							int numero = in.nextInt();

							System.out.print("Bairro: ");
							String bairro = in.nextLine();
							in.nextLine();

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
							repositorioFuncionario.cadastrarFuncionario(funcionario1);
							
							break;
							
						case 2:
							
							System.out.println("Digite o ID do Funcionario: ");
							String auxIdFunc = in.nextLine();
							in.nextLine();
							
							if(repositorioFuncionario.buscarFuncionario(auxIdFunc).getId().equals(auxIdFunc)){
								
								repositorioFuncionario.removerFuncionario(auxIdFunc);
							}
							
							break;
							
						case 3:
							
							repositorioFuncionario.listarFuncinario();
							in.hasNext();
							
							break;
							
						case 4:
							
							System.out.print("Nome do Produto: ");
							String nomeProd = in.nextLine();
							
							System.out.print("Codigo do Produto: ");
							String codigoProd = in.nextLine();
							
							System.out.print("Valor do Produto: ");
							Double valorProd = in.nextDouble();
							
							Produto produto1 = new Produto(nomeProd, valorProd, codigoProd);
							repositorioProdutos.cadastrar(produto1);
							
							break;
							
						case 5:
							
							System.out.println("Digite o Codigo do Produto: ");
							String auxCodigoProd = in.nextLine();
							in.nextLine();
							
							if(repositorioProdutos.buscarProduto(auxCodigoProd).getCodigo().equals(auxCodigoProd)){
								
								repositorioProdutos.removerProduto(auxCodigoProd);
							}
							
							break;
							
						case 6:
							
							repositorioProdutos.listarProdutos();
							in.nextLine();
							
							break;

						default:
							
							System.out.println("Opção invalida!");
							
							break;
						}
						
					}else{
						
						System.out.println("Deu merda!");
						in.nextLine();
					}

					break;

				case 2:

					boolean play = false;

					while (!play) {

						System.out.println("------------Login Funcionario------------\n");
						
						System.out.println("Digite seu ID: ");
						String tempId = in.nextLine();
						in.nextLine();
						
						System.out.println("Digite sua senha: ");
						String tempSenha = in.nextLine();
						
						Funcionario auxFuncionario = repositorioFuncionario.buscarFuncionario(tempId);
						if ((auxFuncionario != null) && (auxFuncionario.getSenha().equals(tempSenha))) {
							play = true;

							// Continuação do codigo...
							// Tela de venda do produto...

						} else {

							System.out.println("O id ou a senha foi digitado incorretamente, tente novamente!");
						}
					}

					break;

				case 3:

					play = true;

					break;

				default:

					System.out.println("Opção invalida!");

					break;
				}

				break;

			case 3:

				System.out.println("Obrigado, volte sempre!");
				aux = true;

				break;

			default:
				
				System.out.println("Opção invalida!");

				break;
			}

		}
		
		in.close();
	}
}
