package service;

import dao.IEmployeeDAO;
import daoFactory.EmployeeDaoFactory;
import dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDAO employeeDao;

	@Override
	public boolean addEmployee(String name, String dept, int salary) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.addEmployee(name, dept, salary);
	}

	@Override
	public boolean deleteEmployee(int id) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee searchEmployee(int id) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.searchEmployee(id);
	}

	@Override
	public boolean updateEmployeeDetails(int id, String name, String dept, int salary) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.updateEmployeeDetails(id, name, dept, salary);
	}

}
