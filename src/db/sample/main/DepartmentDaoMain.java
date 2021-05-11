package db.sample.main;

import java.util.List;

import db.sample.dao.DepartmentDao;
import db.sample.entity.Department;

public class DepartmentDaoMain {

	public static void main(String[] args) {
		
		DepartmentDao dao = new DepartmentDao();
		List<Department> list = dao.selectAll();

		for (Department department : list) {
			System.out.println(department.getName());
			System.out.println(department.getId());
		}
	}

}
