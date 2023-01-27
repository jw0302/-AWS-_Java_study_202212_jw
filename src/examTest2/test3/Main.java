package examTest2.test3;

class Factory {
	private String factoryName;
	private static Factory instance = null;
	
	private Factory() {}
							
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
}

public class Main {

}
