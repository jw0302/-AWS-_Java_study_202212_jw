package j16_Object;

class Test {
	
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(num + "객체 소멸");
	}
	
}

public class ObjectFinalize {
	
	public static void main(String[] args) {
		
		Test test = null;
		
		for(int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			test = new Test(i);
			
			test = null;
			
			System.gc(); 					//gc = 가비지 컬렉터를 뜻함, System.gc(); 가비지 컬렉터를 호출해라, 메모리 상황에 따라 랜덤으로 소멸시키는 역할
		}
		
	}

}
