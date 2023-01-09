package j12_배열;

// 저장소 (데이터를 저장하기 위한 역할들만 모아놓았다 응집도 높음)
public class J12_UserRepository {
	
	private J12_User[] userTable;

	public J12_UserRepository(J12_User[] userTable) {
		this.userTable = userTable;
	}
	
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;		
	}
	
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length]; // int length 를 매개변수로 넣으면 2가올수도 있고 3이 올수도 있다.
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
		
	}
	
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);		
		userTable = newArray;
		
	}
	
	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public J12_User findUserByUsername(String username) { 		
		
		J12_User user = null;
		
		for (J12_User u : userTable) {
			if ( u == null) { 					// 항상 null 체크는 해야한다
				continue;
			}
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	


}






