package j20_JSON.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	
	private String username;
	private String password;
	private String name;
	private String email;
	
	// 이거 쓸거면 @Allagsconstructor 써야함
//	public static UserBuilder builder() {
//		return new UserBuilder();
//	}
//	
////	public static UserBuilder builder() {				// userBuilder 생성에 static 붙이지 않으면 이런식으로 만들어야 함
////		return new User().new UserBuilder();
////	}
//	
//	@Data
//	public static class UserBuilder {
//		private String username;
//		private String password;
//		private String name;
//		private String email;
//		
//		public UserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//		
//		public UserBuilder password(String password) {
//			this.password = password;
//			return this;
//		}
//		
//		public UserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//		
//		public UserBuilder email(String email) {
//			this.email = email;
//			return this;
//		}
//		
//		public User build() {
//			return new User(username, password, name, email);
//		}
//	}
	
//	@Data
//	public class UserBuilder {				//내부 클래스(static)넣지 않으면
//		private String username;
//	}


}
