package j12_배열;

import java.util.Random;
import java.util.Scanner;

public class Array3 {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] nums = new int[10]; // nums라는 10개의 공간 생성
		
		for (int i = 0; i < nums.length; i++) {
			while (true) { // 무한 루프(반복) 시작
				boolean findFlag = true;
				
				int randomNum = random.nextInt(nums.length) +1;  // 계속해서 랜덤되는 숫자 생성
				
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == randomNum) {
						findFlag = false; //선형 탐색/순차 탐색
						break;
					}
				}
				
				if (findFlag) {
					nums[i] = randomNum;
					break;   // while을 멈춰주는 break
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		
				//프로그램의 시작은 항상 0부터
//		System.out.println(random.nextInt(10));

	}
}










