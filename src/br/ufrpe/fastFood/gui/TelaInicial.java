package br.ufrpe.fastFood.gui;

import br.ufrpe.fastFood.beans.Admin;
import br.ufrpe.fastFood.beans.Endereco;
import br.ufrpe.fastFood.beans.Funcionario;
import br.ufrpe.fastFood.exceptions.OJEException;
import br.ufrpe.fastFood.negocios.Fachada;
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
		Endereco ende = new Endereco(nome, nome, nome, nome, x, nome);
		
		Admin admin = new Admin(nome, login, nome, ende, senha1);
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
