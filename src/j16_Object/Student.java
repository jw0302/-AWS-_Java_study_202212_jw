package j16_Object;

import java.util.Objects;

// extends Object 모든 클래스에 있지만 전부 생략되어 있는 상태, 따로 입력하지 않아도 있음
public class Student {
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();					// 부모 클래스 생성자 호출 코드, 현재 따로 상속을 하진 않았지만 Object가 상속으로 되어있다.
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj.getClass() == Student.class)) {				//instanceof 써서 비교하지 말고 .getclass==.class 로 비교하자
			return false;
		}
		
		Student s = (Student) obj;
		
		boolean result = name.equals(s.name) && age == s.age; 		// 나이가 바껴도 계속 트루이기 때문에 && age == s.age; 이걸 입력해서 나이가 다르면 false가 나오게 한다.
		
		return result;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age;
	}

}
