package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;


import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController implements Initializable {

	@FXML
	private Label nome;

	@FXML
	private Label cpf;

	@FXML
	private Label nascimento;

	@FXML
	private Label cidade;

	@FXML
	private Label bairro;

	@FXML
	private Label estado;

	@FXML
	private Label cep;

	@FXML
	private Label rua;

	@FXML
	private Label numero;

	@FXML
	private Label fone;

	@FXML
	private Label senha;

	@FXML
	private Label confirmaSenha;

	@FXML
	private Label lblAviso;

	@FXML
	private Button botaoFinalizar;

	@FXML
	private Button cancelar;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCpf;

	@FXML
	private TextField txtNascimento;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtBairro;

	@FXML
	private TextField txtEstado;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtRua;

	@FXML
	private TextField txtNumero;

	@FXML
	private TextField txtFone;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtConfirmaSenha;

	@FXML
	private void botaoFinalizarAction(ActionEvent event){


		String nome, cpf, nasc, fone, rua, bairro, cidade, estado, senha1, senha2, numero;
		nome = txtNome.getText();
		cpf = txtCpf.getText();
		nasc = txtNascimento.getText();
		rua = txtRua.getText();
		bairro = txtBairro.getText();
		cidade = txtCidade.getText();
		estado = txtEstado.getText();
		senha1 = txtSenha.getText();
		senha2 = txtConfirmaSenha.getText();
		fone = txtFone.getText();
		numero = txtNumero.getText();


		if(!nome.equals("") && !cpf.equals("") && !nasc.equals("") && !rua.equals("") 
				&& !bairro.equals("") && !cidade.equals("") && !estado.equals("") 
				&& !senha1.equals("") && !senha2.equals("") && !fone.equals("") && !numero.equals("")){

			try{
				if(senha1.equals(senha2)){
					int num = Integer.parseInt(numero);
					Endereco endereco = new Endereco(rua, bairro, cidade, estado, num, fone);
					Funcionario cadFuncionario = new Funcionario(nome, cpf, nasc, endereco, senha1);					
					Fachada.getInstancia().cadastrarFuncionario(cadFuncionario);

					try{
						Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
						Scene scene = new Scene(root);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.setTitle("Login");
						stage.show();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}

				}else{
					lblAviso.setText("Senhas não conferem, tente novamente");
				}

			}catch(Exception e){
				System.out.println(e.getMessage());
			}

		}else{
			lblAviso.setText("Preencha todos os campos");
		}


	}


	@FXML
	private void botaoCancelarAction(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		try{

			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();			

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}





	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}


}
