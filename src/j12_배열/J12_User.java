package j12_배열;

// Entity
public class J12_User {
	
	private String username;	// 사용자이름(아이디), 계정)
	private String password;	// 비밀번호 
	private String name;		// 성명
	private String email;		// 이메일
//	private String findUser;
//	private String updateUser;
	
	public J12_User() {}			// ctrl + space : 아무것도 입력하지 않은 상태에서 누르면 자동 생성
	
	// alt + shift + s -> Generate constructor using fields 클릭 -> 전체 선택 후 확인
	public J12_User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	// alt + shift + s -> Generate Getters and Setters 클릭 -> 전체 선택 후 확인
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// alt + shift + s -> Generate toSpring()... 클릭 -> 아무것도 선택하지 않고 확인
	@Override
	public String toString() {
		return "J12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	

}
