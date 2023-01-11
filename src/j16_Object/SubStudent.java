package j16_Object;

import java.util.Objects;

public class SubStudent {
	
	private String name;
	private int age;
	
	// alt + shift + s 눌러서 단축키 사용
	public SubStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	

}
