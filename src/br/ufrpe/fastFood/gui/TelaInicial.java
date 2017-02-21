package br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class TelaInicial extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Tela Inicial.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tela Incial");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
