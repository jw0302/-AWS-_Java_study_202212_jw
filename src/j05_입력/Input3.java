package j05_입력;

import java.util.Scanner;

public class Input3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		//(System.in) -> 운영체제 의미, 콘솔창에다 입력을 하는것
		
		String name = null;
		int age = 0;
		String address = null;
		String phone = null;
		
		System.out.print("이름 : ");
		name = scanner.next();
		// next -> 아무것도 입력하지 않고 space bar와 enter를 누르면 무시
		
		System.out.print("나이 : ");
		age = scanner.nextInt();
		scanner.nextLine(); 
		// nextLine(); 쓰기 전에 중간에 한번더 호출해 허공에 날려줘야 다음 nextLine();때 잘 동작된다.
		
		System.out.print("주소 : ");  
		address = scanner.nextLine();
		
		System.out.print("연락처 : ");
		phone = scanner.next();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("연락처 : " + phone);
		
		System.out.println("사용자의 이름은 " + name + "이고 나이는 " + age + "살 입니다.");
		System.out.println("주소는 " + address + "에 거주중입니다.");
		System.out.println("연락처는 " + phone + " 입니다.");

	}

}
