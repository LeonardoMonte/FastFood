package br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFuncionario extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			System.out.println("Erro!");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main (String[] args){
		launch(args);
	}
	

}
