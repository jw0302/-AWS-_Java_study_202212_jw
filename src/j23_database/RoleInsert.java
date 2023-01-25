package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool;
	// DB클래스를 쓰기 위해 불러옴
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	// 이 클래스 안에서 자유롭게 쓰기위해 메소드선언해줌
	
	public int saveRole(String roleName) {
		int successCount = 0;				// successCount 라는 변수 선언
		
		String sql = null;					// sql 변수 선언
		Connection con = null;				// connection 인터페이스의 기능을 쓰기 위해 들고와서 con이라는 변수로 선언
		PreparedStatement pstmt = null;		// connection 과 이유 동일
		
		try {								// 시도해라
			con = pool.getConnection();
			sql = "INSERT INTO role_mst VALUES (0, ?)";									// sql변수에 값 선언하기
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, roleName);
			
			successCount = pstmt.executeUpdate();										
			// pstmt에 excuteUpdate값을 불러와라 (excuteUpdate는 SQL문을 실행할때 사용하는 메소드로 insert,update,delete 문을 실행할때 사용한다) 불러온 값을 successCount에 넣어라 
			
			int newKey = 0;																// newKey 변수 생성 
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				newKey = rs.getInt(1);
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
			
		} catch (Exception e) {				// try에서 실행한것중 에러가 있으면 잡아라
			e.printStackTrace();
		}
		
		
		
		return successCount;
	}
	// 메인문 (메인문에 적힌게 실제로 실행될것들)
	public static void main(String[] args) {
		
		RoleInsert roleInsert = new RoleInsert();
		
		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: " + successCount);
		
		
		
	}

}
