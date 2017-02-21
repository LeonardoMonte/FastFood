package br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaIntermediariaFuncAdmin extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FuncionarioAdmin.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Funcionario/Admin");
		primaryStage.setResizable(false);
		primaryStage.show();		
	}

	public static void main(String[] args){
		launch(args);
	}
}
