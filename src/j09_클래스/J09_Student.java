package j09_클래스;

public class J09_Student {
	
	String name = "장";
	int age = 100;
	
	// 기본생성자     /클래스 안은 다른거 넣지 않는다.
	J09_Student() {
		System.out.println("생성됨!!!!");
	}
	
	void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
}

// 클래스의 가장 큰 특징은 변수와 메소드를 묶어놓은것 
// protected 상속이 되어지면 다른 클래스에 있어도 접근 가능
// default 와 상속은 속성이 동일하다