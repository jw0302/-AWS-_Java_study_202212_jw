package examTest;

class Calculator {
	
	public int add(int num1, int num2) {
		int add = num1 + num2;
		
		return add;
	}
	
	public int sub(int num1, int num2) {
		int sub = num1 - num2;
		
		return sub;
	}

}

public class Main {
	
	public static void main(String[] args) {
		
		Calculator calculator1 = new Calculator();
		Calculator calculator2 = new Calculator();
		
		System.out.println(calculator1.add(10, 20));
		System.out.println(calculator2.sub(200, 100));
		
	
	}
	

}
