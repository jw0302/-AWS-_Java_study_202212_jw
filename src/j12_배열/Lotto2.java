package j12_배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Lotto2 {

	public static void main(String[] args) {
			
		System.out.println("[lotto 로또 프로그램 (랜덤 번호 생성 및 당첨 확인) - Random(임의)정수값 생성, while(true)로또 번호 저장, for문 당첨 확인 실시]");
		/*[설 명]
		 * 1. 로또 번호는 총 6개 번호를 지정한다
		 * 2. 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 그외 : 꽝 으로 정한다
		 * 3. Random 객체를 사용해서 난수 랜덤 정수값을 생성한다 (1 ~ 45 정수 까지 범위 지정)
		 * 4. while(true) 사용해서 중복없는 랜덤 정수값 배열에 저장합니다
		 * 5. for 문을 사용해서 두배열 일치 값 개수를 확인하고 등수를 출력합니다
		 * 6. 참고 사항 - 일반적으로 이중 for문을 사용해 간편히 랜덤 로또 번호를 저장할 수 있으나,
		 *             while 문을 사용해서 작성해 보았습니다
		 */
		
		//로또 당첨 정답 번호 배열입니다 (총 6개 정답번호가 저장되어있습니다)
		int lotto[] = {3, 5, 24, 32, 10, 9};
		System.out.println("로또 당첨 번호 : "+Arrays.toString(lotto));
		
		//랜덤 정수값을 생성하기 위해 Random 객체를 생성해줍니다
		Random random = new Random();
		
		//random 랜던 정수값을 담을 배열을 선언해줍니다
		int number[] = new int[6];
		Arrays.fill(number, 0); //배열에 초기 전체 데이터 0을 모두 대입시켜줍니다
		
		int idx = 0; //배열 번지 번호를 지정하기 위한 인덱스 변수값 생성
		while(true) { 
			int zero = 0; //0이 아닌값이 정상적으로 모두 저장된것인지 확인 위해 변수 선언
			for(int i=0; i<number.length; i++) {
				if(number[i] == 0) { //배열 각 번지를 전체 확인 하면서 0 값이 있을 경우 zero 값을 증가시킴니다
					zero ++;
				}
			}
			//zero 변수값이 카운트된게 없을 경우 정상적으로 값이 모두 대입된 것을 확인
			if(zero <= 0) {				
				break; //while 무한 루프를 탈출합니다				
			}			
			else { //배열에 랜덤 정수값을 다 저장하지 않은 경우 수행합니다	
				//랜덤 정수값 1부터 45범위까지 임의 정수를 저장합니다
				int random_number = random.nextInt(45)+1;
				
				//배열에 랜덤으로 생성된 값이 이미 저장되어 있으면 중복저장하지 않기위해 검사를 실시합니다
				int check = 0;
				for(int k=0; k<number.length; k++) {
					if(number[k] == random_number) {
						check ++; //배열 각 번지를 전체 확인 하면서 일치하는 정수값이 있을 경우 check 값을 증가시킴니다
					}
				}
				
				//이미 저장된 값이 없을 경우 배열에 데이터를 저장시킵니다
				if(check <= 0) {
					number[idx] = random_number;
					idx ++; //저장을 수행하기 위한 배열 번지값을 증가시킨 후 다시 while문을 반복합니다
				}				
			}
		}//while 문 종료
		
		System.out.println("사용자 로또 번호 : "+Arrays.toString(number));
		
		int count = 0;
		for(int j=0; j<lotto.length; j++) { //로또 정답 배열
			for(int h=0; h<number.length; h++) { //사용자 로또 번호 배열
				if(lotto[j] == number[h]) { 
					count ++; //사용자 로또 배열 값이 로또 정답 배열 값이랑 같은게 있을 경우 count 증가
				}
			}
		}
		
		System.out.println("맞힌 개수 : "+count);
		
		if(count == 6) {
			System.out.println("등수 : "+"1등 입니다");	
		}
		else if(count == 5) {
			System.out.println("등수 : "+"2등 입니다");
		}
		else if(count == 4) {
			System.out.println("등수 : "+"3등 입니다");
		}
		else {
			System.out.println("등수 : "+"꽝 ... 입니다");
		}
			
	}
	

}
