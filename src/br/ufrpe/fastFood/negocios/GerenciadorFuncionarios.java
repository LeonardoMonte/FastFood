package br.ufrpe.fastFood.negocios;

import java.util.List;

import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.dados.RepositorioFuncionarios;
import br.ufrpe.fastFood.exceptions.ObjectFound;
import br.ufrpe.fastFood.exceptions.ObjectNotFound;

public class GerenciadorFuncionarios {

	private RepositorioFuncionarios repositorio;
	
		public GerenciadorFuncionarios()
		{
			this.repositorio = RepositorioFuncionarios.getInstancia();
		}
	
		public void cadastrar(Funcionario a)
		{
			if(a == null)
			{
				throw new ObjectNotFound("Impossivel fazer o cadastro de um funcionario sem dados");
			}
			else if(this.repositorio.existeFuncionario(a.getId()))
			{
				throw new ObjectFound("Funcionario j� cadastrado no sistema");
			}
			else
			{
				this.repositorio.cadastrarFuncionario(a);
			}
		}
	
		public boolean remover(String id)
		{		
			boolean Final = this.repositorio.removerFuncionario(id);
			return Final;
		
		}
	
		public Funcionario procurar(String id)
		{
			return this.repositorio.buscarFuncionario(id);
		
		}
	
		public boolean atualizarFuncionario( String id , Endereco ende)
		{
			
			boolean resultado = false;
			if( ende == null)
			{
				throw new ObjectNotFound("Impossivel fazer atualiza��o de funcionario sem dados");
			}
//			else if(this.repositorio.existeFuncionario()id == false )
//			{
//				throw new ObjectNotFound("Funcionario n�o encontrado no sistema");
//			}
			else
			{
				resultado = this.repositorio.atualizarFuncionarioendere�o(id , ende);
			}
			
			return resultado;
		}
	
		public List<Funcionario> listarFuncionarios()
		{	if(this.repositorio.existeIndiceF(0) == false) // TENTATIVA DE EXCEPTION
			{
				throw new ObjectNotFound("N�o existe nada a ser listado");
			}
		
			else
			{
				return this.repositorio.listarFuncinario();
			}
		
		
		}
		
		public boolean loginFuncionario(String id , String senha)
		{
			boolean resultado = this.repositorio.loginFunc(id, senha);
			
			return resultado;
		}
		
		public boolean existe(String id)
		{
			return this.repositorio.existeFuncionario(id);
		}
		
		public boolean alterarSenha(String id, String senhaold , String senhanew)
		{
			return this.repositorio.alterarsenha(id, senhaold , senhanew);
			
		}
		
}
