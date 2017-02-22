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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CartaoPagamentoController implements Initializable {
	
	@FXML
	private ImageView imagemC;
	
	@FXML
	private Button cartaoVisaCredito;
	
	@FXML
	private Button cartaoHiperCredito;
	
	@FXML
	private Button cartaoEloCredito;
	
	@FXML
	private Button cartaoMasterCredito;
	
	@FXML
	private Button cartaoVisaDedito;
	
	@FXML
	private Button cartaoHiperDedito;
	
	@FXML
	private Button cartaoEloDedito;
	
	@FXML
	private Button cartaoMasterDedito;
	
	@FXML
	private Button buttonexit;
	
	@FXML
	private void BotaoVisaCredito(ActionEvent event){
		
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Novo Pedido.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Login");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
