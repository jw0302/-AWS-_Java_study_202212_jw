package j13_상속.casting2;

public class Main {
	
	public static void main(String[] args) {
		
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
//		Transportation transportation = new Transportation();
//		Taxi t1 = (Taxi) transportation;		// 다운캐스팅
//		
//		Transportation transportation1 = taxi;
//		Subway s1 = (Subway) transportation1;	// 이렇게 만들면 안됨
//		
//		Transportation transportation2 = subway;
		
		Transportation[] transportations = new Transportation[6]; 
		
		transportations[0] = taxi;
		transportations[1] = subway;
		transportations[2] = taxi;
		transportations[3] = subway;
		transportations[4] = taxi;
		transportations[5] = subway;
		
		for(int i = 0; i < transportations.length; i++) {
			
			if(transportations[i] instanceof Taxi) {						// instanceof : 실제로 생성된 객체
				Taxi tx = (Taxi) transportations[i];
				tx.checkTaxiNumber();
				
			}else if(transportations[i] instanceof Subway) {
				Subway sw = (Subway) transportations[i];
				sw.checkRoute();
				
			}
			
//			Taxi tx = (Taxi) transportations[i];	// 0번 인덱스가 택시라 택시에 다운캐스팅은 가능하나 문제는 다음 인덱스로 1이 오면 서브웨이라 다운캐스팅 안됨
			
			transportations[i].go();
		}
		
		// for each문 
		for(Transportation t : transportations) {
			t.stop();
		}
		
	}

}
