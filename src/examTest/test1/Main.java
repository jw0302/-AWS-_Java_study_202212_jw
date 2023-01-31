package examTest.test1;

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
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.sub(200, 100));
		
	
	}
	

}
