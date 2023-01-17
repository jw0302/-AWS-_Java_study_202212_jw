package J21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowException {
	
	public static void printList(List<String> list, int size) throws Exception {
		
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		String[] names = {"김수현", "이종현", "박성진", "김동민"};
		
		try {
//			throw new ClassCastException();
			printList(Arrays.asList(names), 5);
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행");					// 예외처리를 할때 Exception을 안 달아준 경우 (예외가 터지든 안터지든, 예외처리가 되든 무조건 실행)
		}
		
		System.out.println("프로그램 정상 종료");
	}

}
