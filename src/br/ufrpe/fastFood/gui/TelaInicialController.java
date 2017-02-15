package br.ufrpe.fastFood.gui;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
	
	@FXML
	private Label lblCaixa;
	
	@FXML
	private Label lblAutoAtendimento;
	
	@FXML
	private Button botaoCaixa;
	
	@FXML
	private Button botaoAutoAtendimento;
	
/*	@FXML
	private ImageView imagem1;
	
	@FXML
	private ImageView imagem2;
*/	
	@FXML 
	private void botaoAutoAtendimentoAction(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage stageNew = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene loginScene = new Scene(root);
			stageNew.setScene(loginScene);
			stageNew.setTitle("Auto Atendimento");
			stageNew.show();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void botaoCaixaAction(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		try{
			Stage stageNew = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
			Scene loginScene = new Scene(root);
			stageNew.setScene(loginScene);
			stageNew.setTitle("Caixa");
			stageNew.show();	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
