package examTest2.test4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList2 {
	public static void main(String[] args) {
		
		List<String> colors = null;
		List<String> sizes = null;
		Map<String, List<String>> options = new HashMap<>();
		
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		
		sizes.add("SS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");
		
		Map<String, List<String>> option1 = new HashMap<>();
		option1.put("색상=", colors);
		
		Map<String, List<String>> option2 = new HashMap<>();
		option2.put("사이즈=", sizes);
		
		for(Map.Entry<String, List<String>> entry : options.entrySet()) {
			System.out.println(entry.getKey());
		}
			
			
	}

}
