package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FindpasswordController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	lblconfirm.setText("");
	}

	
    @FXML
    private Text btnback;

    @FXML
    private Button btnfindpassword;

    @FXML
    private AnchorPane findpasswordpane;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    void back(MouseEvent event) {
    	LoginController.getinstance().loadpage("login");
    }


    @FXML
    void findpassword(ActionEvent event) {
    	// Dao 객체내 findpassword 메소드 호출
    	String result = MemberDao.getMemberDao().findpassword(txtid.getText(), txtemail.getText());
    	if(result != null) {
    		// 메일 전송
    		Member.sendmail(txtemail.getText(), result, 2);
    		lblconfirm.setText("이메일로 비밀번호를 전송했다");
    	}else {
    		lblconfirm.setText("일치하는 정보를 찾을 수 없습니다");
    	}
    }
}
