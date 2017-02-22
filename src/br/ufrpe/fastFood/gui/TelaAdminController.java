package src.br.ufrpe.fastFood.gui;

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
import javafx.stage.Stage;

public class TelaAdminController implements Initializable{

	@FXML
	private Button funcionarios;
	
	@FXML
	private Button clientes;
	
	@FXML
	private Button sair;
	
	@FXML
	private Button produtos;
	
	
	@FXML
	private void sair(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("AdminTela.fxml"));
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
	private void produtos(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("GerenciarProdutos.fxml"));
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
	private void funcionarios(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Adicionar Produto.fxml"));
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
	private void clientes(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Adicionar Produto.fxml"));
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
