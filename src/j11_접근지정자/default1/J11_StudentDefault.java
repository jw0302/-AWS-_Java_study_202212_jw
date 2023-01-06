package j11_접근지정자.default1;

public class J11_StudentDefault { //class에 public을 쓰지 않으면 import를 써도 다른 패키지의 자료형 접근 불가
	
	private String name;
	private int age;                 //모든 멤버변수들은 private 필수
	
	public J11_StudentDefault() {
		
	}
	
	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름: " +name);
		System.out.println("나이: " +age);
	}
	
	// Getter
	public String getName() {
		return name;
	}
	
	// Setter
	public void setName(String name) {
		this.name = name;
	}
	
}
// Alt + shift + s 단축키