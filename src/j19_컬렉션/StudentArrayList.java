package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
	
	public static void updateYear(
			List<Student> students,
			String searchName,
			int newYear) {
		
		for(Student student : students) {
			if(student.getName().equals(searchName)) {
				student.setYear(newYear);
				System.out.println("검색 성공!");
				System.out.println(student);
				return;
			}
		}
		
		System.out.println("검색실패!!!");
		
	}
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("김종환", 1));
		students.add(new Student("손민재", 2));
		students.add(new Student("잔나비", 3));
		students.add(new Student("김부각", 4));
		
		System.out.println(students);
		
		String searchName = "장진원";
		// 이름이 searchName인 학생을 찾아서 학년을 4학년으로 바꿔라
		// 만약 searchName 동일한 이름이 없으면 "검색실패" 메세지 출력
		
		boolean flag = true;							// flag에 true넣기
		
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);			// 리스트에서 i 번째에 있는 학생 꺼냄
			if(student.getName().equals(searchName)) {	// 꺼낸 학생의 이름과 searchName 비교하기
				student.setYear(4);						// searchName이 맞으면 그 학생의 학년 4학년으로 바꾸기
				flag = false;							// flag에 펄스 넣어주기
				break;									// 멈추기
			}
		}
		
		for(Student student : students) {
			if(student.getName().equals(searchName)) {	
				student.setYear(4);						
				flag = false;
				System.out.println("검색성공!!!");
				break;									
			}
		
		}
		
		if(flag) {
			System.out.println("검색실패!!!");
		}
		
//		System.out.println(students);
//		

		updateYear(students, "김부각", 1);
		
		
		
	}


}
