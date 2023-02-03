package examTest2.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList2 {
	public static void main(String[] args) {
		
//		List<String> colors = Arrays.asList("red", "green", "blue");
//		List<String> sizes = Arrays.asList("SS", "S", "M", "L", "XL");
//		Map<String, List<String>> options = new HashMap<>();
//		
//		options.put("색상", colors);
//		options.put("사이즈", sizes);
//		
//		for(Map.Entry<String, List<String>> entry : options.entrySet()) {
//			String key = entry.getKey();
//			List<String> values = entry.getValue();
//			System.out.print(key + "= ");
//			for(String value : values) {
//				System.out.print(value + ", ");
//			}
//			System.out.println();
//		}
		
		List<String> colors = new ArrayList<>();
		List<String> sizes = new ArrayList<>();
		Map<String, List<String>> options = new HashMap<>();
		
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		
		sizes.add("SS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");
		
		options.put("색상=", colors);
		options.put("사이즈=", sizes);
		
		for(Map.Entry<String, List<String>> entry : options.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println(key + " " + value.toString().replace("[", "").replace("]", ""));
			
		}
		
			
			
	}

}