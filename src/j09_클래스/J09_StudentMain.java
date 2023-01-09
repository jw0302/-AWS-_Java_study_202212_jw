package j09_클래스;

public class J09_StudentMain {
	
	public static void main(String[] args) {
		
		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();
		
		s1.name = "장진원";
		s1.age = 30;
		
		s1.printInfo();
		
		s2.printInfo();
//		J09_Student student1 = new J09_Student(); // = 은 값을 넣는 행위
//		J09_Student student2 = new J09_Student(); // new -> 동적 메모리 할당
//		 자료형      변수명   키워드   생성자
//		new와 생성자를 따로 보지 말기 		
		
//		System.out.println(student1);
//		System.out.println(student2);
		
	}
}

// 스텍(정적) -> 변수명 , 힙 (동적) -> 생성자
// 빌리는 과정 -> 동적 메모리 할당    빌리는 행위 -> 생성
// ex) str . .찍는 행위 참조
/* 생성자는 클래스명이랑 일치
 * 
 * 
 */