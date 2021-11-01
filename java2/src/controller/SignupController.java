package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SignupController implements Initializable {
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

    @FXML
    private Text btnback;

    @FXML
    private Button btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    void back(MouseEvent event) {
    	// !! ���ο� ��ü ����ÿ��� ���ο� �޸�
    //LoginController loginController = new LoginController();
    	
    	// ������ �޸� ����ϱ� ���ؼ� this Ű���带 ����� ��ü ȣ��
    	LoginController.getinstance().loadpage("login");
    	
    }
    @FXML
    void signup(ActionEvent event) {
    	
    	// ��Ʈ�� ȣ��� = > fx:id ȣ�� [��ü]
    	
    	// 1. ��ȿ���˻�
    	if(txtid.getText().length() < 4 || txtid.getText().length() > 13) {
    		lblconfirm.setText("���̵�� 4~12���ڷ� �����մϴ�"); // ���̺� ���� ����
    		return; // �޼ҵ� ��
    	}
    	// 1.2 �н����� ����üũ
    	if(txtpassword.getText().length() < 4 || txtpassword.getText().length() > 9) {
    		lblconfirm.setText("��й�ȣ�� 4 ~ 8 �ڸ��� �����մϴ�.");
    		return;
    	}
    	// 1.3 �н����� Ȯ�� üũ
    	if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
    		lblconfirm.setText("��й�ȣ�� �������� �ʽ��ϴ�.");
    		return;
    	}
    	// �̸� ���� üũ
    	if(txtname.getText().length() < 2 ) {
    		lblconfirm.setText("�̸��� �� ���� �̻� �����մϴ�.");
    		return;
    	}
    	if(txtemail.getText().length() < 5 || !txtemail.getText().contains("@")) {
    		lblconfirm.setText("5���� �̻� �Է°� @�̸� ���Խ����ּ���");
    		return;
    	}
    	// 2. �ߺ�üũ
    	
    	// 3. ��üȭ
    	Member member = new Member(txtid.getText(), txtpassword.getText(), txtname.getText(), txtemail.getText());
    	
    	
    	// 4. ���� Ȥ�� DBó��
    	boolean result = MemberDao.getMemberDao().signup(member); // DB �޼ҵ� ȣ��
    	if(result) { // DB ������
    		lblconfirm.setText("�������ּż� �����մϴ�.");
    		
    		Alert alert = new Alert(AlertType.INFORMATION); // �޽��� ��ü ����
        	alert.setContentText("�������� 1000�� �ٰԿ�"); // �޽��� ����
        	alert.setHeaderText("ȸ������ ����"); // 3. �޽��� ����
        	alert.setTitle("��ī��ī");
        	alert.showAndWait();// �޽��� ���� ��ư �Է½ñ��� ���
        	LoginController.getinstance().loadpage("login"); // �α��� fxml ���Ϸ� �̵�
    	}else {
    		lblconfirm.setText("ȸ������ ���� ");
    	}
    	
    	
    	
    	
    	// 5. �޽���â ���� ������ ��ȯ
    	
    	
    	

    	
    }
}
