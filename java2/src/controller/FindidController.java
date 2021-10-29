package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FindidController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

    @FXML
    private Text btnback;

    @FXML
    private Button btnfindid;

    @FXML
    private AnchorPane findidpane;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    void back(MouseEvent event) {
    	LoginController.getinstance().loadpage("login");
    }

    @FXML
    void findid(ActionEvent event) {
    	
    	// Dao 객체내 findid 메소드 호출
    	String result = MemberDao.getMemberDao().findid(txtname.getText(), txtemail.getText());
    	if(result != null) {
    		lblconfirm.setText("고객님의 아이디는 : " + result );
    	}else {
    		lblconfirm.setText("일치하는 정보를 찾을 수 없습니다");
    	}
    }
}
