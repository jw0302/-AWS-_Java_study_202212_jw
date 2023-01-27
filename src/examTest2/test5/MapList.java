package examTest2.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Information {
	private String name;
	private String rating;
	private int age;
	
	public String getName() {
		System.out.println("name=홍길동");
		return name;
	}

	public String getRating() {
		return rating;
	}

	public int getAge() {
		return age;
	}

	
}
public class MapList {
	
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		Information information = new Information();
		
		for (Map<String, Object> customer : customers) {
			System.out.println(customer.get(information.getName()));
			
		}
		System.out.println(information);
	}

}
