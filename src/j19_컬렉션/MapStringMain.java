package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapStringMain {
	
	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		
//		strMap.put("진채희", "a");
//		strMap.put("김재영", "b");
//		strMap.put("이상현", "c");
//		strMap.put("임루아", "d");
		
		strMap.put("ai", "가나");
		strMap.put("bi", "나나");
		strMap.put("ci", "다나");
		strMap.put("di", "라나");
		
		System.out.println(strMap);
		
//		System.out.println(strMap.get("김재영"));
		System.out.println(strMap.get("ci"));
		System.out.println(strMap.get("e"));
		
		for(String k : strMap.keySet()) {
			System.out.println("key : " + k);
			System.out.println(strMap.get(k));
//			System.out.println(k);
		}
		
		Set<Entry<String, String>> s = null;
		
		for(String v : strMap.values()) {
			System.out.println("value : " + v);
		}
		
		for(Entry<String, String> entry : strMap.entrySet()) {
//			System.out.println(entry);
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("==============================================");
		strMap.forEach((k, v) -> {
			System.out.println("key : " + k);
			System.out.println("value : " + v);
		});
	}

}
