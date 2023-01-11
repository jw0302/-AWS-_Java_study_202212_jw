package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		
		String name1 = "김준일";
		String name2 = "김준일";
		String name3 = new String("김준일");
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1 == name2);			// 주소값 비교
		System.out.println(name1.equals(name3));	// equals 는 문자열 비교할때 쓴다
		
/////////////////////////////////////////////////////////////////
		
		Student s1 = new Student("박은빈", 24);
		Student s2 = new Student("박은빈", 24);
		SubStudent s3 = new SubStudent("박은빈", 24);
		
		
		System.out.println(s2.equals(s3));
		
	}

}
// 상수는 무조건 초기화가 한번 일어나야 한다.