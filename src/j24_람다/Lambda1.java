package j24_람다;

public class Lambda1 {
	
	public static void main(String[] args) {
		
		//익명 클래스 (정의와 생성을 동시에 하는것)
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				
				return instrument + "을(를) 연주합니다.";
			}
		};
		
		/*
		 * 		람다를 쓰면 좋은점
		 * 		1. 지역변수를 람다안에서 쓸수 있다.
		 * 		2. 코드가 간결해진다.
		 */
		
		// 익명클래스를 람다식으로 바꾼것(==재정의한것) (람다도 정의와 생성 동시에 하는것) / 람다는 대상없이는 쓸수 없다(독립적X)
		// 람다를 쓸수 있는 인터페이스 조건 : 클래스안의 메소드가 추상메소드 딱 하나만 존재하는 인터페이스만 가능하다
		Instrument instrument2 = (String itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할수 있다.
		// 매개변수의 이름을 바꿀수 있다.
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다. (중괄호 생략하면서 return도 생략 가능) *람다에서 중괄호를 생략하면 return 또한 무조건 생략해야 한다.
		// 이때 리턴자료형이 정해져 있으면 리턴값으로 사용이 된다.
		// 익명 클래스를 최종적으로 바꿀수 있는 코드문
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		// 메인문안의 지역변수를 람다식 구현문 안에 들고와 쓸수 있다.
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;
		
		System.out.println(instrument6.play("기타"));
		
		System.out.println();
		
		System.out.println(instrument2.play("피아노"));
		
		String playText = instrument2.play("드럼");
		System.out.println(playText);
		
	}
}
