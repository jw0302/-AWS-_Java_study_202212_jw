package j03_형변환;

public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int) char_a; // 형 변환
		
		char char_b = (char) (num + 1); // 연산보다 형 변환이 우선순위가 더 높기 때문에 ()를 하지 않으면 연산 안됨 
		// 하위 자료형으로 형 변환 (다운캐스팅)
		
		System.out.println('a' + 1);
		System.out.println(char_b);
		
		// 상위로 갈때는 묵시적 형 변환, 하위로 갈때는 명시적 형 변환
		
	}

}
