package j17_스태틱;

public class Student {
	
	private static final int CODE = 20230000;
	private static int ai = 1;	// auto_increment(자동 증가)
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		
		this.name = name;
		
	}
	
	public static int getAutoIncrement() {				//static 메소드 안에서는 static 변수만 쓸수 있다. 단 지역변수는 가능
		System.out.println("현재 AI : " + ai);
//		System.out.println("학생이름 : " + name);		// 꼭 메모리 할당된 후 에만 호출 가능한 변수 : name
		return ai;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	

}
