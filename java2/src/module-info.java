module java2 {
	// 사용할 모듈명
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens Day01 to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	opens fxml to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	opens controller to javafx.graphics, javafx.fxml; // 사용하고자 하는 패키지명 to 모듈명
	
}
