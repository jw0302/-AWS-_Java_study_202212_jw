package j12_배열;

public class Array6 {

	public static void main(String[] args) {
		
		String[] names = {"박성진", "조병철", "황창욱"};
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println("==========<forEach>=========="); 		// for ()안에 배열이 들어감
		
		for (String name : names) {
			System.out.println(name);
//			name = "김준일";
		}
		
		int[] nums = {1, 2, 3, 4, 5};
		
		for (int i : nums) {
			System.out.println("i : " + i);
		}

	}

}
