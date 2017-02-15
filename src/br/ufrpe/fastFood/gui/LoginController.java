package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LoginController implements Initializable {

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtSenha;

	@FXML
	private Hyperlink recupLogin;

	@FXML
	private Hyperlink recupSenha;

	@FXML
	private Button botaoEntrar;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoCadastrar;

	@FXML
	private Label aviso;

	@FXML
	private ImageView imagem;

	@FXML
	private void botaoEntrarAction(ActionEvent event) throws ONFException, WPException{

		if (!(txtLogin.getText().equals("") || txtSenha.getText().equals(""))) {

			String login, senha;

			login = txtLogin.getText();
			senha = txtSenha.getText();

			try{

				if(Fachada.getInstancia().loginFuncionario(login, senha)){
					((Node) (event.getSource())).getScene().getWindow().hide();

				}else{
					aviso.setText("Login ou Senha inválido ");
				}

			}catch(ONFException e){
				System.out.println(e.getMessage());
				aviso.setText("Usuário não encontrado");
			}

		}else{
			aviso.setText("Preencha os campos");
		}

	}

	@FXML
	private void botaoSairAction(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	
		try{
			Parent root = FXMLLoader.load(getClass().getResource("Tela Inicial.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tela Incial");
			primaryStage.show();			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}


	}

	@FXML
	private void botaoCadastrarAction(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();
		try{
			Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastrar");
			stage.show();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}


	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO.png");
		this.imagem.setImage(img);

	}



}
