package br.ufrpe.fastFood.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AreaFuncionarioController implements Initializable {
	
	
	@FXML
	private ImageView imgPedido;
	
	@FXML
	private ImageView imgRelatorio;
	
	@FXML
	private ImageView imgGerenciamento;

	@FXML
	private JFXButton botaoNovoPedidoF;

	@FXML
	private JFXButton botaoRelatioF;

	@FXML
	private JFXButton botaoGerenciamentoF;

	@FXML
	private void botaoNovoPedidoFAction(ActionEvent event){	
		try{
			((Node) (event.getSource())).getScene().getWindow().hide();

			Parent root = FXMLLoader.load(getClass().getResource("Novo Pedido.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Novo Login");
			stage.show();

		}catch(IOException e){
			e.getMessage();
		}
	}

	@FXML
	private void boatoRelatorioFuncAction(ActionEvent event){

		try{
			((Node) (event.getSource())).getScene().getWindow().hide();

			Parent root = FXMLLoader.load(getClass().getResource(""));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Relatorio");
			stage.show();

		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@FXML
	private void boatoGerenciamentoFuncAction(ActionEvent event){

		try{
			((Node) (event.getSource())).getScene().getWindow().hide();

			Parent root = FXMLLoader.load(getClass().getResource("Gerenciamento.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.setTitle("Genrenciamento");
			stage.show();

		}catch(Exception e){
			e.getMessage();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Image img = new Image("br/ufrpe/fastFood/gui/Shopping-bag_icon-icons.com_51907.png");
		this.imgPedido.setImage(img);
		
		Image img2 = new Image("br/ufrpe/fastFood/gui/Fremes-e-Máscaras-Digitais-queroimagem-Ceiça-Crispim   (8).png");
		this.imgGerenciamento.setImage(img2);
		
		Image img3 = new Image("br/ufrpe/fastFood/gui/bars-chart-ascending_icon-icons.com_56865.png");
		this.imgRelatorio.setImage(img3);
		

	}

}
