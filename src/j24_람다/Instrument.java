package j24_람다;

// @FunctionalInterface => 함수형 인터페이스다 라는 뜻 (람다형 인터페이스다.)
@FunctionalInterface
public interface Instrument {
	
	public String play(String instrument);
	
	
	// 람다식 인터페이스에서는 추상메소드 하나 밖에 올수 없지만 default문은 예외다 
	public default void testPrint() {
		System.out.println("테스트");
	}

}
