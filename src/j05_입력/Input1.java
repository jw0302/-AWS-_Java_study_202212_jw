package j05_입력;

import java.util.Scanner;

public class Input1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // 변수 선언은 항상 위에 표시
		int inputNum1 = 0;                        // 초기화도 꼭 기입
		int inputNum2 = 0;                        // 멤버 변수는  = 0;을 안 써도 되지만 main안에 있을때는 쓰는게 좋다
		int inputNum3 = 0;
		int inputNum4 = 0;
		int inputNum5 = 0;
		
		System.out.print("입력1 : ");
		inputNum1 = scanner.nextInt(); // 이거 자체가 입력이라 하나 달때마다 한번 입력
		System.out.print("입력2 : ");
		inputNum2 = scanner.nextInt();
		System.out.print("입력3 : ");
		inputNum3 = scanner.nextInt();
		System.out.print("입력4 : ");
		inputNum4 = scanner.nextInt();
		System.out.print("입력5 : ");
		inputNum5 = scanner.nextInt();
		
		System.out.println("입력값 : " + (inputNum1 + inputNum2 + inputNum3 + inputNum4 + inputNum5));
		
		// 빨간줄이 뜨면 무조건 마우스를 올려서 무슨 문제인지 보기
		
		/*
		 * 1. ctrl + shift + O   *단어가 완전히 완성된 후에 사용 가능
		 * 2. ctrl + space bar + enter *단어 완전 완성 전 사용 가능
		 * 3. ctrl + space bar + enter 자동 완성 많이 쓰기
		 */

	}

}
