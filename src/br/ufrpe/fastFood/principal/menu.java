package br.ufrpe.fastFood.principal;
import java.util.Scanner;
import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.dados.RepositorioClientes;

public class menu {

	public static void main(String[] args) {
		
		int opcao = 0;
		
		RepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();
		Scanner in = new Scanner(System.in);
		
		System.out.println("-----------Seja Bem-vindo------------\n");
		System.out.println("1 - Auto Atendimento;");
		System.out.println("2 - Caixa;");
		System.out.println("3 - Encerrar.\n");
		System.out.print("Digite sua opção: ");
		opcao = in.nextInt();
		
		switch (opcao) {
		
		case 1:
			
			System.out.println("-----------Auto Atendimento----------\n");
			System.out.println("1 - Cadastro;");
			System.out.println("2 - Login;");
			System.out.println("3 - Voltar;\n");
			System.out.print("Digite sua opção: ");
			opcao = in.nextInt();
			
			switch (opcao) {
			
			case 1:
				
				System.out.print("------------Cadastro Cliente---------- \n");
				System.out.println("Nome: ");
				String nome = in.nextLine();
				System.out.println("CPF: ");
				String id = in.nextLine();
				System.out.println("Nascimento: ");
				String nascimento = in.nextLine();
				System.out.println("Rua: ");
				String rua = in.nextLine();
				System.out.println("Numero: ");
				int numero = in.nextInt();
				System.out.println("Bairro: ");
				String bairro = in.nextLine();
				System.out.println("Cidade: ");
				String cidade = in.nextLine();
				System.out.println("Estado: ");
				String estado = in.nextLine();
				System.out.println("Telefone: ");
				String telefone = in.nextLine();
				System.out.println("Email: ");
				String email = in.nextLine();
				System.out.println("Senha: ");
				String senha = in.nextLine();
				
				Endereco end1 = new Endereco(rua, bairro, cidade, estado, numero, telefone);
				Cliente cliente1 = new Cliente(nome, id, nascimento, end1, senha, email);
				repositorioClientes.cadastrarCliente(cliente1);
				
				break;
				
			case 2:
				boolean play = false;
				
				while(!play){
					
					System.out.println("------------Login Cliente------------\n");
					System.out.println("Digite sua ID: ");
					String tempId = in.nextLine();
					System.out.println("Digite sua senha: ");
					String tempSenha = in.nextLine();
					
					Cliente auxId = repositorioClientes.buscarCliente(tempId);
					
					if((auxId != null) && (auxId.equals(tempSenha))){
						play = true;
						
						//Continuação do codigo...
						
						
					}else{
						
						System.out.println("O id ou a senha foi digitado incorretamente, tente novamente!");
					}
				}
				
				
				break;
				
			case 3:
				
				break;

			default:
				break;
			}

			
			break;
			
		case 2:
			
			break;
			
		case 3:
	
			break;

		default:
			
			break;
		}

	}

}
