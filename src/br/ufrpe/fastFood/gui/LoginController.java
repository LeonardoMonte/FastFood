package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.scene.control.skin.HyperlinkSkin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	private void botaoEntrarAction(ActionEvent event){
		if (txtLogin.getText().equals("") || txtSenha.getText().equals("")) {
		      aviso.setText("Login ou Senha inválido.");
		    }
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO.png");
	    this.imagem.setImage(img);
		
	}
	
	

}
