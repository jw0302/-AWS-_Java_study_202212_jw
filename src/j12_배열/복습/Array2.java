package j12_배열.복습;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String password;
}


public class Array2 {
	
	public static void main(String[] args) {
		
		User user1 = new User("aaa", "1111");	
		User user2 = new User("bbb", "2222");
		User user3 = new User("ccc", "3333");
		
		User[] users1 = new User[] {new User("aaa", "1111"), new User("bbb", "2222"), new User("ccc", "3333")};
		
		User[] users2 = new User[3];
		users2[0] = new User("aaa", "1111");
		users2[1] = new User("bbb", "2222");
		users2[2] = new User("ccc", "3333");
		
		// 두가지다 같은 말이다.
		
		User[] users3 = new User[] {
				new User("aaa", "1111"),
				new User("bbb", "2222"),
				new User("ccc", "3333")				
		};
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		
		System.out.println();
		// 두가지 다 출력값이 같다.
		
		for(int i = 0; i < users1.length; i++) {
			System.out.println(users1[i].getUsername());
		}
		
		System.out.println();
		
		for(User u : users2) {
			System.out.println(u);
		}
		
		System.out.println();
		
		List<User> userList = Arrays.asList(users3);
		System.out.println(userList);
		
		System.out.println();
		
		Integer[] integers = new Integer[] {10, 20, 30, 40, 50};
		
		List<Integer> integerList = Arrays.asList(integers);
		System.out.println("출력=> " + integerList);
		
		
	}

}
