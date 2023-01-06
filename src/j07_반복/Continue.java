package j07_반복;

public class Continue {

	public static void main(String[] args) {
		
		int i = 0;
		
		while (i < 10) {
			
			if (i % 2 != 0) {
				i++;
				continue;
			}
			System.out.println("i : " + i);
			i++;
		}
		
//		for (int i =0; i < 10; i++) {
			
//			if (i % 2 != 0) { // i % 2 != 0 -> i를 2로 나눈 나머지가 0이 아닐때, 즉 홀수일때
//				continue; // 다음 반복을 계속해라 
//			}
			
//			System.out.println("i : " + i);
			
//		}

	}

}
