package j08_메소드;

public class Method3 {
	
	// 메소드 오버로딩(오버라이딩)
	// 오버로딩 : 불러오는것 부를때 쓰는것 호출할때
	// 오버라이딩(오버라이드) : 쓰는것 덮어쓰는것 다시쓴다
	
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	
	// 매개변수의 이름이 들어가면 같은 이름을 여러번 쓸수 있다.
	public static void ov1(int a) {
		System.out.println("int 매개변수 하나");
	}
	
	public static void ov1(int a, String b) {
		System.out.println("int 먼저 그다음 String");
	}
	
	public static void ov1(String a, int b) {
		System.out.println("String 먼저 그다음 int");
	}

	public static void main(String[] args) {
		
		ov1();
		ov1("만", 20);

	}

}
