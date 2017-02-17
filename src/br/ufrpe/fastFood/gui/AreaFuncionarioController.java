package br.ufrpe.fastFood.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AreaFuncionarioController implements Initializable {
	
	@FXML
	private JFXButton botaoNovoPedidoF;
	
	@FXML
	private JFXButton botaoRelatioF;
	
	@FXML
	private JFXButton botaoGerenciamentoF;
	
	@FXML
	private void botaoNovoPedidoFAction(ActionEvent event){	
		try{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("Novo Pedido.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Novo Login");
			stage.show();
			
		}catch(IOException e){
			e.getMessage();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
