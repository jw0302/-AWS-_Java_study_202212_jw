package j07_반복;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		String name = "장진원";
//		System.out.println(name.charAt(0));
		
		boolean loopFlag1 = true;
		
		while (loopFlag1) {
			char select = '\0';
			
			System.out.println("========<< 식당 메뉴 >>========");
			System.out.println("1. 김밥천국");
			System.out.println("2. 탄탄면");
			System.out.println("3. 홍대개미");
			System.out.println("4. 밤앤밥");
			System.out.println("===============================");
			System.out.println("q. 프로그램 종료");
			System.out.println("===============================");
			
			System.out.print("식당 번호 선택: ");
			select = scanner.next().charAt(0);
			
			if (select == 'q' || select == 'Q') {
				loopFlag1 = false;
				
			}else if (select == '1') {
				boolean loopFlag2 = true;
				
				while (loopFlag2) {
				
					System.out.println();
					System.out.println("========<< 김밥천국 >>========");
					System.out.println("1. 라면");
					System.out.println("2. 돌솥비빔밥");
					System.out.println("3. 오므라이스");
					System.out.println("4. 김치볶음밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
				
				System.out.print("메뉴 번호 선택: ");
				select = scanner.next().charAt(0);
				
				
				if (select == 'b') {
					loopFlag2 = false;
					
				}else if (select == 'q' || select == 'Q') {
					loopFlag1 = false;
					loopFlag2 = false;
					
				}else if (select == '1') {
					System.out.println("라면을 선택했습니다. ");
				}else if (select == '2') {
					System.out.println("돌솥비빔밥을 선택했습니다. ");
				}else if (select == '3') {
					System.out.println("오므라이스을 선택했습니다. ");
				}else if (select == '4') {
					System.out.println("김치볶음밥을 선택했습니다. ");
				}else {
					System.out.println();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("사용할 수 없는 번호입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
				
				System.out.println();
			
				}
			}else if (select == '2') {
				boolean loopFlag3 = true;
				
				while (loopFlag3) {
					
					System.out.println();
					System.out.println("========<< 탄탄면 >>========");
					System.out.println("1. 탄탄면");
					System.out.println("2. 청양탄탄면");
					System.out.println("3. 사천탄탄면");
					System.out.println("4. 마라탄탄면");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
				
				System.out.print("메뉴 번호 선택: ");
				select = scanner.next().charAt(0);
				
				
				if (select == 'b') {
					loopFlag3 = false;
					
				}else if (select == 'q' || select == 'Q') {
					loopFlag1 = false;
					loopFlag3 = false;
					
				}else if (select == '1') {
					System.out.println("탄탄면을 선택했습니다. ");
				}else if (select == '2') {
					System.out.println("청양탄탄면을 선택했습니다. ");
				}else if (select == '3') {
					System.out.println("사천탄탄면을 선택했습니다. ");
				}else if (select == '4') {
					System.out.println("마라탄탄면을 선택했습니다. ");
				}else {
					System.out.println();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("사용할 수 없는 번호입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
				
				System.out.println();
				}
			}else if (select == '3') {
				boolean loopFlag4 = true;
				
					while (loopFlag4) {
					
					System.out.println();
					System.out.println("========<< 홍대개미 >>========");
					System.out.println("1. 연어덮밥");
					System.out.println("2. 대창덮밥");
					System.out.println("3. 소불고기덮밥");
					System.out.println("4. 닭가슴살덮밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
				
				System.out.print("메뉴 번호 선택: ");
				select = scanner.next().charAt(0);
				
				
				if (select == 'b') {
					loopFlag4 = false;
					
				}else if (select == 'q' || select == 'Q') {
					loopFlag1 = false;
					loopFlag4 = false;
					
				}else if (select == '1') {
					System.out.println("연어덮밥을 선택했습니다. ");
				}else if (select == '2') {
					System.out.println("대창덮밥을 선택했습니다. ");
				}else if (select == '3') {
					System.out.println("소불고기덮밥을 선택했습니다. ");
				}else if (select == '4') {
					System.out.println("닭가슴살덮밥을 선택했습니다. ");
				}else {
					System.out.println();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("사용할 수 없는 번호입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
				
				System.out.println();
				}
			}else if (select == '4') {
				boolean loopFlag5 = true;
				
				while (loopFlag5) {
					
					System.out.println();
					System.out.println("========<< 밤앤밥 >>========");
					System.out.println("1. 소고기미역국");
					System.out.println("2. 뚝배기불고기");
					System.out.println("3. 얼큰순두부");
					System.out.println("4. 제육볶음");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
				
				System.out.print("메뉴 번호 선택: ");
				select = scanner.next().charAt(0);
				
				
				if (select == 'b') {
					loopFlag5 = false;
					
				}else if (select == 'q' || select == 'Q') {
					loopFlag1 = false;
					loopFlag5 = false;
					
				}else if (select == '1') {
					System.out.println("소고기미역국을 선택했습니다. ");
				}else if (select == '2') {
					System.out.println("뚝배기불고기을 선택했습니다. ");
				}else if (select == '3') {
					System.out.println("얼큰순두부을 선택했습니다. ");
				}else if (select == '4') {
					System.out.println("제육볶음을 선택했습니다. ");
				}else {
					System.out.println();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("사용할 수 없는 번호입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
				
				System.out.println();
				}
				
			}else {
				System.out.println();
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("사용할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요.");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
			
			System.out.println();
		}
		
		System.out.println("프로그램 정상 종료!");

	}

}
