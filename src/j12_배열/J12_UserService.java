package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner;
	private char select;
	private J12_UserRepository userRepository;
	
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}
	
	public void run() {
		boolean loopFlag = true;
		select = '\0';
				
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}		
	}
	
	public void stop() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private char inputSelect(String menuName) {
		System.out.print(menuName + " 메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}
	
	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자 이름으로 사용자 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	private void showUsers() {
		
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("========<< 회원 전체 조회 >>========");
		
		for (J12_User user : users) {
			System.out.println(user.toString());
		}
		
		System.out.println("=====================================");
		
	}
	
	private void registerUser() {
		J12_User user = new J12_User();
		
		System.out.println("==========<< 회원 등록 >>==========");
		System.out.print("사용자이름 : ");
		user.setUsername(scanner.nextLine());
		 
		System.out.print("비밀번호 : ");
		user.setPassword(scanner.nextLine());
		
		System.out.print("성명 : ");
		user.setName(scanner.nextLine());
		
		System.out.print("이메일 : ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user);
	}
	
	private void findUserByUsername() {
		J12_User findUser = new J12_User();
		
		System.out.print("사용자 이름 : ");
		findUser.setUsername(scanner.nextLine());
		
		System.out.println(findUser.toString());
		
	}
	
	private void updateInfomation() {
		J12_User updateUser = new J12_User();
		
		System.out.print("수정 할 사용자이름을 입력하세요 : ");
		updateUser.setUsername(scanner.nextLine());
		
		System.out.println("==========<< 수정메뉴 >>==========");
		System.out.println("사용자이름 : ");
		System.out.println("=================================="); 
		System.out.println("1. 비밀번호 변경 : ");
		System.out.println("2. 이름 변경 : ");
		System.out.println("3. 이메일 변경 : ");
		System.out.println("==================================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}
	
	
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				showUsers();
			}else if(select == '2') {
				registerUser();
			}else if(select == '3') {
				findUserByUsername();
			}else if(select == '4') {
				updateInfomation();
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
			
		return flag;
	}
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
}






















