package j06_조건;

public class Switch1 {
	public static void main(String[] args) {
		
		String select = "D선택"; 
		// switch안에 case를 찻아가서 순차적으로 나옴
		//brsak를 입력하지 않으면 String select = "A선택"; 선택시 전부 출력됨,맨 마지막 줄엔 break입력 안함
		switch (select) {
			case "A선택" :
				System.out.println("PC(A)를 연결합니다.");
				break;
			case "B선택" :	
				System.out.println("PC(B)를 연결합니다.");
				break;
			case "C선택" :	
				System.out.println("PC(C)를 연결합니다.");
				break;
			case "D선택" :	
				System.out.println("PC(D)를 연결합니다.");
				break;
			default :
				System.out.println("else와 같은 역할");
		}
		
		// case 문에는 중괄호가 따로 존재하지 않음
	}

}
