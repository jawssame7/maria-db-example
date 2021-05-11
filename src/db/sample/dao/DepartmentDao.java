package db.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.sample.entity.Department;

public class DepartmentDao {

	public List<Department> selectAll() {
		Connection conn = null;
		List<Department> list = new ArrayList<Department>();
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT ");
		sql.append("id, ");
		sql.append("name, ");
		sql.append("created, ");
		sql.append("modified, ");
		sql.append("deleted ");
		sql.append("FROM ");
		sql.append("departments ");
		
		// DBと接続
		try {
			conn = ConnectionManager.get();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setName(rs.getString("name"));
				dept.setCreated(rs.getTimestamp("created"));
				dept.setModified(rs.getTimestamp("modified"));
				dept.setDeleted(rs.getTimestamp("deleted"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				ConnectionManager.release(conn);
			}
		}
		return list;
	}
	
	// 1件取得 where句 id
	
	// 更新
	
	// 作成
	
	// 削除
}
