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

public class CartaoPagamentoController implements Initializable {

	@FXML
	private Button cartaoVisaCredito;

	@FXML
	private Button cartaoHiperCredito;

	@FXML
	private Button cartaoEloCredito;

	@FXML
	private Button cartaoMasterCredito;

	@FXML
	private Button cartaoVisaDedito;

	@FXML
	private Button cartaoHiperDedito;

	@FXML
	private Button cartaoEloDedito;

	@FXML
	private Button cartaoMasterDedito;

	@FXML
	private Button buttonexit;
	
	@FXML
	private ImageView imagemA;
	
	@FXML
	private ImageView imagemB;
	
	@FXML
	private ImageView imagemC;
	
	@FXML
	private ImageView imagemD;
	
	@FXML
	private ImageView imagemA1;
	
	@FXML
	private ImageView imagemB2;
	
	@FXML
	private ImageView imagemC3;
	
	@FXML
	private ImageView imagemD4;

	@FXML
	private void BotaoVisaCredito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoVisaDedito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoHiperCredito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoHiperDedito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoEloCredito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoEloDedito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoMasterCredito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	@FXML
	private void BotaoMasterDedito(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	

		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Insira Cartao.fxml"));
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.setTitle("Insira seu cartão");
			stage2.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}

	}
	
	@FXML
	private void BotaoSair(ActionEvent event)
	{
		
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Forma de pagamento.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();
		}
		catch(Exception e)
		{
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image img1 = new Image("br/ufrpe/fastFood/gui/gerador-de-cartao-de-credito-visa.png");
		this.imagemC.setImage(img1);
		
		Image img2 = new Image("br/ufrpe/fastFood/gui/640px-MasterCard_logo.png");
		this.imagemC.setImage(img2);
		
		Image img3 = new Image("br/ufrpe/fastFood/gui/Elo_logo.png");
		this.imagemC.setImage(img3);
		
		Image img4 = new Image("br/ufrpe/fastFood/gui/Hipercard_d57c6_450x450.png");
		this.imagemC.setImage(img4);
		
		Image img5 = new Image("br/ufrpe/fastFood/gui/gerador-de-cartao-de-credito-visa.png");
		this.imagemC.setImage(img5);
		
		Image img6 = new Image("br/ufrpe/fastFood/gui/640px-MasterCard_logo.png");
		this.imagemC.setImage(img6);
		
		Image img7 = new Image("br/ufrpe/fastFood/gui/Elo_logo.png");
		this.imagemC.setImage(img7);
		
		Image img8 = new Image("br/ufrpe/fastFood/gui/Hipercard_d57c6_450x450.png");
		this.imagemC.setImage(img8);

	}



}
