package jo9_클래스;

public class J09_UserMain {

	public static void main(String[] args) {
		
		J09_User num = new J09_User();
		
		num.username = "aaa";
		num.password = 1234;
		num.name = "장진원";
		num.email = "wkdwlsdnjs41@naver.com";
		
		num.printUserInfo();		
		
		J09_User num1 = new J09_User();
		
		num1.username = "asdf";
		num1.password = 4598;
		num1.name = "qkrwlswn";
		num1.email = "ghfjtm464659@nate.com";
		
		num1.printUserInfo();
		
		J09_User num2 = new J09_User();
		
		num2.username = "ddrt";
		num2.password = 5938;
		num2.name = "하나로";
		num2.email = "vmfh22@gmail.com";
		
		num2.printUserInfo();
		
		
	}

}
