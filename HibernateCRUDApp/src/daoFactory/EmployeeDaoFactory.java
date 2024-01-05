package daoFactory;

import dao.EmployeeDAOImpl;
import dao.IEmployeeDAO;

public class EmployeeDaoFactory {
	private EmployeeDaoFactory() {

	}

	private static IEmployeeDAO employeeDao;

	public static IEmployeeDAO getEmployeeDao() {
		if (employeeDao == null) {
			employeeDao = new EmployeeDAOImpl();
		}
		return employeeDao;
	}
}
