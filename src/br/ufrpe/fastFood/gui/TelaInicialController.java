package br.ufrpe.fastFood.gui;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
	
	@FXML
	private JFXButton botaoCaixa;
	
	@FXML
	private JFXButton botaoAutoAtendimento;
	
	@FXML
	private ImageView imgCaixa;
	
	@FXML
	private ImageView imgAutoAtend;
	
	@FXML
	private ImageView imgCabecalho;
	
	@FXML 
	private void botaoAutoAtendimentoAction(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage stageNew = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoginCliente.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("FuncionarioAdmin.fxml"));
			Scene loginScene = new Scene(root);
			stageNew.setScene(loginScene);
			stageNew.setTitle("Selecionar Categoria");
			stageNew.show();	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO_wallpaper.png");
		this.imgCabecalho.setImage(img);
		
		Image img2 = new Image("br/ufrpe/fastFood/gui/icon-funcionario.png");
		this.imgCaixa.setImage(img2);
		
		Image img3 = new Image("br/ufrpe/fastFood/gui/icon-self-service.png");
		this.imgAutoAtend.setImage(img3);
		
	}

}
