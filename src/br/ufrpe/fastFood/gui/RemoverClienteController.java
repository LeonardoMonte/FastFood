package src.br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import src.br.ufrpe.fastFood.beans.Cliente;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.negocios.Fachada;

public class RemoverClienteController implements Initializable{

	@FXML
	private TableView<Cliente> tabela;
	
	@FXML
	private TableColumn<Cliente, String> colunaNome;
	
	@FXML
	private TableColumn<Cliente, String> colunaid;
	
	@FXML
	private TableColumn<Cliente, String> colunadatadenascimento;
	
	@FXML
	private TableColumn<Cliente, String> colunarua;
	
	@FXML
	private TableColumn<Cliente, String> colunabairro;
	
	@FXML
	private TableColumn<Cliente, String> colunacidade;
	
	@FXML
	private TableColumn<Cliente, String> colunestado;
	
	@FXML
	private TableColumn<Cliente, String> colunatelefone;
	
	@FXML
	private TableColumn<Cliente, String> colunaemail;
	
	@FXML
	private TableColumn<Cliente, Integer> colunanumero;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ArrayList<Cliente> c = (ArrayList<Cliente>) Fachada.getInstancia().listarClientes();
		
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaid.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		colunadatadenascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
		colunarua.setCellValueFactory(new PropertyValueFactory<>("rua"));
		colunabairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		colunacidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		colunestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		colunatelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		colunaemail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colunanumero.setCellValueFactory(new PropertyValueFactory<>("numero"));	
			
		tabela.setItems(FXCollections.observableArrayList(c));
		
	}
	
	@FXML
	private TextField idtxt;
	
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
			Parent root = FXMLLoader.load(getClass().getResource("GerenciarCleintes.fxml"));
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
		String id = idtxt.getText();
		
		if(!id.equals(""))
		{
			try {
				Fachada.getInstancia().removerCliente(id);
				
				((Node) (event.getSource())).getScene().getWindow().hide();
				
				try
				{
					Parent root = FXMLLoader.load(getClass().getResource("GerenciarClientes.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = new Stage();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Cadastro");
					primaryStage.show();
					
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				
			} catch (ONFException e) {
			
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Cliente com o id " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
		}
		else
		{
			label.setText("Preencha todos os campos");
		}
	}
}
