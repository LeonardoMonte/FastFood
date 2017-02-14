package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
	private Label refencia;

	@FXML
	private Label telefone1;

	@FXML
	private Label telefone2;

	@FXML
	private Label senha;

	@FXML
	private Label confirmaSenha;

	@FXML
	private Button finalizar;
	
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
	private TextField txtReferecia;

	@FXML
	private TextField txtFone1;

	@FXML
	private TextField txtFone2;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtConfirmaSenha;

	@FXML
	private void botaoFinalizarAction(ActionEvent event){
		try{
			if(!(txtNome.equals("") || txtCpf.equals("") || txtNascimento.equals("")
					|| txtCidade.equals("")	|| txtBairro.equals("") || txtEstado.equals("")
					|| txtFone1.equals("") || txtSenha.equals("") || txtConfirmaSenha.equals(""))){
				Alert cadastroConfirmado = new Alert(Alert.AlertType.INFORMATION);
				cadastroConfirmado.setHeaderText("Aviso");
				cadastroConfirmado.setContentText("Cadastro Realizado com sucesso");
				cadastroConfirmado.showAndWait();
			}else{

				Alert cadastrNaoConfirmado = new Alert(Alert.AlertType.INFORMATION);
				cadastrNaoConfirmado.setHeaderText("Aviso");
				cadastrNaoConfirmado.setContentText("Por favor, preencha todos os campos.");
				cadastrNaoConfirmado.showAndWait();
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
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
