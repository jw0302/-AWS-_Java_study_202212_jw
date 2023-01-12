package j17_스태틱.싱클톤;

public class A {
	
private static A instance = null;
	
	private Student[] students;
	
	private A() {
	 	students = new Student[3];
	}					
	
	public static A getInstance() {
		if(instance == null) {
			instance = new A();
		}
		return instance;
	}
	
	public void addStudent(Student student) {
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return;
			}
		}
	}

	public void showStudents() {
		
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

}
