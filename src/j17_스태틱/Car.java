package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear();
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;
	
	private String serialCode;				// KIA-2023-0000
	private String modelName;
	
	public Car(String modelName) {
		serialCode = CODE + String.format("%04d", ai);
		this.modelName = modelName;
		ai++;
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//내가 만든 코드
	
	
////	private static String CODE = "KIA-2023-";
//	private static String CODE = "KIA-2023-000";
//	private static int ai = 1;	// auto_increment(자동 증가)
//	
//	private String serialCode;		//static 써서 serialCode 자동주입되게 만들기    : KIA-2023-0000
//	private String modelName;
//	
//	public Car(String modelname) {
////		serialCode = CODE + String.format("%04d", ai);
//		serialCode = CODE + ai;
//		ai++;
//		
//		this.modelName =modelname;
//		
//	}
//	
//	public static int getAutoIncrement() {
//		System.out.println("현재 AI : " + ai);
//		return ai;
//	}
//
//	@Override
//	public String toString() {
//		return "Car [serialCode=" + serialCode + ", 모델명=" + modelName + "]";
//	}
	
	
}
