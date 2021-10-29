module java2 {
	// ����� ����
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires mail; 		// ���� ���� ���̺귯��
	requires activation; // ���ϰ��� ���̺귯��
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens Day01 to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	opens fxml to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	opens controller to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	opens Day02 to javafx.graphics, javafx.fxml;
	opens dao to java.sql;
	opens domain to mail, activation;
}
