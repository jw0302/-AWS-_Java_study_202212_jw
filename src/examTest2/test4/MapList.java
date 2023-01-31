package examTest2.test4;

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
// vip  김기영 gold 30 35
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
		
		for (Map<String, Object> customer : customers) {
			
		}
	}

}
