package db.sample.main;

import java.sql.Connection;
import java.sql.SQLException;

import db.sample.dao.ConnectionManager;

public class ConnectionManagerMain {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionManager.get();
			ConnectionManager.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
