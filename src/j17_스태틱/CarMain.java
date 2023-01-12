package j17_스태틱;

public class CarMain {
	
	public static void main(String[] args) {
		
		Car[] cars = new Car[3];
		
		cars[0] = new Car("스포티지");
		cars[1] = new Car("셀토스");
		cars[2] = new Car("K5");
		
		for(Car c : cars) {
			System.out.println(c);
		}
		
		
//////////////////////////////////////////////////////////////		

		//내가 만든 코드
		
//		Car[] cars = new Car[5];
//		
//		cars[0] = new Car("스포티지");
//		cars[1] = new Car("셀토스");
//		cars[2] = new Car("K5");
//		cars[3] = new Car("스팅어");
//		cars[4] = new Car("쏘렌토");
//		
//		for(Car c : cars) {
//			System.out.println(c);
//		}
//		
//		System.out.println(Car.getAutoIncrement());
		
	}

}
