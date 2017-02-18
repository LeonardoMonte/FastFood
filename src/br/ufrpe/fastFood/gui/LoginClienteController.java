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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginClienteController implements Initializable {

	@FXML
	private TextField txtLoginC;

	@FXML
	private PasswordField txtSenhaC;

	@FXML
	private Hyperlink esqueceuSenhaC;

	@FXML
	private Button botaoEntrarC;

	@FXML
	private Button botaoSairC;
	
	@FXML
	private Button botaoCadastrarC;

	@FXML
	private Label avisoC;

	@FXML
	private ImageView imagemC;
	
	
	
	@FXML
	private void botaoEntrarActionC(ActionEvent event) throws ONFException, WPException{

		if (!(txtLoginC.getText().equals("") || txtSenhaC.getText().equals(""))) {

			String login, senha;

			login = txtLoginC.getText();
			senha = txtSenhaC.getText();

			try{

				if(Fachada.getInstancia().loginCliente(login, senha)){
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					try{
						Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
						Scene scene = new Scene(root);
						Stage primaryStage = new Stage();
						primaryStage.setScene(scene);
						primaryStage.setTitle("Tela Inicial");
						primaryStage.show();			
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					

				}else{
					avisoC.setText("Login ou Senha inválido ");
				}

			}catch(ONFException e){
				System.out.println(e.getMessage());
				avisoC.setText("Usuário não encontrado");
			}

		}else{
			avisoC.setText("Preencha os campos");
		}

	}

	@FXML
	private void botaoSairActionC(ActionEvent event){

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
	private void botaoCadastrarActionC(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Cadastro Cliente.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro");
			primaryStage.show();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO.png");
		this.imagemC.setImage(img);

	}
}
