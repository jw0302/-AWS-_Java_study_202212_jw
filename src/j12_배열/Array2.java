package j12_배열;

public class Array2 {
	
	// 메소드 사용
	public static void printNames(String[] names) {
		
		for (int i = 0; i < names.length; i++) { // names.length 이름의 길이 
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		String[] names = new String[3];
		
		names[0] = "김상현";
		names[1] = "엄근진";
		names[2] = "김종로";
		
		String[] names2 = new String[] {"징징이", "손가락", "이리온"};
		String[] names3 = {"징징이", "손가락", "이리온", "김재수"}; // 배열의 선언과 초기화를 할때만 허용 평소엔 절대 허용하지않은 문장
		
		printNames(names);
		printNames(new String[] {"징징이", "손가락", "이리온"});
		printNames(names3);
	}

}
/*
 * 2번과 3번 방법은 크기를 지정해주지 않는다
 */










