package src.br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroCliente extends Application {
	
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Cadastro Cliente.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Cadastro de cliente");
		stage.show();
			
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
