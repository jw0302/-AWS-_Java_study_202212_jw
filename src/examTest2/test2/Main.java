package examTest2.test2;

// 여기서부터
class Factory {
	private static Factory instance = null;
	private String factoryName;
	
	private Factory() {}
							
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
}		// 여기까지가 싱클톤

public class Main {

}
