package j19_컬렉션;

import java.util.ArrayList;

public class LostStringMain {
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"java","python", "C++"};
		
		String[] strArray2 = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length; i++) {
			strArray2[i] = strArray[i];
		}
		
		strArray2[strArray.length] = "html";
		
		System.out.println("[strArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("[strArray2]");
		for(String str : strArray2) {
			System.out.println(str);
		}
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////
		// <컬렉션>
//		new ArrayList<>().add("test");
		ArrayList<String> strList = new ArrayList<>();					// 넣는만큼 공간이 늘어난다.
		strList.add("java");
		strList.add("python");
		strList.add("python");
		strList.add("java");
		strList.add("python");
		strList.add("python");
		strList.remove("java");
		strList.add(4, "java");
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i + "]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		
		
	}
	
}
// "html" 을 맨 마지막에 붙여보기

