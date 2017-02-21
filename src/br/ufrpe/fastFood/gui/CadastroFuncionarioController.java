package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CadastroFuncionarioController implements Initializable {

	
	@FXML
	private Label lblAviso;

	@FXML
	private JFXButton botaoFinalizar;

	@FXML
	private JFXButton botaoCancelar;

	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXTextField txtCpf;

	@FXML
	private JFXTextField txtNascimento;
	
	@FXML
	private JFXTextField txtRua;
	
	@FXML
	private JFXTextField txtNumero;
	
	@FXML
	private JFXTextField txtBairro;

	@FXML
	private JFXTextField txtCidade;

	@FXML
	private JFXTextField txtEstado;


	@FXML
	private JFXPasswordField txtSenha;

	@FXML
	private JFXPasswordField txtConfirmaSenha;
	
	@FXML
	private JFXTextField txtFone;

	@FXML
	private void botaoFinalizarAction(ActionEvent event){


		String nome, cpf, nasc, fone, rua, bairro, cidade, estado, senha1, senha2, numero;
		nome = txtNome.getText();
		cpf = txtCpf.getText();
		nasc = txtNascimento.getText();
		rua = txtRua.getText();
		cidade = txtCidade.getText();
		bairro = txtBairro.getText();
		
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
					try
					{
					Fachada.getInstancia().cadastrarFuncionario(cadFuncionario);
					
					try{
						Parent root = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
						Scene scene = new Scene(root);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.setTitle("Login");
						stage.show();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					
					}
					catch(OJEException exc)
					{
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("Impossivel realizar a acao");
						alert.setContentText("Funcionario com o id " + exc.getId() + " Ja existe");
						alert.showAndWait();
						
					}


				}else{
					lblAviso.setText("Senhas não conferem");
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

			Parent root = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
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
