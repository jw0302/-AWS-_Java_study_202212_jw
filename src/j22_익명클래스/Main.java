package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		
		Calculator c1 = new Addition();
		System.out.println(c1.calc(10, 20));
//////////////////////////////////////////////////////////////////		
		
		//	익명 클래스(Calculator로 생성한 클래스 객체 but 이름을 넣지 않아 일회성으로 사용 )
		Calculator c2 = new Calculator() {
			
			@Override
			public int calc(int x, int y) {
				
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
	}

}
