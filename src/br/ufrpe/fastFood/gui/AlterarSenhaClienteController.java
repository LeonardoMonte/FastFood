package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AlterarSenhaClienteController implements Initializable {
	
	
	@FXML
	private Button concluir;
	
	@FXML
	private Button sair;
	
	@FXML
	private PasswordField senhanova;
	
	@FXML
	private PasswordField senhaantiga;
	
	@FXML
	private Label aviso;

	@FXML
	private ImageView imagemC;
	
	@FXML
	private TextField idtxt;
		
	
	@FXML
	private void Sair(ActionEvent event)
	{
	((Node) (event.getSource())).getScene().getWindow().hide();	
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
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
	private void Concluir(ActionEvent event)
	{
		if( !(senhaantiga.getText().equals("") && senhanova.getText().equals("") && idtxt.getText().equals("")))
		{
		String oldsenha , newsenha, id;
		
		oldsenha = senhaantiga.getText();
		newsenha = senhanova.getText();
		id = idtxt.getText();
		
		
		try {
			Fachada.getInstancia().alterarSenhaCliente(id, oldsenha, newsenha);
			
			((Node) (event.getSource())).getScene().getWindow().hide();
			
			try{
				Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = new Stage();
				primaryStage.setScene(scene);
				primaryStage.setTitle("Tela Inicial");
				primaryStage.show();			
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			
		} catch (ONFException e) {
			aviso.setText("CPF invalido");
		}catch( WPException e)
		{
			aviso.setText("Senhas antiga incorreta");
		}
		}
	
	else
	{
		aviso.setText("Preencha todos os campos");
	}
}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
