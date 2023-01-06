package j06_조건;

import java.util.Scanner;

public class Conditional3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.println("점수 입력 : ");
		score = scanner.nextInt();
		
//		if (score < 0 || score > 100) {
//			System.out.println("계산불가" + grade);
//		}
		if (score < 0 || score > 100) {
			grade = null;
		}else if (score > 89) {
			grade = "A";
		}else if (score > 79) {
			grade = "B";
		}else if (score > 69) {
			grade = "C";
		}else if (score > 59) {
			grade = "D";
		}else {
			grade = "F";
		}
//		if (score < 0 || score > 100) {
//			grade = null;
//		}else if (score < 60) {
//			grade = "F";
//		}else if (score < 70) {
//			grade = "D";
//		}else if (score < 80) {
//			grade = "C";
//		}else if (score < 90) {
//			grade = "B";
//		}else {
//			grade = "A";
//		}
		
		if ((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}
		
		if (grade == null) {
			System.out.println("계산 불가");
		}else {
			System.out.println("점수(" + score + "): " + grade + "학점");
		}
	}
}
