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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuClienteController implements Initializable {
	
	
	@FXML
	private ImageView imagemC;
	
	@FXML
	private Button buttonbuy;
	
	@FXML
	private Button buttonedit;
	
	@FXML
	private Button buttonexit;
	
	
	@FXML
	private void BotaoComprar(ActionEvent event)
	{
		
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
	
	@FXML
	private void BotaoSair(ActionEvent event)
	{
		
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("LoginCliente.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}
	@FXML
	private void BotaoAlterarDados(ActionEvent event)
	{
		
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("AlterarSenhaCliente.fxml"));
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			stage1.setTitle("Login");
			stage1.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image img = new Image("br/ufrpe/fastFood/gui/cash_icon-icons.com_51090.png");
		this.imagemC.setImage(img);
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
