package j12_배열;

public class J12_UserMain {
	
	public static void main(String[] args) {
		J12_UserService service = new J12_UserService();
		
		service.run();		// 무한 루프 시작
		service.stop();		// 무한 루프 종료
	}

}
