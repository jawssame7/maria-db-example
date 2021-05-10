package db.sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import db.sample.entity.Test;

public class TestDao {
	
	public List<Test> getAll() throws SQLException {
		
		List<Test> list = new ArrayList<Test>();
		
		
		// DBと接続
		Connection conn = ConnectionManager.get();
		// SQL
		String sql = "SELECT name, id, created, updated FROM test";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Test test = new Test();
			// get+型(カラム名orインデックス)
			// rs.getString(1);
			test.setId(rs.getInt("ID"));
			test.setName(rs.getString("NAME"));
			test.setCreated(rs.getTimestamp("CREATED"));
			list.add(test);
		}
		
		ConnectionManager.release(conn);
		// 接続を閉じる
		ps.close();
		conn.close();
		
		return list;
	}

//	/**
//	 * テストテーブルの内容を全て取得
//	 * @return
//	 * @throws SQLException
//	 */
//	public List<Test> getAll() throws SQLException {
//		
//		List<Test> list = new ArrayList<Test>();
//		
//		// SQL
//		String sql = "SELECT * FROM test";
//		// DBと接続
//		Connection conn = ConnectionManager.get();
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//		
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			Test test = new Test();
//			// get+型(カラム名orインデックス)
//			// rs.getString(1);
//			test.setId(rs.getInt("ID"));
//			test.setName(rs.getString("NAME"));
//			test.setCreated(rs.getDate("CREATED"));
//			list.add(test);
//		}
//		
//		ConnectionManager.release(conn);
//		// 接続を閉じる
//		ps.close();
//		conn.close();
//		
//		return list;
//		
//	}
//	
//	/**
//	 * 指定されたIDのデータを取得
//	 * @param id
//	 * @return
//	 * @throws SQLException
//	 */
//	public List<Test> getById(int id, boolean sort)  throws SQLException {
//		List<Test> list = new ArrayList<>();
//		
//		// SQL
//		//String sql = "SELECT * FROM test WHERE ID = " + id;
////		StringBuffer sqlBuf = new StringBuffer();
////		sqlBuf.append("SELECT ");
////		sqlBuf.append("* ");
////		sqlBuf.append("FROM ");
////		sqlBuf.append("test ");
////		sqlBuf.append("WHERE ");
////		sqlBuf.append("ID = ");
////		sqlBuf.append(id);
//		
//		StringBuffer sql = new StringBuffer();
//		
//		sql.append("select ");
//		sql.append("id, ");
//		sql.append("name, ");
//		sql.append("created ");
//		sql.append("from ");
//		sql.append("test ");
//		if (sort) {
//			sql.append("order by created ");
//		}
//		
//		
//		//String sql = "SELECT * FROM test WHERE ID=?";
//		// DBと接続
//		Connection conn = ConnectionManager.get();
//		
//		PreparedStatement ps = conn.prepareStatement(sql.toString());
//		// ?に対してパラメータを設定
//		// set+型(何番目, 変数)
//		ps.setInt(1, id);
//		
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			Test test = new Test();
//			// get+型(カラム名orインデックス)
//			// rs.getString(1);
//			test.setId(rs.getInt("ID"));
//			test.setName(rs.getString("NAME"));
//			test.setCreated(rs.getTimestamp("CREATED"));
//			list.add(test);
//		}
//		
//	}
//		
//		ConnectionManager.release(conn);
//		// 接続を閉じる
//		ps.close();
//		conn.close();
//		
//		return list;
//	}
//	
//	/**
//	 * 更新処理
//	 * @param id
//	 * @param name
//	 * @return
//	 * @throws SQLException
//	 */
//	public int update(int id, String name) throws SQLException {
//		int updateCnt = 0;
//		
//		String sql = "UPDATE test SET name=? WHERE id=?";
//		
//		// DBと接続
//		Connection conn = ConnectionManager.get();
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//
//		ps.setString(1, name);
//		ps.setInt(2,  id);
//		// 更新 executeUpdate
//		updateCnt = ps.executeUpdate();
//		
//		return updateCnt;
//	}
	
}
