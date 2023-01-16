package j07_반복;

public class Loop1 {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 3);
		}	
		
		
	}
	
}
/*
  for (1.int i = 0; 2.i < 10; ++i) {
			3.System.out.println(i);
			}
 	1번 2번 3번 순으로 진행된다
 	-프로그램은 항상 0부터 시작한다 int i = 0;
 	int i = 0; 건들지 말기 0은 건들지 않아야 함
 
			System.out.println(i + 1);
			
			결과를 1~10으로 나타내고 싶으면 이렇게 한다 
			10번 반복한다는 변함이 없지만 시작점이 1인가 0인가를 저런식으로 나타냄
 */
// 지역의 기준은 중괄호 for (int i = 0; i < 10; i++) { ~~~ i는 for문 안에서만 쓸 수 있다
// for문 밖에서 변수 선언을 하면 for문 안에서는 쓸수 없다 
// 다만, 프로그래밍은 순서가 중요해 for문 뒤에 쓰면 가능함(*잘 안쓰는 방법)
// int i = 0;선언과 초기화, i < 100;조건, i++탈출 조건에 대한 변화 수식
// for (int i = 0; j = 0;, k = 0; -----) 여러개의 선언 가능,
// for (------i < 10; j > 10; k < 100; -----)조건도 여러개 가능,
// for (------- i++, j++, k+-2)변화 수식 또한 여러개 입력 가능