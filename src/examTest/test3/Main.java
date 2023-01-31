package examTest.test3;

import java.util.ArrayList;
import java.util.List;

class Student {
	private int studentCode;
	private String studentName;
	
	public Student(int studentCode, String studentName) {
		this.studentCode = studentCode;
		this.studentName = studentName;
	}
	
	public void showStudent() {
		System.out.println("학번: " + studentCode + ", " + "이름: " +studentName);
	}
}

public class Main {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1001, "홍길동"));
//		students.add(null);									// 원래 문제에는 이렇게 표시되어 있어서 nullpoint 에러를 잡는 문제였다.
		students.add(new Student(1002, "강철수"));			// 해결 답안
		students.add(new Student(1003, "김영희"));
		
		for(Student student : students) {
			student.showStudent();
		}
	}

}
