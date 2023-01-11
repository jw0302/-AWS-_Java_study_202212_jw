package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	
	public static void main(String[] args) {
		
		Student student = new Student("김재영", 29);
		
		System.out.println(student.getClass());					
		System.out.println(Student.class);						 
		
		System.out.println(student.getClass().getName());
		
		Class studentClass = student.getClass();
		
		String className = studentClass.getName();							// student.getClass().getName() 와 studentClass.getName(); 같은 의미다.
		System.out.println("클래스 이름 : " + className);
		
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만 : " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		Method[] methods = studentClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
	}

}

// 생성된 객체.getclass() == 클래스명.class() 두개가 불러온 정보가 같은지 다른지 비교 가능