package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SignupController {
    
	@FXML
    private Text btnback;

    @FXML
    private AnchorPane signuppane;

    @FXML
    void back(MouseEvent event) {
    	// !! ���ο� ��ü ����ÿ��� ���ο� �޸�
    //LoginController loginController = new LoginController();
    	
    	// ������ �޸� ����ϱ� ���ؼ� this Ű���带 ����� ��ü ȣ��
    	LoginController.getinstance().loadpage("login");
    	
    }
}
