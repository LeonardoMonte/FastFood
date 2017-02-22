package br.ufrpe.fastFood.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarFuncionarios extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("ListarFuncionarios.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Listar Funcionarios");
			primaryStage.show();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
