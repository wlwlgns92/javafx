module java2 {
	// 사용할 모듈명
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires mail; 		// 메일 관련 라이브러리
	requires activation; // 메일관련 라이브러리
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens Day01 to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	opens fxml to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	opens controller to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	opens Day02 to javafx.graphics, javafx.fxml;
	opens dao to java.sql;
	opens domain to mail, activation;
}
