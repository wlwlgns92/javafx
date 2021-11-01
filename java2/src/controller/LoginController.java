package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		// 로그인시 입렫된 아이디 반환
	public String getid() {
		return txtid.getText();
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
    	loadpage("findid");
    }

    @FXML
    void findpassword(MouseEvent event) {
    	loadpage("findpassword");
    }

    @FXML
    void login(ActionEvent event) {
    	// 1. dao객체 메소드 호출 [ login 메소드의 아이디와 비밀번호 넣기
    	boolean result = MemberDao.getMemberDao().login(txtid.getText(), txtpassword.getText());
    	if(result) {
    		lblconfirm.setText("로그인 성공");
    		
    		// 기존 스테이지 종료
    		btnlogin.getScene().getWindow().hide(); // 해당 버튼의 씬 윈도우 숨기기
    		
    		// 메인 스테이지
    		Stage stage = new Stage();
    		try {
				Parent parent = FXMLLoader.load(getClass().getResource("/fxml/mainpage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false); // 스테이지 크기 고정
				stage.setTitle("ㅋㅋㅋ"); // 스테이지 이름
				// 스테이지 아이콘
					// 1. 이미지 불러오기
					Image image = new Image("file:D:\\조지훈\\java2\\src\\fxml\\아이콘.png");
					stage.getIcons().add(image);
				stage.show();
			} catch (IOException e) {	}
    		
    	} else { // 아니면 실패
    		lblconfirm.setText("로그인 실패");
    	}
    }

	@FXML
    void signup(MouseEvent event) {
		loadpage("signup");
	}
	
		// boarderpane center 변경
	public void loadpage ( String page ) {
		try {
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainboardpane.setCenter(parent);
		} catch (IOException e) {}
		
	}
}
