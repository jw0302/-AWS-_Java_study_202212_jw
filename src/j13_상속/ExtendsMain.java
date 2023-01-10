package j13_상속;

public class ExtendsMain {
	
	public static void main(String[] args) {
		
		KiaCar kiaCar = new KiaCar();
		
		kiaCar.setPrice(30000000);
		
		System.out.println(kiaCar);
		
		System.out.println(kiaCar.getPrice());
		
		System.out.println(kiaCar.discountPrice(20));
		
		
	}

}

// 부모가 가지고 있는 메소드를 자식 클래스에 정의해주는 것을 오버라이딩 이라고 한다
// 재정의 : 부모가 가지고 있는 메소드 이긴 하지만 내가 쓰고 싶은 값으로 쓸 수 있다는 뜻 -> 오버라이드
// 클래스는 자료형 -> 업캐스팅 다운캐스팅이 가능하다
// char < int < double