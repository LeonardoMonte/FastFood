package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.beans.Cliente;
import br.ufrpe.fastFood.beans.Endereco;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastroClienteController implements Initializable {
	

	
	@FXML
	private TextField nometxt;
	
	@FXML
	private TextField CPFtxt;
	 	
	@FXML
	private TextField ruatxt;
	
	@FXML
	private TextField cidadetxt;
	
	@FXML
	private TextField bairrotxt;
	
	
	
	@FXML
	private TextField numerotxt;
	
	@FXML
	private TextField telefonetxt;
	
	@FXML
	private PasswordField senhatxt;
	
	@FXML
	private PasswordField confirmarsenhatxt;
	
	@FXML
	private TextField datadenascismentotxt;
	
	@FXML
	private TextField estadotxt;
	
	
	@FXML
	private Button confirmarbutton;
	
	@FXML
	private Button cancelar;
	
	@FXML
	private TextField emailtxt;
	
	@FXML
	private Label lblAviso;
	
	
	@FXML
	private void botaoFinalizarActionC(ActionEvent event){		
		
		String nome, cpf, nasc, fone, rua, bairro, cidade, estado, senha1, senha2, numero, email;
		nome = nometxt.getText();
		cpf = CPFtxt.getText();
		nasc = datadenascismentotxt.getText();
		rua = ruatxt.getText();
		cidade = cidadetxt.getText();
		bairro = bairrotxt.getText();
		email = emailtxt.getText();
		
		estado = estadotxt.getText();
		senha1 = senhatxt.getText();
		senha2 = confirmarsenhatxt.getText();
		fone = telefonetxt.getText();
		numero = numerotxt.getText();


		if(!nome.equals("") && !cpf.equals("") && !nasc.equals("") && !rua.equals("") 
				&& !bairro.equals("") && !cidade.equals("") && !estado.equals("") 
				&& !senha1.equals("") && !senha2.equals("") && !fone.equals("") && !numero.equals("") && !email.equals("")){

			try{
				if(senha1.equals(senha2)){
					int num = Integer.parseInt(numero);
					Endereco endereco = new Endereco(rua, bairro, cidade, estado, num, fone);
					Cliente cadCliente = new Cliente(nome, cpf, nasc, endereco, senha1, email);
					try
					{
					Fachada.getInstancia().cadastrarCliente(cadCliente);
					((Node) (event.getSource())).getScene().getWindow().hide();
					try{
						Parent root = FXMLLoader.load(getClass().getResource("LoginCliente.fxml"));
						Scene scene = new Scene(root);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.setTitle("Login");
						stage.show();
						
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					
					}
					catch(OJEException exc)
					{
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("Impossivel realizar a acao");
						alert.setContentText("Funcionario com o id " + exc.getId() + " Ja existe");	
						alert.showAndWait();
						
					}


				}else{
					lblAviso.setText("Senhas não conferem");
				}

			}catch(Exception e){
				System.out.println(e.getMessage());
			}

		}else{
			lblAviso.setText("Preencha todos os campos");
		}


	}
	
	@FXML
	private void botaoCancelarAction(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		try{

			Parent root = FXMLLoader.load(getClass().getResource("LoginCliente.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.show();			

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	
	
	

}
