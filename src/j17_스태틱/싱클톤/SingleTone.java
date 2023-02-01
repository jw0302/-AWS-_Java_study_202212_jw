package j17_스태틱.싱클톤;

public class SingleTone {
	
	/*
	 * 		print()가 들어 있는 A라는 메소드가 있을때 이걸 쓸려면 
			생성을 먼저 해야 한다
			a = new A()
			a.print

			B - test1() 메소드와 C - test2() 메소드에서 
			A메소드를 쓸때마다 생성을 계속해줘야 함

			== 이렇게 쓰면 쓸때마다 A클래스를 생성해줘야 해서 번거로움



	 		*스태틱*

			자기 자신을 불러올수 있는 static ~~  instance로 A 생성함
			1. private static A instance;
			A  Getter생성
			2.public static A getInstance()
			다른 곳에서 또 생성하지 않도록 닫아준다.
			3.private A(){}
	 */

}
