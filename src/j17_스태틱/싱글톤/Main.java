package j17_스태틱.싱글톤;

public class Main {
	
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B(a);
		C c = new C(a, b);
		
		for(int i = 0; i < 4; i++) {
			b.insertStudent();
		}
	}

}
