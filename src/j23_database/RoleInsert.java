package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool;
	// DB클래스를 쓰기 위해 불러옴
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();											// DB에 들어가는 인원을 제한하는 역할이 pool이다 * DBConnectionMgr -> 싱글톤
	}
	// 이 클래스 안에서 자유롭게 쓰기위해 메소드선언해줌
	
	public int saveRole(String roleName) {
		int successCount = 0;				// successCount 라는 변수 선언
		
		String sql = null;					// sql 변수 선언 * 연결한 SQL에서 실행시킬 커리문을 저장해놓는 역할
		Connection con = null;				// connection 인터페이스의 기능을 쓰기 위해 들고와서 con이라는 변수로 선언 * connection -> DB와 연결시켜주는 역할
		PreparedStatement pstmt = null;		// connection 과 이유 동일 * preparedStatement -> DB 커리 실행하기 위한 역할 / 커리문의 물음표도 해결해주는 역할
		ResultSet rs = null;
		
		try {								// 시도해라
			con = pool.getConnection();													
			sql = "INSERT INTO role_mst VALUES (0, ?)";									// sql변수에 커리문 넣어주기
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, roleName);
			
			successCount = pstmt.executeUpdate();										
			// pstmt에 excuteUpdate값을 불러와라 (excuteUpdate는 SQL문을 실행할때 사용하는 메소드로 insert,update,delete 문을 실행할때 사용한다) 불러온 값을 successCount에 넣어라 
			
			int newKey = 0;																// newKey 변수 생성 
			
			if(rs.next()) {
				newKey = rs.getInt(1);
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
			
		} catch (Exception e) {				// try에서 실행한것중 에러가 있으면 잡아라
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
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
