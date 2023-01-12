package j17_스태틱.싱클톤;

public class KIA {
	
	// 여기서부터
	private static KIA instance = null;
		
	private KIA() {}					// 싱글톤은 딱 하나만 존재해야 하기 때문에 생성자가 private이다.
		
	public static KIA getInstance() {
		if(instance == null) {
			instance = new KIA();
		}
		return instance;
	}									// 여기까지 싱글톤 필수
		
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
}
