package j10_생성자;

public class J10_Student {
	
	public String name;
	public int age;      // 참조변수=레퍼런스변수=멤버변수   기본적으로는 멤버 변수라고 부름
	
	// 전역에 선언이 되어 있는데 지역에 들어가는건 원래 안된다
	
	J10_Student() {
		System.out.println("기본 생성자 호출 ");
	}
	
	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
	J10_Student(String name, int age) {
		this.name = name;
		this.age = age;                  
	}
	
	void printInfo() {
		System.out.println("학생 이름: " + name);
		System.out.println("학생 나이: " + age);
	}
	
}
// this -> 자기 자신의 주소
//_변수명 달리주는방법 좋지않은 방법