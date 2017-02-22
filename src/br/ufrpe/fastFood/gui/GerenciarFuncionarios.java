package br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GerenciarFuncionarios extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("GerenciarFuncionarios.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Gerenciar Funcionarios");
			primaryStage.setResizable(false);
			primaryStage.show();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String [] args){
		launch(args);
	}
	

}
