package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListarPController implements Initializable {
	
	@FXML
	private TableView<Produto> tabela;
	
	@FXML
	private TableColumn<Produto, String> colunaNome;
	
	@FXML
	private TableColumn<Produto, String> colunaid;
	
	@FXML
	private TableColumn<Produto, Double> colunavalor;
	
	
	@FXML
	private Button sair;
	
	
	@FXML
	private void Sair(ActionEvent event)
	{	
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Listar Produto.fxml"));
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
		
		ArrayList<Produto> p = (ArrayList<Produto>) Fachada.getInstancia().listarProdutos();
		
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaid.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		colunavalor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		
		tabela.setItems(FXCollections.observableArrayList(p));
		
	}
}
