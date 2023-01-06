package jo9_클래스;

import java.util.Scanner;

public class J09_UserMain2 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		
		J09_User2 num = new J09_User2();
		
		System.out.print("이름 : ");
//		num.name = scanner.next();

		
//		num.name = "장진원";  
		num.age = 25;
		num.address = "부산진구 연지동";
		num.phone = "010-7753-4493";
		
		num.printUserInfo();		
		
		
		
	}

}
