package j05_입력;

import java.util.Scanner;

public class Input2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열1 : ");
		String str1 = scanner.nextLine();
		// nextLine(); -> 뛰어쓰기 허용, 이것빼고 나머지는 전부 뛰어쓰기 허용 하지 않음
		System.out.print("문자열2 : ");
		String str2 = scanner.next(); 
		// next() -> 뛰어쓰기 할수 없음, 뛰어쓰기를 쓸때마다 enter와 같은 역할을 함
		
		System.out.print("정수 : ");
		int number1 = scanner.nextInt();
		
		System.out.print("실수 : ");
		double number2 = scanner.nextDouble();
		
		System.out.println("문자열1 : " + str1);
		System.out.println("문자열2 : " + str2);
		System.out.println("정수 : " + number1);
		System.out.println("실수 : " + number2);

	}

}
