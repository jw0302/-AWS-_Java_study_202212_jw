package j12_배열;

public class Array1 {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		
		
		int[] nums = new int[5];     // new가 들어가면 참조 자료형 // 모든 자료형은 배열로 만들 수 있다.
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		for (int i = 0; i < 5; i++) {
			System.out.println(nums[i]);
		}
		
		
	}

}
