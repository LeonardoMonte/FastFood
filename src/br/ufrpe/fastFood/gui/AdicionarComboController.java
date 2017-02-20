package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.beans.Combo;
import br.ufrpe.fastFood.beans.Produto;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdicionarComboController implements Initializable {

	
	@FXML
	private TableView<Produto> tabela;
	
	@FXML
	private TableColumn<Produto, String> colunaNome;
	
	@FXML
	private TableColumn<Produto, String> colunaid;
	
	@FXML
	private TableColumn<Produto, Double> colunavalor;
	
	@FXML
	private TextField nometxt;
	
	@FXML
	private TextField idtxt;
	
	@FXML
	private TextField produto1txt;
	
	@FXML
	private TextField produto2txt;
	
	@FXML
	private TextField produto3txt;
	
	@FXML
	private Button concluir;
	
	@FXML
	private Button sair;
		
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
	
	@FXML
	private void Concluir(ActionEvent event)
	{
		String id, nome , produto1 , produto2 , produto3;
		
		id = idtxt.getText();
		nome = nometxt.getText();
		produto1 = produto1txt.getText();
		produto2 = produto2txt.getText();
		produto3 = produto3txt.getText();
		
		if(!nome.equals("") && !id.equals("") && !produto1.equals("") && !produto2.equals("") && !produto3.equals(""))
		{
			

			Produto p1 = new Produto();
			Produto p2 = new Produto();
			Produto p3 = new Produto();
			
			try {
				p1 = Fachada.getInstancia().procurarProduto(produto1);
				p2 = Fachada.getInstancia().procurarProduto(produto2);
				p3 = Fachada.getInstancia().procurarProduto(produto3);
				
				Combo c = new Combo(nome, id , p1 , p2 ,p3);
				
				try {
					
					Fachada.getInstancia().cadastrarCombo(c);
									 
					
					
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
				catch (OJEException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("Impossivel realizar a acao");
					alert.setContentText("Combo com o id " + e.getId() + " Ja existe");	
					alert.showAndWait();
				}
				
				
			} catch (ONFException e1) {
			
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Produto com o id " + e1.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}	
			
		}
		else
		{
			label.setText("Preencha todos os campos");
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
