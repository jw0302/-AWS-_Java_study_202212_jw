package study;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	
	private String name;
	
	private int[] nums;
	
	Scanner scanner;
	
	

	public Lotto(String name) {
		super();
		this.name = name;
		nums = new int[6];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void inputNumbers() {
		scanner = new Scanner(System.in);
		for(int i = 0; i < nums.length; i++) {
			System.out.println("번호입력 : ");
			int number = scanner.nextInt();
			nums[i] = number;
		}
		System.out.println(Arrays.toString(nums));
	}
	
	
}
