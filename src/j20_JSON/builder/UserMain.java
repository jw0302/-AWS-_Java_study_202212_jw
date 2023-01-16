package j20_JSON.builder;

public class UserMain {
	
	public static void main(String[] args) {
//		User user = new User();
		User.UserBuilder userBuilder = new User.UserBuilder();
//		User.UserBuilder userBuilder = new User().new UserBuilder();		// static을 넣지 않고 생성했을때는 이렇게 만들어야함
		
		User user2 = User.builder()
				.username("aaa")
				.password("1234")
				.name("진원")
				.build();
		
		System.out.println(user2);
	}

}
