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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GerenciarClientesController implements Initializable {


	@FXML
	private Button adicionar;
	
	@FXML
	private Button remover;
	
	@FXML
	private Button atualizar;
	
	@FXML
	private Button listar;
	
	@FXML
	private Button sair;
	
	@FXML
	private ImageView img1;
	
	@FXML
	private ImageView img2;
	
	@FXML
	private ImageView img3;
	
	@FXML
	private ImageView img4;
	

	@FXML
	private void sair(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("TelaAdmin.fxml"));
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
	private void cadastrar(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Cadastro Cliente.fxml"));
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
	private void remover(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("RemoverCliente.fxml"));
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
	private void mostrar(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("ListarCliente.fxml"));
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
	private void atualizar(ActionEvent event)
	{
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("AlterarCliente.fxml"));
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
		Image imgg = new Image("br/ufrpe/fastFood/gui/icon-Config.png");
		this.img1.setImage(imgg);
		
		Image imgg1 = new Image("br/ufrpe/fastFood/gui/icon-editar.png");
		this.img2.setImage(imgg1);
		
		Image imgg2 = new Image("br/ufrpe/fastFood/gui/icon-masis.png");
		this.img3.setImage(imgg2);
		
		Image imgg3 = new Image("br/ufrpe/fastFood/gui/icon-menos.png");
		this.img4.setImage(imgg3);
	}
}
