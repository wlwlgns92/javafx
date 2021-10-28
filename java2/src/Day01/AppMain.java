package Day01;

import javafx.application.Application;
import javafx.stage.Stage;
		// import javafx
public class AppMain extends Application {
						// Application 상속받기
	
	public AppMain() {
		System.out.println(Thread.currentThread().getName()+ " Appmain() 호출");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " init() 호출");
	}
	
	// 2. 오버라이딩 : start 메소드
	@Override
	public void start(Stage primaryStage) throws Exception {
						// 3. Stage 이름 정하기
		System.out.println(Thread.currentThread().getName()+ " start() 호출");	
		// 4. 해당 Stage 실행
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " stop() 호출");
	}
	// 스레드이기때문에 main 은 필수!!
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+ " main() 호출");
		launch(args); // 5. Start 메소드 호출
	}

}