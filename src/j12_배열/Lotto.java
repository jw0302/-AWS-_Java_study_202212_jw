package j12_배열;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
			Random random = new Random();
			Scanner scanner = new Scanner(System.in);
			
			int[] nums = new int[6]; 
			int num;
			
			System.out.print("숫자 입력: ");
			num = scanner.nextInt();
			
			System.out.println();
			
			for (int i = 0; i < nums.length; i++) {
				while (true) { 
					boolean findFlag = true;
					
					int randomNum = random.nextInt(44) +1; 
					
					for (int j = 0; j < nums.length; j++) {
						if (nums[j] == randomNum) {
							findFlag = false; 
							break;
						}
					}
					
					if (findFlag) {
						nums[i] = randomNum;
						break;  
					}
				}
			}
			
			for (int i = 0; i < nums.length; i++) {
				System.out.print("이번주 로또 당첨 번호는 : " + nums[i]);
			}
			
	}
	

}
