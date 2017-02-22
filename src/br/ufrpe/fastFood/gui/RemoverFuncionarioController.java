package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.fastFood.beans.Funcionario;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RemoverFuncionarioController implements Initializable {
	
	@FXML
	private TableView<Funcionario> tabelaF;
	
	@FXML
	private TableColumn<Funcionario, String> colunaNome;
	
	@FXML
	private TableColumn<Funcionario, String> colunaId;
	
	@FXML
	private JFXTextField txtId;
	
	@FXML
	private JFXButton sair;

	@FXML
	private JFXButton concluir;
	
	@FXML
	private Label aviso;

	
	@FXML
	private void concluirAction(ActionEvent event){

		String id = txtId.getText();
		
		if(!id.equals("")){
			
			
			
			try{
				
				Fachada.getInstancia().removerFuncionario(id);
				
			}catch(ONFException e){
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Funcionario com o id " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
			
		}else{
			aviso.setText("Preencha o campo ID");
		}
		
	}
	
	@FXML
	private void sairAction(ActionEvent event){
		
		((Node)(event).getSource()).getScene().getWindow().hide();
		try{
			
			Parent root = FXMLLoader.load(getClass().getResource("GerenciarFuncionarios.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Gerenciar Funcionario");
			stage.show();	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Funcionario> f = (ArrayList<Funcionario>) Fachada.getInstancia().listarFuncionarios();
		
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tabelaF.setItems(FXCollections.observableArrayList(f));
		
	}

}
