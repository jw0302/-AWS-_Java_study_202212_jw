package j17_스태틱.싱글톤;

public class A {
	
//	private Student[] students;
	
	private static A instance = null;
	
	private A() {
	 	Student[] students = new Student[3]; 
	}					// 싱글톤은 딱 하나만 존재해야 하기 때문에 생성자가 private이다.
	
	public static A getInstance() {
		if(instance == null) {
			instance = new A();
		}
		return instance;
	}
	
		
//		System.out.println("더 이상 학생을 추가할 수 없습니다. ");
//		System.out.println();
		
		//break를 쓸거면 만들어야 하는 코드 (효율성 떨어지는 방식)
//		boolean flag = true;
//		
//		for(int i = 0; i < students.length; i++) {
//			if(students[i] == null) {
//				students[i] = student;
//				flag = false;
//				break;
//			}
//		}
//		
//		if(flag) {
//			System.out.println("더 이상 학생을 추가할 수 없습니다. ");
//			System.out.println();
//		}
		
		

	
	public void showStudents() {
		
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

}
