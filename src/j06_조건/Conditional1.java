package j06_조건;

import java.util.Scanner;

public class Conditional1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		int a, b, c;
//		a = b = c = 0; // 쓸수 있지만 좋은 코드작성법은 아니다.
		
		int a = 0;
		int b = 0;
		int c = 0;
		int max = 0;
		int min = 0;
		
		System.out.println("정수 3개 입력 : ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		max = a;
		min = a;
		
		if (b > max) max = b;  //이렇게 할 수 있지만 중괄호 치는게 원칙 
		if (c > max) max = c;
		
		if (b < min) min = b;
		if (c < min) min = c;
		
//		if (max = a) {
//			max = b > max ? b : max;
//			max = c > max ? c : max;
//			System.out.println("최대값 : " + max);
//		} else if (min = a) {
//			min = b < min ? b : min;
//			min = c < min ? c : min;
//		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}
}