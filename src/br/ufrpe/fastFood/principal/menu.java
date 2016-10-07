package br.ufrpe.fastFood.principal;

import java.util.Scanner;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.dados.RepositorioClientes;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;

public class menu {

	public static void main(String[] args) {

		int opcao = 0;
		boolean aux = false;

		RepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();
		RepositorioFuncionarios repositorioFuncionario = RepositorioFuncionarios.getInstancia();

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

				boolean aux2 = false;

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
					System.out.print("Senha: ");
					String senha = in.nextLine();

					Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
					Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
					repositorioClientes.cadastrarCliente(cliente1);

					break;

				case 2:

					boolean play = false;

					while (!play) {

						System.out.println("------------Login Cliente------------\n");
						System.out.println("Digite seu ID: ");
						String tempId = in.nextLine();
						System.out.println("Digite sua senha: ");
						String tempSenha = in.nextLine();

						Cliente auxId = repositorioClientes.buscarCliente(tempId);

						if ((auxId != null) && (auxId.getSenha().contains(tempSenha))) {
							play = true;

							// Continuação do codigo...

						} else {

							System.out.println("O id ou a senha foi digitado incorretamente, tente novamente!");
						}
					}

					break;

				case 3:

					break;

				default:

					System.out.println("Opção invalida!");

					break;
				}

				break;

			case 2:

				System.out.println("-----------Caixa----------\n");
				System.out.println("1 - Login Administrador;");
				System.out.println("2 - Login Funcionario;");
				System.out.println("3 - Voltar;\n");
				System.out.print("Digite sua opção: ");
				opcao = in.nextInt();

				switch (opcao) {

				case 1:

					break;

				case 2:

					boolean play = false;

					while (!play) {

						System.out.println("------------Login Funcionario------------\n");
						System.out.println("Digite seu ID: ");
						String tempId = in.nextLine();
						System.out.println("Digite sua senha: ");
						String tempSenha = in.nextLine();
						Funcionario auxId = repositorioFuncionario.buscarFuncionario(tempId);
						if ((auxId != null) && (auxId.getSenha().contains(tempSenha))) {
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

				break;
			}

		}
		in.close();
	}
}
