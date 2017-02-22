package br.ufrpe.fastFood.gui;

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

public class GerenciarFuncionariosController implements Initializable{

	@FXML
	private JFXButton botaoAdicionar;

	@FXML
	private JFXButton botaoRemover;

	@FXML
	private JFXButton botaoAtualizar;

	@FXML
	private JFXButton botaoListar;
	
	@FXML
	private JFXButton botaoVoltar;
	
	@FXML
	private void botaoVoltarAction(ActionEvent event){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("AdminTela.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.setTitle("Administrador");
			stage.setResizable(false);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void botaoAddAction(ActionEvent event){

		((Node)(event.getSource())).getScene().getWindow().hide();


		try{
			Parent root = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.setTitle("Cadastrar Funcionário");
			stage.setResizable(false);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	private void botaoRemoverAction(ActionEvent event){
		((Node)(event.getSource())).getScene().getWindow().hide();


		try{
			Parent root = FXMLLoader.load(getClass().getResource("RemoverFuncionario.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.setTitle("Remover Funcionário");
			stage.setResizable(false);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	private void botaoAtualizarAction(ActionEvent event){
		((Node)(event.getSource())).getScene().getWindow().hide();


		try{
			Parent root = FXMLLoader.load(getClass().getResource("AtualizaFuncionario.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.setTitle("Atualizar Funcionario");
			stage.setResizable(false);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	private void botaoListarAction(ActionEvent event){
		((Node)(event.getSource())).getScene().getWindow().hide();


		try{
			Parent root = FXMLLoader.load(getClass().getResource("ListarFuncionario.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.setTitle("Listar Funcionarios");
			stage.setResizable(false);
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	private ImageView imgAdd;

	@FXML
	private ImageView imgRmv;

	@FXML
	private ImageView imgAtlz;

	@FXML
	private ImageView imgListar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img, img2, img3, img4;
		
		img = new Image("br/ufrpe/fastFood/gui/icon-masis.png");
		this.imgAdd.setImage(img);
		
		img2 = new Image("br/ufrpe/fastFood/gui/icon-menos.png");
		this.imgRmv.setImage(img2);
		
		img3 = new Image("br/ufrpe/fastFood/gui/icon-Config.png");
		this.imgAtlz.setImage(img3);
		
		img4 = new Image("br/ufrpe/fastFood/gui/icon-editar.png");
		this.imgListar.setImage(img4);

	}

}
