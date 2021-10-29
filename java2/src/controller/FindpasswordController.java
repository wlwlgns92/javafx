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
    	// Dao ��ü�� findpassword �޼ҵ� ȣ��
    	String result = MemberDao.getMemberDao().findpassword(txtid.getText(), txtemail.getText());
    	if(result != null) {
    		// ���� ����
    		Member.sendmail(txtemail.getText(), result, 2);
    		lblconfirm.setText("�̸��Ϸ� ��й�ȣ�� �����ߴ�");
    	}else {
    		lblconfirm.setText("��ġ�ϴ� ������ ã�� �� �����ϴ�");
    	}
    }
}
