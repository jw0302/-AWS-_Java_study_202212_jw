package examTest.test5;

class User {
	private String username;
	private String password;
	private String name;
	private String email;
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}

public class UserMain {
	public static void main(String[] args) {
		User user = new User("junil", "1234", "김준일", "junil@gmail.com");
		
		System.out.println("[사용자 정보]");
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("name: " + user.getName());
		System.out.println("email: " + user.getEmail());
	}

}
