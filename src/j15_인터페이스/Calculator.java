package j15_인터페이스;

// 인터페이스 클래스에 대한 설명 (구현 가능한 클래스 아님)
public interface Calculator {
	
	public int ERROR = -9999999;			// 인터페이스는 상수만 가질수 있기 때문에 final을 쓰지 않고도 이렇게 쓸 수 있다.
	
	// 인터페이스 클래스에서는 메소드를 만들때 중괄호를 넣지 않아도 오류가 아니다.
	public double plus(double x, double y);
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) {				// 일반 메소드를 쓰기 위해서는 default를 넣어야 일반 메소드 생성 가능
		
		return x * y;														// 일반변수는 절대 가질수 없다, 상수는 가능
	}
	
	public double division(double x, double y);

}
