package src.br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import src.br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NovoPedidoController implements Initializable {

	//Botões

	@FXML
	private JFXButton botaoSanduiche;

	@FXML
	private JFXButton botaoHamburguer;

	@FXML
	private JFXButton botaoBebida;

	@FXML
	private JFXButton botaoSobremesa;

	@FXML
	private JFXButton botaoSalada;

	@FXML
	private JFXButton botaoVoltar;

	@FXML
	private JFXButton botaoConfirmar;

	@FXML
	private void botaoSanduicheAction(ActionEvent event){


	}

	@FXML
	private void botaoHamburguerAction(ActionEvent event){


	}

	@FXML
	private void botaoBebidaAction(ActionEvent event){


	}

	@FXML
	private void botaoSobremesaAction(ActionEvent event){


	}


	@FXML
	private void botaoSaladaAction(ActionEvent event){


	}

	@FXML
	private void botaoVoltarAction(ActionEvent event){
		
		try{
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Menu Cliente");
			stage.show();
			
		}catch(Exception e){
			e.getMessage();
		}


	}

	@FXML
	private void botaoConfirmarAction(ActionEvent event){


	}



	//Icones-Imagens

	@FXML
	private ImageView imgSanduiche;

	@FXML
	private ImageView imgHamburguer;

	@FXML
	private ImageView imgBebida;

	@FXML
	private ImageView imgSobremesa;

	@FXML
	private ImageView imgSalada;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image img = new Image("br/ufrpe/fastFood/gui/icone-sanduiche-natural.png");
		this.imgSanduiche.setImage(img);
		
		Image img2 = new Image("br/ufrpe/fastFood/gui/hamburger-icon.png");
		this.imgHamburguer.setImage(img2);
		
		Image img3, img4, img5;
		
		img3 = new Image("br/ufrpe/fastFood/gui/Gerald_G_Fast_Food_Drinks_FF_Menu_4.png");
		this.imgBebida.setImage(img3);
		
		img4 = new Image("br/ufrpe/fastFood/gui/Cake_with_biscuit_7_icon-icons.com_52562.png");
		this.imgSobremesa.setImage(img4);
		
		img5 = new Image("br/ufrpe/fastFood/gui/Salad-icon.png");
		this.imgSalada.setImage(img5);
		
		

	}

}
