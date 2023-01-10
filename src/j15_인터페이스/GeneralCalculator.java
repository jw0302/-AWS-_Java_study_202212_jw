package j15_인터페이스;

// implements(도구) = 이 클래스를 여기에 장착하겠다. /상속가 다르게 도구의 의미를 가지고 있기 때문에 여러 클래스에 쓸수 있음
public class GeneralCalculator extends Equipment implements Calculator {

	@Override
	public void powerOn() {
		System.out.println("일반 계산기 전원을 켭니다. ");
	}

	@Override
	public void powerOff() {
		System.out.println("일반 계산기 전원을 끕니다. ");
	}

	@Override
	public double plus(double x, double y) {
		System.out.println("일반계산기에서 더하기 실행");
		return x + y;
	}

	@Override
	public double minus(double x, double y) {
		System.out.println("일반계산기에서 빼기 실행");
		return x - y;
	}
	
	@Override
	public double division(double x, double y) {
		System.out.println("일반계산기에서 나누기 실행");
		
		if(x == 0 || y == 0) {
			return ERROR;
		}
		
		return x / y;
	}
	
	

}
