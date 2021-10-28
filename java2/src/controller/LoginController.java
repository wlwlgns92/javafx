package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{
										// Initializable 초기화 관련 메소드 제공
	
	// 현재 클래스를 객체화 [ 클래스 자체의 객체 ] 
		// 1. static 변수 선언
	private static LoginController instance;
	
	public LoginController() {
		// 2. 현재 클래스의 메모리를 호출 = this
		instance = this;
	}
	
	public static LoginController getinstance() {
		return instance;
	}
	
	// fxml 실행시 초기값 설정 메소드
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText(""); // 경고 메시지는 처음에 공백으로 세팅
	}
	
	// 컨트롤명 선언
	
	// 1. 필드
		// 컨트롤 필드 선언
    @FXML
    private Label btnfindid;

    @FXML
    private Label btnfindpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Label btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane loginpane;

    @FXML
    private BorderPane mainboardpane;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    void findid(MouseEvent event) {

    }

    @FXML
    void findpassword(MouseEvent event) {

    }

    @FXML
    void login(ActionEvent event) {
    	if(txtid.getText().equals("admin") && txtpassword.getText().equals("1234")) {
    		lblconfirm.setText("로그인 성공");
    	} else { // 아니면 실패
    		lblconfirm.setText("로그인 실패");
    	}
    }

	@FXML
    void signup(MouseEvent event) {
		loadpage("signup");
	}
	
	// 2. 생성자
	
	// 3. 메소드
		// boarderpane center 변경
	public void loadpage ( String page ) {
		
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainboardpane.setCenter(parent);
		} catch (IOException e) {}
		
	}
}
