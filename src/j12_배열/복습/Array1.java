package j12_배열.복습;

public class Array1 {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		int[] nums2 = new int[] {10, 20, 30, 40, 50};	// 인덱스 숫자를 설정해놓지 않고 배열을 만드는 방법
		
		System.out.println(new int[] {10, 20, 30, 40, 50});		// 이렇게도 사용가능 but 이렇게 쓰면 배열의 주소가 출력됨
		System.out.println((new int[] {10, 20, 30, 40, 50})[0]);// 뒤에 인덱스값을 넣어주면 그 인덱스 값 출력 가능
		
		
/*
 * 		배열 : 각각의 종류별로 묶어놓은것, 순서있게 하나의 통에 담아두는 것
 * 		int[] nums -> int형만 담을수 있는 배열		
 */
	}

}
