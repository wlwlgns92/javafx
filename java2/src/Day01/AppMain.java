package Day01;

import javafx.application.Application;
import javafx.stage.Stage;
		// import javafx
public class AppMain extends Application {
						// Application ��ӹޱ�
	
	public AppMain() {
		System.out.println(Thread.currentThread().getName()+ " Appmain() ȣ��");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " init() ȣ��");
	}
	
	// 2. �������̵� : start �޼ҵ�
	@Override
	public void start(Stage primaryStage) throws Exception {
						// 3. Stage �̸� ���ϱ�
		System.out.println(Thread.currentThread().getName()+ " start() ȣ��");	
		// 4. �ش� Stage ����
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " stop() ȣ��");
	}
	// �������̱⶧���� main �� �ʼ�!!
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+ " main() ȣ��");
		launch(args); // 5. Start �޼ҵ� ȣ��
	}

}