package j17_스태틱.싱글톤;

public class KIA {
	
	// 여기서부터
	private static KIA instance = null;
	
	private KIA() {}
	
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
