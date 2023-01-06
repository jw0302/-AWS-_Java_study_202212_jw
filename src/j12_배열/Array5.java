package j12_배열;

// 배열이 생성되지 않은 기존 배열에 배열 생성하기	//캡슐화 
public class Array5 {
	
	public static void transferArray(int[] oldArray, int[] newArray) {
		
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public static int[] addArrayLength(int[] array) {
		
		int[] newArray = new int[array.length + 1];
		transferArray(array, newArray);
		 
		return newArray;
	}
	
	public static int[] addData(int[] array, int data) {	// 2.아무것도 없는 배열을 넘겨 받음
		int[] newArray = addArrayLength(array);		// addArrayLength(array) 배열의 길이를 추가하는 행위
		newArray[array.length] = data;
		return newArray;
	}
	
	public static void main(String[] args) {			// 메소드 명만 보고도 무슨 뜻인지 알아야 한다.
		
		int[] nums = new int[0];		// 1.아무것도 없는 배열
		
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
