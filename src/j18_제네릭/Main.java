package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		TestData<Integer> td = new TestData<Integer>(30, 32.5);
		TestData<String> td2 = new TestData<String>("juw", 302.1);
		System.out.println(td);
		System.out.println(td2);
	}  

}