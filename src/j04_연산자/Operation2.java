package j04_연산자;

public class Operation2 {
	public static void main(String[] args) {
		int num = 10;
		
		num = num + 1; // 프로그래밍에서 = 같다라는 의미가 아니라 대입
//		num++; // 위의 연산과 같은 의미
		
		System.out.println(num++); // ++ 앞에 붙으면 선증가, 뒤에 붙으면 후증가
		System.out.println(num); // 선증가보다 후증가를 더 많이 쓴다
	}
}
