package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdicionarPController implements Initializable{

	@FXML
	private ImageView imagemC;
	
	@FXML
	private Button Entrar;
		
	@FXML
	private Button Sair;
	
	@FXML
	private TextField idtxt;
	
	@FXML
	private TextField valortxt;
	
	@FXML
	private TextField nometxt;
	
	@FXML
	private void Concluir(ActionEvent event)
	{
		
			String id, nome, valor;
			
			id = idtxt.getText();
			nome = nometxt.getText();
			valor = valortxt.getText();
			
			if( !id.equals("") && !nome.equals("") && !valor.equals(""))
			{
			double ritghvalor = Double.parseDouble(valor);
			
			Produto p = new Produto(nome, ritghvalor, id);
			
			try {
				Fachada.getInstancia().cadastrarProduto(p);
				
				((Node) (event.getSource())).getScene().getWindow().hide();
				
				try
				{
					Parent root = FXMLLoader.load(getClass().getResource("Adicionar produto.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = new Stage();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Cadastro");
					primaryStage.show();
					
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				
				
			} catch (OJEException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Produto com o id " + e.getId() + " Ja existe");	
				alert.showAndWait();
			}
		}
		else
		{
			label.setText("Preencha todos os campos");
		}
	}
	
	@FXML
	private Label label;
	
	@FXML
	private void Sair(ActionEvent event)
	{	
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Adicionar produto.fxml"));
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
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO_wallpaper.png");
		this.imagemC.setImage(img);

		
	}

}
