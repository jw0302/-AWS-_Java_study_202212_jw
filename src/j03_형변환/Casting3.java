package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		// 현재 소수점이 붙은 상태
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		int total = (int) kor + (int) eng + (int) math; 	// 소수점이 붙은 수들이 대입되어 있는 변수들에 정수형 int로 형변환
		double avg = (double) total / 3.0;
		
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);
	}

}