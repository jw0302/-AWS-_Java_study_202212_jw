package j13_상속.casting;

public class Main {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller(new MainView()); 		// controller 클래스 생성
		controller.run();
		
		System.out.println("프로그램 종료");
		
	}

}
