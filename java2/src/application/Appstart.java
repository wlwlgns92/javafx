package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Appstart extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
	
	Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
	Scene scene = new Scene(parent);
	stage.setScene(scene);
		stage.setResizable(false); // �������� ũ�� ����
		stage.setTitle("������"); // �������� �̸�
		// �������� ������
			// 1. �̹��� �ҷ�����
			Image image = new Image("file:D:\\������\\java2\\src\\fxml\\������.png");
			stage.getIcons().add(image);
			// 2. 
	stage.show();
	
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
