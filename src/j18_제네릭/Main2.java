package j18_제네릭;

public class Main2 {
	/*
	 *  ? 와일드카드 제약
	 *  extends 대상 객체 하위 	대체적으로 super보다 많이 쓴다.
	 *  super	대상 객체 상위
	 *  
	 *  제약을 안줄거면 그냥 ?만 쓰면 된다.
	 */
	
	
	//?를 와일드 카드라고 한다 / ?는 Object라고 보면 된다. Object는 모든게 업캐스팅 되는 최상위 클래스이기 때문에 
	public CMRespDto<?> reponse(CMRespDto<?> cmRespDto) { 	// reponse는 main2의 멤버 메소드 / 주소가 꼭 생성되어야만 사용가능
		System.out.println("[응답데이터]");
		System.out.println(cmRespDto);
		return cmRespDto;
	}
	
	public static void main(String[] args) {
		Main2 main = new Main2();						// Main2에 있는  reponse이라는 멤버 메소드를 main에서 쓰기 위해서 main2생성
		
		CMRespDto<String> hello 
			= new CMRespDto<String>(200, "성공", "안녕하세요");
		
		CMRespDto<Integer> score 
		= new CMRespDto<Integer>(200, "성공", 85);
		
		
//		CMRespDto<?> data = null;
//		data = main.reponse(hello); 
//		data = main.reponse(score);							//reponse의 멤버메소드에 제네릭이 String으로만 되어 있으면 score를 reponse 할순 없다 하려면 ?로 바꿔야 함
		System.out.println("hello");
		System.out.println(main.reponse(hello));
		
		System.out.println("score");
		System.out.println(main.reponse(score));
		// 안녕하세요.
	}

}
