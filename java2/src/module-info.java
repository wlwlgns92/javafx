module java2 {
	// ����� ����
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens Day01 to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	opens fxml to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	opens controller to javafx.graphics, javafx.fxml; // ����ϰ��� �ϴ� ��Ű���� to ����
	
}
