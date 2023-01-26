package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usermanagement.entity.User;

public class UserInsert {
	
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveUser(User user) {
		
		int successCount = 0;
		
		String sql = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = pool.getConnection();
			
			sql = "INSERT INTO user_mst\r\n"
					+ "VALUES (0, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			successCount = preparedStatement.executeUpdate();	// insert, update, delete 명령 실행
			
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id key값: " + resultSet.getInt(1));
				user.setUserId(resultSet.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	public int saveRoles(Map<String, Object> map) {
		
		int successCount = 0;
		
		String sql = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.getConnection();
			List<Integer> roles = (List<Integer>) map.get("roles");
			User user = (User) map.get("user");
			
			sql = "INSERT INTO role_dtl VALUES";
			
			for(int i = 0; i < roles.size(); i++) {
				sql += "(0, ?, ?)";
				if(i < roles.size() - 1) {
					sql += ",";
				}
			}
			
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < roles.size(); i ++) {
				preparedStatement.setInt((i*2) + 1, roles.get(i));
				preparedStatement.setInt((i*2) + 2, user.getUserId());
			}
			
			successCount = preparedStatement.executeUpdate();
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return successCount;
	}

	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		User user = User.builder()
				.username("ccc")
				.password("1234")
				.name("ccc")
				.email("ccc@gmail.com")
				.build();
		
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user);
		
		/*=======================================================================*/
		
		List<Integer> roleIdList = new ArrayList<>();			// list -> 
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>();				// map -> 임시 엔티티 객체 , 해당 키값으로 바로 해당값을 불러오고 싶을때 쓴다
		map.put("user", user);
		map.put("roles", roleIdList);
		
		System.out.println(map);
		
		successCount = userInsert.saveRoles(map);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		

		

	}

}
