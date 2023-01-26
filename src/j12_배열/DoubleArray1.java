package j12_배열;

// 이차원 배열
public class DoubleArray1 {
	
	public static void main(String[] args) {
		
		int num = 0; 													
		
		int[] nums = new int[2];
		
		int[][] d_nums = new int[3][2]; 					// [][] 대괄호 두개에서 두번째 대괄호는 int 배열을 담는 배열 이라는 뜻 but, 앞에 대괄호보다 뒤에 대괄호가 하위다
																	
		// 잘 못된 접근 방식
//		d_nums[0][0] = 1; 										    
//		d_nums[1][0] = 2;
//		d_nums[2][0] = 3;
//		
//		d_nums[0][1] = 4;
//		d_nums[1][1] = 5;
//		d_nums[2][1] = 6;
		
		// 올바른 접근 방식
		d_nums[0][0] = 1;
		d_nums[0][1] = 4;
		
		d_nums[1][0] = 2;
		d_nums[1][1] = 5;
		
		d_nums[2][0] = 3;
		d_nums[2][1] = 6;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(d_nums[j][i]);
			}
		}
		
		int[][] d_nums2 = new int[][] {{1, 2, 3}, {5, 6}};
		
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.println(d_nums2[i][j]);
//			}
//		}
		
		System.out.println(d_nums2[1].length); 										// 두번째 배열의 길이보기, 안쪽 배열 길이 보려면 []안에 0 or 1 적으면 된다
		
		System.out.println();
		
		for (int i = 0; i < d_nums2.length; i++) {
			for (int j = 0; j < d_nums2[i].length; j++) {
				System.out.println(d_nums2[i][j]);
			}
		}
	}

}
