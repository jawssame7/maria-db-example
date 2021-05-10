package db.sample.main;

import java.sql.SQLException;
import java.util.List;

import db.sample.dao.TestDao;
import db.sample.entity.Test;

public class TestDaoMain {

	public static void main(String[] args) {
		
		List<Test> list = null;
		
		TestDao dao = new TestDao();
		
		try {
			list = dao.getAll();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for (Test test : list) {
			System.out.println(test.getId());
			System.out.println(test.getName());
			System.out.println(test.getCreated());
		}
		
//		try {
//			dao.update(2, "名前");
//			list = dao.getById(2);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		for (Test test : list) {
//			System.out.println(test.getId());
//			System.out.println(test.getName());
//			System.out.println(test.getCreated());
//		}
	}

}
