package src.br.ufrpe.fastFood.gui;

import src.br.ufrpe.fastFood.beans.Admin;
import src.br.ufrpe.fastFood.beans.Funcionario;
import src.br.ufrpe.fastFood.exceptions.OJEException;
import src.br.ufrpe.fastFood.negocios.Fachada;
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
		
		String senha1 = "admin"; String login = "admin"; String nome = "Padrão"; int x = 00;
		
		Admin admin = new Admin(nome, login, nome, senha1 , nome, nome, nome, nome, x, nome);
		Funcionario f = (Admin) admin;
		try {
			Fachada.getInstancia().cadastrarFuncionario(f);
		} catch (OJEException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
