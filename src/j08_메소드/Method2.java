package j08_메소드;

public class Method2 {
	
	// 매개변수(입력): x, 반환: x                    // 매개변수는 method() 에서 () 안에 정의 
	public static void method1() {
		System.out.println("안녕하세요. ");          // 하나의 단위
		System.out.println();
	}
	
	// 매개변수: int 하나입력, 반환: x
	public static void method2(int num) {
		System.out.println("num : " + num);
	}
	
	// 매개변수: int 두개 입력, 반환: x
	public static void method3(int num, int num2) {
		System.out.println("num : " + num);
		System.out.println("num2 : " + num2);
		System.out.println();
	}
	
	
	public static String method4() {
		return "데이터 반환";                        // 반환은 여러개의 값은 할수 없다, 딱하나의 변수만 반환 가능
	}
	
	
	public static String method5(int age) {
		String ageStr = age + "살";
		return ageStr;
	}
	
	public static void main(String[] args) {
		String ageStr = "30살"; // 메소드5안에 쓴 것과 메인 안에 쓴것은 서로 다른 독립된 존재 영향 안 받음
		
		method1(); // 함수 호출                      // 호이스팅
		method2(100);
		method3(200, 300);
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(30));
		System.out.println();
	}

}
