package j06_조건;

public class Conditional2 {
	public static void main(String[] args) {
		
		int num = 10;
		int num2 = 8;
		
//		if(num > num2) System.out.println("num이 num2보다 큽니다.");
		// (num > num2) 괄호 안에 있는 조건이 참이면 if가 실행, 거짓이면 else 실행
//		if(num == num2) System.out.println("num이 num2가 같습니다.");
		
//		if(num < num2) System.out.println("num이 num2보다 작습니다.");
		
		// 조건이 3번 일어남 = 비용처리가 3번이나 일어남
		
		if(num > num2) { 
			System.out.println("num이 num2보다 큽니다.");
			System.out.println("num : " + num);
		// 조건 절 뒤에는 명령이 들어올수 있다
		}else if(num == num2) { 
		// 중괄호를 치면 명령문이 여러개 들어갈 수 있다
			System.out.println("num이 num2가 같습니다.");
		//if와 else는 하나의 명령문만 실행할 수 있다.
		}else {
			System.out.println("num이 num2보다 작습니다.");
		}
	
		// 하나의 명령은 중괄호를 하나만 써도 된다. 
		//else는 혼자 쓸 수 없다 if가 항상 있어야 함
		
		// 비용처리가 2번으로 줄음
		
		
	}
}
