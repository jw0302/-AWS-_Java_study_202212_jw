package j12_배열;

public class J12_UserMain {
	
	public static void main(String[] args) {
		J12_User[] users = new J12_User[0];
		
		J12_UserRepository userRepository = new J12_UserRepository(users);
		
		J12_UserService service = new J12_UserService(userRepository);
		
		
		service.run();		// 무한 루프 시작
		service.stop();		// 무한 루프 종료
	}
	/*
	 * 1. 사용자 이름으로 회원 조회
	 * 
	 * 2. 회원 정보 수정
	 * 		
	 * 		1. 비밀번호 변경
	 * 		2. 이름 변경
	 * 		3. 이메일 변경
	 * 
	 * 		b. 뒤로가기
	 */

}

