package j02_변수;

public class Variable1 {

	public static void main(String[] args) {
		int num = 0; // 선언과 초기화를 동시에 명시
		
		int num2; // 4byte의 메모리 공간을 할당할 것이고 그 공간의 이름을 num2라 하겠다! 선언
		num2 = 10; // num2변수명을 가진 메모리 공간의 데이터를 비우고 10의 값을 대입하겠다. 초기화
		
		System.out.println(num2 + 1);	// num + 1 => 1, if num2 + 1 => 11 : num에는 값을 대입하지 않고 0으로 초기화를 시켜놓았고, num2에는 10을 대입해놔서 값이 저래된다.
		

	}

}
