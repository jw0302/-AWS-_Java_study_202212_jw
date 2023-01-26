package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermanagement.config.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 * UserDao						접근하는용도의 집합소
 */

public class UserRepository {
	
	private DBConnectionMgr pool;

	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}
	
	
	public int saveUser(User user) {
		int successCount = 0;
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			sql = "INSERT INTO user_mst VALUES(0, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	
	
	public int saveRoleDtl(RoleDtl roleDtl) {
		int successCount = 0;
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = pool.getConnection();
			
			sql = "INSERT INTO role_dtl VALUES (0, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());
			
			successCount = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return successCount;
	}
	
	
	public User findUserByUsername(String username) {
		User user = null;
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			sql = "SELECT \r\n"
					+ "	   um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "FROM\r\n"
					+ "	   user_mst um\r\n"
					+ "    LEFT OUTER JOIN role_dtl rd ON(rd.user_id = um.user_id)\r\n"
					+ "    LEFT OUTER JOIN role_mst rm ON(rm.role_id = rd.role_id)\r\n"
					+ "WHERE \r\n"
					+ "	   um.username = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			
			int i = 0;
			
			while(rs.next()) {
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.rolemst(roleMst)
						.build();
				
				roleDtls.add(roleDtl);
				
				i++;
			}
			
			if(user != null) {
				user.setRoleDtls(roleDtls);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	
	
	public User findUserByEmail(String email) {
		User user = null;
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			sql = "SELECT \r\n"
					+ "	   um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "FROM\r\n"
					+ "	   user_mst um\r\n"
					+ "    LEFT OUTER JOIN role_dtl rd ON(rd.user_id = um.user_id)\r\n"
					+ "    LEFT OUTER JOIN role_mst rm ON(rm.role_id = rd.role_id)\r\n"
					+ "WHERE \r\n"
					+ "	   um.email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			
			int i = 0;
			
			while(rs.next()) {
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.rolemst(roleMst)
						.build();
				
				roleDtls.add(roleDtl);
				
				i++;
			}
			
			if(user != null) {
				user.setRoleDtls(roleDtls);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	

}
