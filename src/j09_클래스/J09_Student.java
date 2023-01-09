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

