package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault; // 다른 패키지의 자료형을 쓰고 싶으면 import를 꼭 써야한다

public class J11_StudentMain {
	
	public static void main(String[] args) {
		
		J11_Student s1 = new J11_Student();
//		s1.name = "장진원";
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
//		s2.name = "김루아";
//		
//		System.out.println("이름: " + s2.name);
		System.out.println("이름: " + s2.getName());
		
	}

}