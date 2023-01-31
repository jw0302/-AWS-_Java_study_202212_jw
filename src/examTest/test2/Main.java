package examTest.test2;

import java.util.Arrays;
import java.util.List;

class SubjectService {
	private List<String> subjects;
	
	public SubjectService(List<String> subjects) {
		this.subjects = subjects;
	}
	
	public void showSubjects() {
		int length = 3;								// 원래 문제에서는 값이 4로 되어 있어서 오류가 떳었음 3으로 바꺼주면 됨
		for(int i = 0; i < length; i++) {
			System.out.println(subjects.get(i));
		}	
	}
	
}

public class Main {
	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[]{"C", "Java", "Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects();
	}
	
}
