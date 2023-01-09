package j12_배열.di;

public class Test_A {
	
	private Test_B tb;
	
//	의존성이 높다 = 결합도가 높다	
	public Test_A(Test_B tb) {
		
		this.tb = tb;
		
	}
//	
//	public void setTb(Test_B tb) {
//		
//		this.tb = tb;
//		
//	}

	public void testA1() {
		
		System.out.println("테스트A1 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}	
	
	public void testA2() {
		
		System.out.println("테스트A2 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}
}

// 컴파일이 되면 무조건 정의는 일어난다