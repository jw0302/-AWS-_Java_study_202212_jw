package examTest2.test2;

class School {
	private static School instance = null;
	private String schoolName;
	
	private School() {}
							
	public static School getInstance() {
		if(instance == null) {
			instance = new School();
		}
		return instance;
	}
}

public class Main2 {

}
