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

public class AlterarProdutosController implements Initializable  {

	

	@FXML
	private Button alterarproduto;
	
	@FXML
	private Button alterarcombo;	
	
	@FXML
	private Button sair;
	
	@FXML
	private ImageView img1;
	
	@FXML
	private ImageView img2;
	
	
	@FXML
	private void AlterarProduto(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("AlterarProduto.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro");
			primaryStage.show();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	private void AlterarCombo(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("AtualizarCombo.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro");
			primaryStage.show();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	@FXML
	private void sair(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("GerenciarProdutos.fxml"));
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
		
		Image imgg = new Image("br/ufrpe/fastFood/gui/icon-produto.png");
		this.img1.setImage(imgg);
		
		Image imgg1 = new Image("br/ufrpe/fastFood/gui/icon-combo.png");
		this.img2.setImage(imgg1);
		
	}
}
