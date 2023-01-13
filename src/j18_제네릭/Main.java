package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		TestData<?, ?> td = new TestData<>("김준일", 30);
		TestData<?, ?> td2 = new TestData<>("juw", 302.1);
		System.out.println(td);
		System.out.println(td2);
		
		CMRespDto<?> cm =
				new CMRespDto<>(200, "성공", td);
		
		System.out.println(cm);
	}  

}