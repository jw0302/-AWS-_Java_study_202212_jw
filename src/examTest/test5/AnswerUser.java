package examTest.test5;

class User2 {
	private String username;
	private String password;
	private String name;
	private String email;
	
	public User2(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "[사용자 정보]" 
				+ "\nusername: " + username 
				+ "\npassword: " + password 
				+ "\nname: " + name 
				+ "\nemail: " + email;
	}
}

public class AnswerUser {
	public static void main(String[] args) {
		User2 user = new User2("junil", "1234", "김준일", "junil@gmail.com");
		System.out.println(user);
	}

}
